package share.share;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import share.share.web.User;
import share.share.web.UserController;
import share.share.web.UserService;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService service;

    @Test
    public void testGetUserRoute() throws Exception {
        User user = new User(1L, "Test", "User", "test@mail.com", 123456789L, "TU", "000000");
        when(service.getUser(1L)).thenReturn(user);

        String expected = "{\"userID\":1,\"firstName\":\"Test\",\"lastName\":\"User\",\"mail\":\"test@mail.com\",\"phoneNumber\":123456789,\"profilePicture\":\"TU\",\"profileColor\":\"000000\",\"password\":null}";

        this.mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString(expected)));

    }
    @Test
    public void testGetUserByMailRoute() throws Exception {
        User user = new User(1L, "Test", "User", "test@mail.com", 123456789L, "TU", "000000");
        when(service.getUserByMail("test@mail.com", "test")).thenReturn(user);

        String expected = "{\"userID\":1,\"firstName\":\"Test\",\"lastName\":\"User\",\"mail\":\"test@mail.com\",\"phoneNumber\":123456789,\"profilePicture\":\"TU\",\"profileColor\":\"000000\",\"password\":null}";

        this.mockMvc.perform(get("/users/mail/test@mail.com/test"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString(expected)));
    }


}
