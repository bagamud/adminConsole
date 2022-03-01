package peter.ic.adminconsole.repository;

import org.springframework.data.repository.CrudRepository;
import peter.ic.adminconsole.entity.Department;
import peter.ic.adminconsole.entity.Users;

import java.util.List;

public interface UsersRepository extends CrudRepository<Users, Integer> {
    Users findByUsername(String username);

    Users findById(int id);

    List<Users> findAllByDepartment(Department department);
}
