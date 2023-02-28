package ds.project.deals.users.service;

import ds.project.deals.users.entity.User;
import ds.project.deals.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Iterable<User> listUser() {
        return userRepository.findAll();
    }

}
