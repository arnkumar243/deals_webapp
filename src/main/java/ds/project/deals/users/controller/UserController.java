package ds.project.deals.users.controller;

import ds.project.deals.users.entity.User;
import ds.project.deals.users.repository.UserRepository;
import ds.project.deals.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public @ResponseBody User addNewUser (@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping
    public @ResponseBody Iterable<User> getAllUsers() {
        return userService.listUser();
    }
}
