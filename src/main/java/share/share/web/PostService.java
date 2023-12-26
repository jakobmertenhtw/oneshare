package share.share.web;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class PostService {
    @Autowired
    PostRepository repo;

    public Post getPost(Long id){
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public List<Post> getPostsByGenre(Long genreID){
        Iterable<Post> iterator = repo.findAll();
        List<Post> posts = new ArrayList<Post>();
        for (Post post : iterator) {
            if(post.getGenreID() == genreID) {
                UserService userService = new UserService();
                posts.add(post);
            }
        }
        return posts;
    }

    public Post savePost(Post post) {
        return repo.save(post);
    }
}
