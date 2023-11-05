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


    @GetMapping("/postsByGenre/{id}")
    public List<Post> getPostsByGenre(@PathVariable String id) {
        Long genreId = Long.parseLong(id);
        return service.getPostsByGenre(genreId);
    }

    @PostMapping("/post")
    public Post createPost(@RequestBody Post post) {
        return service.savePost(post);
    }
}
