package peter.ic.adminconsole.repository;

import org.springframework.data.repository.CrudRepository;
import peter.ic.adminconsole.entity.Post;
import peter.ic.adminconsole.entity.Services;

public interface ServicesRepository extends CrudRepository<Services, Integer> {
}
