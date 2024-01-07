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

    public Long getGenreID() {
        return id;
    }
    public void setGenreID(Long genreID) {
        this.id = genreID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
