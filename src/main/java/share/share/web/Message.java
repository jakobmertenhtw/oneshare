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
    private String userFullName;
    private String userColor;

    public Message(Long messageID, Long userID, Long postID, String text, Date datum, String userFullName, String userColor) {
        this.messageID = messageID;
        this.userID = userID;
        this.postID = postID;
        this.text = text;
        this.datum = datum;
        this.userFullName = "";
        this.userColor = "";
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
    public String getUserFullName() {
        return userFullName;
    }
    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }
    public String getUserColor() {
        return userColor;
    }
    public void setUserColor(String userColor) {
        this.userColor = userColor;
    }



}
