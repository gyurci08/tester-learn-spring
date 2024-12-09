package hu.jandzsogyorgy.testjdbc.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.List;

@Data
public class Role {
    @Id
    private Long id;
    private String name;

    @MappedCollection(idColumn = "id", keyColumn = "id")
    private List<User> users;
}
