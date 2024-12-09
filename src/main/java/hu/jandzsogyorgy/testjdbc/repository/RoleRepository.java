package hu.jandzsogyorgy.testjdbc.repository;

import hu.jandzsogyorgy.testjdbc.entity.Role;
import hu.jandzsogyorgy.testjdbc.entity.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends ListCrudRepository<Role, Long> {

}
