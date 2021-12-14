package peter.ic.adminconsole.repository;

import org.springframework.data.repository.CrudRepository;
import peter.ic.adminconsole.entity.Department;

public interface DepartmentsRepository extends CrudRepository<Department, Integer> {
//    Iterable<Department> findAllOrderById();
}
