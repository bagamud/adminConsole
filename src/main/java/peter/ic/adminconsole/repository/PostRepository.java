package peter.ic.adminconsole.repository;

import org.springframework.data.repository.CrudRepository;
import peter.ic.adminconsole.entity.Post;

public interface PostRepository extends CrudRepository<Post, Integer> {
}
