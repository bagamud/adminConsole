package peter.ic.adminconsole.repository;

import org.springframework.data.repository.CrudRepository;
import peter.ic.adminconsole.entity.Rank;

public interface RankRepository extends CrudRepository<Rank, Integer> {
}
