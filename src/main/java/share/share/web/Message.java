package share.share.web;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageID;
    private Long userID;
    private Long postID;
    private String text;
    private Date datum;

    public Message(Long messageID, Long userID, Long postID, String text, Date datum) {
        this.messageID = messageID;
        this.userID = userID;
        this.postID = postID;
        this.text = text;
        this.datum = datum;
    }
    public Message() {

    }

    // Getter and Setter
    public Long getMessageID() {
        return messageID;
    }
    public Long getUserID() {
        return userID;
    }
    public void setUserID(Long userID) {
        this.userID = userID;
    }
    public Long getPostID() {
        return postID;
    }
    public void setPostID(Long postID) {
        this.postID = postID;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public Date getDatum() {
        return datum;
    }
    public void setDatum(Date datum) {
        this.datum = datum;
    }



}
