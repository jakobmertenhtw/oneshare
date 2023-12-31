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

    public User getUserByMail(String mail) {
        Iterable<User> iterator = repo.findAll();
        for (User user : iterator) {
            if (user.getMail().equals(mail)) {
                return user;
            }
        }
        throw new RuntimeException("User not found");
    }

    public User saveUser(User user) {
        // Checks if user already exists
        String userMail = user.getMail();
        Iterable<User> iterator = repo.findAll();
        for (User user1 : iterator) {
            if (user1.getMail().equals(userMail)) {
                throw new RuntimeException("User already exists");
            }
        }
        return repo.save(user);
    }

    public User updateUser(Long userID, User user) {
        User user1 = repo.findById(userID).orElseThrow(() -> new RuntimeException());
        user1.setMail(user.getMail());
        user1.setPassword(user.getPassword());
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setPhoneNumber(user.getPhoneNumber());
        user1.setProfilePicture(user.getProfilePicture());
        return repo.save(user1);
    }

}
