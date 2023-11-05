package share.share.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    PostService service;

    @GetMapping("/posts/{id}")
    public Post getPost(@PathVariable String id) {
        Long postId = Long.parseLong(id);
        return service.getPost(postId);
    }

    @GetMapping("/posts/{id}")
    public List<Post> getPostsByGenre(@PathVariable String genreID) {
        Long id = Long.parseLong(genreID);
        return service.getPostsByGenre(id);
    }

    @PostMapping("/posts")
    public Post createPost(@RequestBody Post post) {
        return service.savePost(post);
    }
}
