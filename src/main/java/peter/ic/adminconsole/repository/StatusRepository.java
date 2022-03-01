package peter.ic.adminconsole.repository;

import org.springframework.data.repository.CrudRepository;
import peter.ic.adminconsole.entity.Status;

public interface StatusRepository extends CrudRepository<Status, Integer> {
}
