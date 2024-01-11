package share.share.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    MessageRepository repo;

    public List<Message> getMessagesFromPost(Long postID) {
        Iterable<Message> allMessages =  repo.findAll();
        List<Message> messages = new ArrayList<Message>();
        for (Message message : allMessages) {
            if (message.getPostID() == postID) {
                messages.add(message);
            }
        }

        messages.sort(Comparator.comparing(Message::getDatum).reversed());


        return messages;
    }

    public Message saveMessage(Message message) {

        if (message.getDatum() == null) {
            message.setDatum(Date.from(java.time.ZonedDateTime.now().toInstant()));
        }


        return repo.save(message);
    }

}
