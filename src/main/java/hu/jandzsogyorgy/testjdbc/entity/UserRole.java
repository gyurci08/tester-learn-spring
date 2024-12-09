package hu.jandzsogyorgy.testjdbc.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class UserRole {
    @Id
    private Long id;
    private Long user_id;
    private Long role_id;
}
