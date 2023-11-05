package share.share.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository repo;

    public User getUser(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public User saveUser(User user) {
        return repo.save(user);
    }
}
