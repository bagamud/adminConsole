package peter.ic.adminconsole.repository;

import org.springframework.data.repository.CrudRepository;
import peter.ic.adminconsole.entity.Role;

public interface RolesRepository extends CrudRepository<Role, Integer> {
}
