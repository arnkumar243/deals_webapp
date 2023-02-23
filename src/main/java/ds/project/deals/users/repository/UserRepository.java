package ds.project.deals.users.repository;

import org.springframework.data.repository.CrudRepository;
import ds.project.deals.users.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}