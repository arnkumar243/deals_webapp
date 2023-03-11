package ds.project.deals.subscribers.repository;

import ds.project.deals.subscribers.entity.Subscriber;

import java.util.List;

import ds.project.deals.users.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface SubscriberRepository extends CrudRepository<Subscriber, Integer> {
	
	List<Subscriber> findByFixedDeals(int dealId);
	
	List<Subscriber> findByShop(int shopId);

	List<Subscriber> findByUser(User user);
	
}
