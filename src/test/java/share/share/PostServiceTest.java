package share.share;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import share.share.web.Post;
import share.share.web.PostRepository;
import share.share.web.PostService;

import java.sql.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class PostServiceTest {

    @Autowired
    private PostService service;

    @MockBean
    private PostRepository repo;

    @Test
    @DisplayName("should save a post")
    void testSavePost() {

        Date date = new Date(2021, 1, 1);

        Post testPost = new Post(1L, 1L, 1L, "Test", "Test", 0, date);

        doReturn(testPost).when(repo).save(testPost);

        Post actual = service.savePost(testPost);

        assertEquals(testPost.getTitel(), actual.getTitel());
        assertEquals(testPost.getText(), actual.getText());


    }

    @Test
    @DisplayName("should test edit a post")
    void testEditPost() {

        Date date = new Date(2021, 1, 1);

        Post oldPost = new Post(1L, 1L, 1L, "Test", "Test", 0, date);

        String newTitle = "New Title";
        String newText = "New Text";
        Date newDate = new Date(2021, 1, 2);

        Post newPost = new Post(1L, 1L, 1L, newTitle, newText, 0, newDate);


        doReturn(Optional.of(oldPost)).when(repo).findById(1L);

        doReturn(newPost).when(repo).save(oldPost);

        Post actual = service.editPost(1L, newPost);

        assertEquals(newTitle, actual.getTitel());
        assertEquals(newText, actual.getText());


    }


}
