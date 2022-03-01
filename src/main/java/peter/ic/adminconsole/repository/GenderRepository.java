package peter.ic.adminconsole.repository;

import org.springframework.data.repository.CrudRepository;
import peter.ic.adminconsole.entity.Gender;

public interface GenderRepository extends CrudRepository<Gender, Integer> {
}
