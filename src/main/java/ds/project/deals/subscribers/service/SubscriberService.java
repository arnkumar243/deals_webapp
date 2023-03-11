package ds.project.deals.subscribers.service;

import ds.project.deals.deals.entity.Deals;
import ds.project.deals.fixed_deals.entity.FixedDeals;
import ds.project.deals.fixed_deals.repository.FixedDealsRepository;
import ds.project.deals.shops.entity.Shop;
import ds.project.deals.shops.repository.ShopRepository;
import ds.project.deals.subscribers.entity.Subscriber;
import ds.project.deals.subscribers.repository.SubscriberRepository;
import ds.project.deals.users.entity.User;
import ds.project.deals.users.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriberService {

    @Autowired
    SubscriberRepository subscriberRepository;

    @Autowired
    FixedDealsRepository fixedDealsRepository;

    @Autowired
    ShopRepository shopRepository;

    @Autowired
    UserRepository userRepository;

    public Subscriber addSubscriber(Subscriber subscriber) {

        if(subscriber.getFixedDeals() != null) {
            FixedDeals fixedDeals = fixedDealsRepository.findById(subscriber.getFixedDeals().getId())
                    .orElseThrow(() -> new EntityNotFoundException("Fixed deals not found with id : " + subscriber.getFixedDeals().getId()));

            subscriber.setFixedDeals(fixedDeals);
        }

        if(subscriber.getShop() != null) {
            Shop shop = shopRepository.findById(subscriber.getShop().getId())
                    .orElseThrow(() -> new EntityNotFoundException("Shop not found with id : " + subscriber.getShop().getId()));

            subscriber.setShop(shop);
        }

        User user = userRepository.findById(subscriber.getUser().getId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id : " + subscriber.getUser().getId()));

        subscriber.setUser(user);

        return subscriberRepository.save(subscriber);
    }

    public List<Subscriber> getSubscriberByDeal(Deals deal) {
    	
    	if(deal == null || deal.getId() == 0) {
    		throw new EntityNotFoundException("Deal or Deal id not specified.");
    	}
    	
    	if(deal.getId() == 1) {
    		if(deal.getShop() == null || deal.getShop().getId() == 0) {
    			throw new EntityNotFoundException("Shop or Shop id not specified.");
    		}
    		return subscriberRepository.findByShop(deal.getShop().getId());
    	} else {
    		return subscriberRepository.findByFixedDeals(deal.getId());
    	}
    }
    
    public void deleteSubscriber(int subscriberId) {
    	subscriberRepository.findById(subscriberId)
    			.orElseThrow(() -> new EntityNotFoundException("Subscriber not found with id : " + subscriberId));
    	subscriberRepository.deleteById(subscriberId);
    }

    public Subscriber getSubscriberById(int id) {
        Subscriber subscriber = subscriberRepository.findById(id)
                                    .orElseThrow(() -> new EntityNotFoundException("Subscriber not found with Id" + id));
        return subscriber;
    }

    public List<Subscriber> listSubscriberForUser(User user) {
        return subscriberRepository.findByUser(user);
    }

    public Iterable<Subscriber> listSubscribers() {
        return subscriberRepository.findAll();
    }

}
