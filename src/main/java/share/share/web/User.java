package share.share.web;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;
    private String username;
    private String firstName;
    private String lastName;
    private String mail;
    private Date birthday;
    private Long phoneNumber;


    public User(Long userID, String username, String firstName, String lastName, String mail, Date birthday, Long phoneNumber) {
        this.userID = userID;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
    }

    public User() {

    }

    public Long getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

