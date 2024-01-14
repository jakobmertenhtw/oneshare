package share.share;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import share.share.web.User;
import share.share.web.UserRepository;
import share.share.web.UserService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;


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

}
