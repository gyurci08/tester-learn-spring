package hu.jandzsogyorgy.testerlearnspring.mapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface JsonMapper<E> {
    default E jsonToEntity(Object obj) {
        ObjectMapper jsonMapper = new ObjectMapper();
        try {
            JSONObject json;
            if (obj instanceof Map) {
                json = new JSONObject((Map<?, ?>) obj);
            } else if (obj instanceof JSONObject) {
                json = (JSONObject) obj;
            } else {
                throw new IllegalArgumentException("Unexpected object type: " + obj.getClass().getName());
            }
            return jsonMapper.readValue(json.toString(), getEntityClass());
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error parsing JSON to entity", e);
        }
    }

    default List<E> jsonToEntity(List<Object> objects) {
        if (objects == null) {
            return List.of();
        }

        return objects.stream()
                .map(this::jsonToEntity)
                .collect(Collectors.toList());
    }

    Class<E> getEntityClass();
}
