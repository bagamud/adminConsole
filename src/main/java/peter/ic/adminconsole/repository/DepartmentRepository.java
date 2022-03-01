package peter.ic.adminconsole.repository;

import org.springframework.data.repository.CrudRepository;
import peter.ic.adminconsole.entity.Department;

import java.util.ArrayList;
import java.util.List;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {
    List<Department> findAllByActiveIsTrueOrderByCode();

    List<Department> findAllByActiveIsTrueAndAnchor_NameOrderByCode(String anchor);

    ArrayList<Department> findAllByActiveIsTrueAndParentCodeOrderByCode(int parentCode);

}
