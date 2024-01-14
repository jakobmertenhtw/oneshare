package share.share;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import share.share.web.Message;
import share.share.web.MessageRepository;
import share.share.web.MessageService;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;


@SpringBootTest
public class MessageServiceTest {

    @Autowired
    private MessageService service;

    @MockBean
    private MessageRepository repo;

    @Test
    @DisplayName("should test the save post method")
    void testSavePost() {
        Date date = new Date(2021, 1, 1);

        Message testMessage = new Message(1L, 1L, 1L, "Test", date, "", "");

        doReturn(testMessage).when(repo).save(testMessage);

        Message actual = service.saveMessage(testMessage);

        assertEquals(testMessage.getText(), actual.getText());
        assertEquals(testMessage.getDatum(), actual.getDatum());
        assertEquals(testMessage.getUserID(), actual.getUserID());
        assertEquals(testMessage.getPostID(), actual.getPostID());


    }


}
