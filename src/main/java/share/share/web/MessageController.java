package share.share.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.expression.Messages;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    MessageService service;

    @GetMapping("/messages/{postID}")
    public List<Message> getMessagesFromPost(@PathVariable String postID) {
        Long postId = Long.parseLong(postID);
        return service.getMessagesFromPost(postId);
    }

    @PostMapping("/message")
    public Message createMessage(@RequestBody Message message) {
        return service.saveMessage(message);
    }

}
