package share.share.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    @GetMapping("/postsByUser/{id}")
    public List<Post> getPostsByUser(@PathVariable String id) {
        Long userId = Long.parseLong(id);
        return service.getPostsByUser(userId);
    }
    @GetMapping("/numberOfPosts")
    public List<Integer> getNumberOfPosts() {
        return service.getNumberOfPosts();
    }
    @GetMapping("/postsFromToday")
    public List<Post> getPostsFromToday() {
        return service.getPostsFromToday();
    }



    @PostMapping("/post")
    public Post createPost(@RequestBody Post post) {
        return service.savePost(post);
    }

    @PutMapping("/likePost/{id}")
    public Post likePost(@PathVariable String id) {
        Long postId = Long.parseLong(id);
        return service.likePost(postId);
    }
    @PutMapping(path = "/editPost/{id}")
    public Post editPost(@PathVariable String id, @RequestBody Post post) {
        Long postId = Long.parseLong(id);
        return service.editPost(postId, post);
    }

    @DeleteMapping("/deletePost/{id}")
    public void deletePost(@PathVariable String id) {
        Long postId = Long.parseLong(id);
        service.deletePost(postId);
    }
}
