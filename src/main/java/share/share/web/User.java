package share.share.web;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;
    private String firstName;
    private String lastName;
    private String mail;
    private Long phoneNumber;
    private String profilePicture;
    private String profileColor;
    private String password;


    public User(Long userID, String username, String firstName, String lastName, String mail, Long phoneNumber, String profilePicture, String profileColor) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
        this.profileColor = profileColor;
        this.profilePicture = profilePicture;
        this.password = password;
    }

    public User() {

    }

    public Long getUserID() {
        return userID;
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

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getProfilePicture() {
        return profilePicture;
    }
    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
    public String getProfileColor() {
        return profileColor;
    }
    public void setProfileColor(String profileColor) {
        this.profileColor = profileColor;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}

