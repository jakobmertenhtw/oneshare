package share.share;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import share.share.web.User;
import share.share.web.UserRepository;
import share.share.web.UserService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService service;

    @MockBean
    private UserRepository repo;

    @Test
    @DisplayName("should find a user by id")
    void testGetUser() {

        User testUser = new User(1L, "Test",  "User", "test@user.com", 1234567890L, "TU", "00000");
        doReturn(Optional.of(testUser)).when(repo).findById(1L);

        User actual = service.getUser(1L);

        assertEquals(testUser.getMail(), actual.getMail());

    }

    @Test
    @DisplayName("should find user by mail and authenticate")
    void testGetUserByMail() {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String rawPassword = "123";
        String encodedPassword = bcrypt.encode(rawPassword);

        User testUser = new User(1L, "Test", "User", "test@user.com", 1234567890L, "TU","00000");
        testUser.setPassword(encodedPassword);
        // Mock the behavior of the repository
        //when(repo.findAll()).thenReturn(Arrays.asList(testUser));
        doReturn(Arrays.asList(testUser)).when(repo).findAll();

        // Call the method being tested
        User actual = service.getUserByMail("test@user.com", rawPassword);

        // Verify that the expected user is returned
        assertEquals(testUser.getMail(), actual.getMail());
    }

    @Test
    @DisplayName("should throw exception for invalid user")
    void testGetUserByMailInvalidUser() {
        // Mock an empty repository
        when(repo.findAll()).thenReturn(Arrays.asList());

        // Call the method being tested and expect an exception
        assertThrows(RuntimeException.class, () -> service.getUserByMail("nonexistent@user.com", "password"));

        // Verify that the repository method was called
        verify(repo, times(1)).findAll();
    }

    @Test
    @DisplayName("should throw exception for incorrect password")
    void testGetUserByMailIncorrectPassword() {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String trueRawPassword = "123";
        String falseRawPassword = "124";

        String encodedPassword = bcrypt.encode(trueRawPassword); // Use a different password

        User testUser = new User(1L, "Test", "User", "test@user.com", 1234567890L, "TU", "00000");
        testUser.setPassword(encodedPassword);
        // Mock the behavior of the repository
        doReturn(Arrays.asList(testUser)).when(repo).findAll();
        // Call the method being tested and expect an exception
        assertThrows(RuntimeException.class, () -> service.getUserByMail("test@user.com", falseRawPassword));

        // Verify that the repository method was called
        verify(repo, times(1)).findAll();
    }

    @Test
    @DisplayName("should change first- and lastname, and password")
    void tesUpdate() {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String trueRawPassword = "123";
        String newRawPassword = "124";

        String encodedPassword = bcrypt.encode(trueRawPassword); // Use a different password
        String newEncodedPassword = bcrypt.encode(newRawPassword); // Use a different password

        User testUser = new User(1L, "Test", "User", "test@user.com", 1234567890L, "TU", "00000");
        testUser.setPassword(encodedPassword);

        //changes
        testUser.setFirstName("X");
        testUser.setLastName("Man");
        testUser.setPassword(newEncodedPassword);
        // Mock the behavior of the repository
        doReturn(Optional.of(testUser)).when(repo).findById(1L);
        service.updateUser(1L, testUser);

        User actual = new User(1L, "X", "Man", "test@user.com", 1234567890L, "XM", "00000");
        actual.setPassword(newEncodedPassword);

        assertEquals(testUser.getFirstName(), actual.getFirstName());
        assertEquals(testUser.getLastName(), actual.getLastName());
        assertEquals(testUser.getPassword(), actual.getPassword());

    }

}
