package share.share.web;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;
import java.sql.Date;

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
                posts.add(post);
            }
        }

        // sortiere die Liste nach Datum
        posts.sort(Comparator.comparing(Post::getDatum).reversed());

        return posts;
    }

    public Post savePost(Post post) {

        if (post.getDatum() == null) {
            post.setDatum(Date.from(java.time.ZonedDateTime.now().toInstant()));
        }

        return repo.save(post);
    }

    public Post likePost(Long postID) {
        Post post = repo.findById(postID).orElseThrow(() -> new RuntimeException());
        post.setLikes(post.getLikes() + 1);
        return repo.save(post);
    }

    public List<Post> getPostsByUser(Long userID){
        Iterable<Post> iterator = repo.findAll();
        List<Post> posts = new ArrayList<Post>();
        for (Post post : iterator) {
            if(post.getUserID() == userID) {
                posts.add(post);
            }
        }

        posts.sort(Comparator.comparing(Post::getDatum).reversed());

        return posts;
    }

    public List<Integer> getNumberOfPosts() {
        Iterable<Post> iterator = repo.findAll();
        List<Post> postsToday = new ArrayList<Post>();
        List<Post> postsWeek =  new ArrayList<Post>();
        for (Post post : iterator) {
            // check if post is from this week
            if (post.getDatum().getDay() >= 0 && post.getDatum().getDay() <= 6) {
                postsWeek.add(post);
            }
            // check if post is from today
            if (post.getDatum().getDay() == 0) {
                postsToday.add(post);
            }
        }
        return List.of(postsToday.size(), postsWeek.size());
    }

    public void deletePost(Long postID) {
        repo.deleteById(postID);
    }

    public Post editPost(Long postID, Post post) {
        Post postToEdit = repo.findById(postID).orElseThrow(() -> new RuntimeException());
        postToEdit.setTitel(post.getTitel());
        postToEdit.setText(post.getText());
        postToEdit.setDatum(Date.from(java.time.ZonedDateTime.now().toInstant()));
        return repo.save(postToEdit);
    }

    public List<Post> getPostsFromToday() {
        Iterable<Post> iterator = repo.findAll();
        List<Post> postsToday = new ArrayList<Post>();
        for (Post post : iterator) {
            // check if post is from today
            if (post.getDatum().getDay() == 0) {
                postsToday.add(post);
            }
        }

        postsToday.sort(Comparator.comparing(Post::getDatum).reversed());

        return postsToday;
    }

}
