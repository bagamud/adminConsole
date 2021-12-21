package peter.ic.adminconsole.repository;

import org.springframework.data.repository.CrudRepository;
import peter.ic.adminconsole.entity.Users;

public interface UsersRepository extends CrudRepository<Users, Integer> {
    Users findByUsername(String username);
    Iterable<Users> findAllByUsername(String username);
    Iterable<Users> findAll();
    Iterable<Users> findAllByLastName(String lastName);
    Iterable<Users> findAllByPost_Id(int post_id);
    Iterable<Users> findAllByDepartment_Code(int department_code);
    Iterable<Users> findAllByActive(boolean active);


}