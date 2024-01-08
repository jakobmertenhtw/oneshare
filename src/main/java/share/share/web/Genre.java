package share.share.web;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String imagepath;
    private String imageAlt;


    public Genre(Long id, String name, String imagepath, String imageAlt) {
        this.id = id;
        this.name = name;
        this.imagepath = imagepath;
        this.imageAlt = imageAlt;
    }

    public Genre() {

    }

    public Long getId() {
        return id;
    }
    public void seId(Long genreID) {
        this.id = genreID;
    }
    public String getImagepath() {
        return imagepath;
    }
    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }
    public String getName() {
        return name;
    }
    public String getImageAlt() {
        return imageAlt;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setImageAlt(String imageAlt) {
        this.imageAlt = imageAlt;
    }
}
