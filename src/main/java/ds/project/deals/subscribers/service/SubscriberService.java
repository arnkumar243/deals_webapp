package ds.project.deals.subscribers.service;

import ds.project.deals.fixed_deals.entity.FixedDeals;
import ds.project.deals.fixed_deals.repository.FixedDealsRepository;
import ds.project.deals.shops.entity.Shop;
import ds.project.deals.shops.repository.ShopRepository;
import ds.project.deals.subscribers.entity.Subscriber;
import ds.project.deals.subscribers.repository.SubscriberRepository;
import ds.project.deals.users.entity.User;
import ds.project.deals.users.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
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

    public Subscriber getSubscriberById(int id) {
        Subscriber subscriber = subscriberRepository.findById(id)
                                    .orElseThrow(() -> new EntityNotFoundException("Subscriber not found with Id" + id));
        return subscriber;
    }

    public Iterable<Subscriber> listSubscribers() {
        return subscriberRepository.findAll();
    }

}
