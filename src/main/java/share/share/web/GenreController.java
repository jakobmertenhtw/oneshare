package share.share.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GenreController {
    @Autowired
    GenreService service;

    @GetMapping("/genres/{id}")
    public Genre getGenre(@PathVariable String id) {
        Long genreId = Long.parseLong(id);
        return service.getGenre(genreId);
    }

    @GetMapping("/genres")
    public List<Genre> getAllGenres(){
        return service.getAllGenres();
    }
}
