package share.share.web;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postID;
    private Long userID;
    private Long genreID;
    private String titel;
    private String text;
    private int likes;
    private Date datum;

    public Post(Long postID, Long userID, Long genreID, String titel, String text, int likes, Date datum) {
        this.postID = postID;
        this.userID = userID;
        this.genreID = genreID;
        this.titel = titel;
        this.text = text;
        this.likes = likes;
        this.datum = datum;
    }

    public Long getPostID() {
        return postID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getGenreID() {
        return genreID;
    }

    public void setGenreID(Long genreID) {
        this.genreID = genreID;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
}
