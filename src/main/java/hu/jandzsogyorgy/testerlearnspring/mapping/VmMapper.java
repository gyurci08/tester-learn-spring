package hu.jandzsogyorgy.testerlearnspring.mapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hu.jandzsogyorgy.testerlearnspring.dto.VmDto;
import hu.jandzsogyorgy.testerlearnspring.entity.Vm;
import org.json.JSONObject;
import org.mapstruct.Mapper;

import java.util.Map;


@Mapper(config = MappingConfig.class)
public interface VmMapper extends GenericMapper<Vm, VmDto> {

}
