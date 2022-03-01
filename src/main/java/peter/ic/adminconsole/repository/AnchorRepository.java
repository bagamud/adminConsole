package peter.ic.adminconsole.repository;

import org.springframework.data.repository.CrudRepository;
import peter.ic.adminconsole.entity.Anchor;

public interface AnchorRepository extends CrudRepository<Anchor, Integer> {
}
