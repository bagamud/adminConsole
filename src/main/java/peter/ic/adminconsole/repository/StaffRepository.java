package peter.ic.adminconsole.repository;

import org.springframework.data.repository.CrudRepository;
import peter.ic.adminconsole.entity.Staff;

import java.util.List;

public interface StaffRepository extends CrudRepository<Staff, Integer> {

    Staff findByStaffId(int card_id);

    List<Staff> findAllByDepartment_code(int department_code);

    List<Staff> findAllByLastNameLikeIgnoreCaseAndFirstNameLikeIgnoreCaseAndMiddleNameLikeIgnoreCase(String lastName, String firstName, String middleName);

    List<Staff> findAllByUsername(String value);

    List<Staff> findAllByLastName(String value);

    List<Staff> findAllByDepartment_Code(int departmentCode);

    List<Staff> findAllByPosition_Code(int position_code);

    List<Staff> findAllByStatus_Id(int statusId);
}
