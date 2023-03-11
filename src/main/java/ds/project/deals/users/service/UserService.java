package ds.project.deals.users.service;

import ds.project.deals.subscribers.entity.Subscriber;
import ds.project.deals.subscribers.service.SubscriberService;
import ds.project.deals.users.entity.User;
import ds.project.deals.users.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SubscriberService subscriberService;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Iterable<User> listUser() {
        return userRepository.findAll();
    }

    public List<Subscriber> listSubscriberForUser(int userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException(""));
        return subscriberService.listSubscriberForUser(user);
    }

}
