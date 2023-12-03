package share.share.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService service;

    @CrossOrigin
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable String id) {
        Long userId = Long.parseLong(id);
        return service.getUser(userId);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return service.saveUser(user);
    }
}
