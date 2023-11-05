package share.share.web;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long genreID;
    private String Bez;

    public Genre(Long genreID, String bez) {
        this.genreID = genreID;
        Bez = bez;
    }

    public Long getGenreID() {
        return genreID;
    }

    public String getBez() {
        return Bez;
    }

    public void setBez(String bez) {
        Bez = bez;
    }
}
