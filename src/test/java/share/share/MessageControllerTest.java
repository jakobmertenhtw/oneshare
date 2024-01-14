package share.share;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import share.share.web.Message;
import share.share.web.MessageController;
import share.share.web.MessageService;

import java.sql.Date;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MessageController.class)
public class MessageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MessageService service;

    @Test
    public void testGetMessagesByPostRoute() throws Exception {
        Date date_1 = new Date(System.currentTimeMillis());
        Date date_2 = new Date(System.currentTimeMillis());

        Message message1 = new Message(1L, 1L, 1L, "Test Message 1", date_1, "", "");
        Message message2 = new Message(2L, 1L, 1L, "Test Message 2", date_2, "", "");

        when(service.getMessagesFromPost(1L)).thenReturn(List.of(message1, message2));


        String expected = "[{\"messageID\":1,\"userID\":1,\"postID\":1,\"text\":\"Test Message 1\",\"datum\":" + date_1.getTime() + ",\"userFullName\":\"\",\"userColor\":\"\"},{\"messageID\":2,\"userID\":1,\"postID\":1,\"text\":\"Test Message 2\",\"datum\":" + date_2.getTime() + ",\"userFullName\":\"\",\"userColor\":\"\"}]";

        this.mockMvc.perform(get("/messages/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString(expected)));

    }


}
