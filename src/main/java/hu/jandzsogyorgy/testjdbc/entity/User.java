package hu.jandzsogyorgy.testjdbc.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;
import java.util.Set;

@Table("appuser")
@Data
public class User {
    @Id
    private Long id;
    private String username;
    private String password;

    @MappedCollection(idColumn = "id", keyColumn = "id")
    private List<Role> roles;
}
