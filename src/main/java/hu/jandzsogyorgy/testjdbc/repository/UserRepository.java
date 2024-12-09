package hu.jandzsogyorgy.testjdbc.repository;

import hu.jandzsogyorgy.testjdbc.entity.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ListCrudRepository<User, Long> {
    User findByUsername(String username);
}
