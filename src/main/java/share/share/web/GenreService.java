package share.share.web;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class GenreService {
    @Autowired
    GenreRepository repo;

    public Genre getGenre(Long id){
            return repo.findById(id).orElseThrow(() -> new RuntimeException());
        }
    public List<Genre> getAllGenres() {
        Iterable<Genre> iterator = repo.findAll();
        List<Genre> genres = new ArrayList<Genre>();
        for (Genre genre : iterator)  genres.add(genre);
        return genres;
    }
}
