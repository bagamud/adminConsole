package peter.ic.adminconsole.repository;

import org.springframework.data.repository.CrudRepository;
import peter.ic.adminconsole.entity.Users;

public interface UsersRepository extends CrudRepository<Users, Integer> {
    Users findByUsername(String username);
    Iterable<Users> findAll();

}