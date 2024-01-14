package share.share.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    public User getUserByMail(String mail, String password) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        Iterable<User> iterator = repo.findAll();
        for (User user : iterator) {
            if (user.getMail().equals(mail) && bcrypt.matches(password, user.getPassword())) {
                return user;
            }
        }
        throw new RuntimeException("User not found or password incorrect");
    }


    public User saveUser(User user) {

        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String encryptedPassword = bcrypt.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        // Checks if user already exists
        String userMail = user.getMail();
        Iterable<User> iterator = repo.findAll();
        // If the password is changed, it's getting encrypted along the way
        for (User user1 : iterator) {
            if (user1.getMail().equals(userMail)) {
                throw new RuntimeException("User already exists");
            }
        }
        return repo.save(user);
    }

    public User updateUser(Long userID, User user) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        User user1 = repo.findById(userID).orElseThrow(() -> new RuntimeException());
        user1.setMail(user.getMail());
        if(!user1.getPassword().equals(user.getPassword())){
            String encryptedPassword = bcrypt.encode(user.getPassword());
            user1.setPassword(encryptedPassword);
        }
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setPhoneNumber(user.getPhoneNumber());
        user1.setProfilePicture(user.getProfilePicture());
        return repo.save(user1);
    }

    public Iterable<User> getUsersFromPosts(List<Post> postList) {
        List<User> userList = new ArrayList<User>();
        for (Post post : postList) {
            userList.add(repo.findById(post.getUserID()).orElseThrow(() -> new RuntimeException()));
        }
        return userList;
    }

}
