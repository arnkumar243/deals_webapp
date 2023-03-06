package ds.project.deals.subscribers.repository;

import ds.project.deals.subscribers.entity.Subscriber;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SubscriberRepository extends CrudRepository<Subscriber, Integer> {
	
	List<Subscriber> findBySubFixedDealsId(int dealId);
	
	List<Subscriber> findBySubShopId(int shopId);
	
}
