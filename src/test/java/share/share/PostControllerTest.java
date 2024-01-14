package share.share;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import share.share.web.Post;
import share.share.web.PostController;
import share.share.web.PostService;

import java.awt.*;
import java.sql.Date;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PostController.class)
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService service;

    @Test
    public void testGetPostsByIdRoute() throws Exception {

        Date date_1 = new Date(System.currentTimeMillis());
        Date date_2 = new Date(System.currentTimeMillis());

        Post post1 = new Post(1L, 1L, 1L, "Test Post 1", "Test description 1", 0, date_1);
        Post post2 = new Post(2L, 1L, 1L, "Test Post 2", "Test description 2", 2, date_2);

        when(service.getPostsByGenre(1L)).thenReturn(List.of(post1, post2));

        String expected = "[{\"postID\":1,\"userID\":1,\"genreID\":1,\"titel\":\"Test Post 1\",\"text\":\"Test description 1\",\"likes\":0,\"datum\":" + date_1.getTime() + "},{\"postID\":2,\"userID\":1,\"genreID\":1,\"titel\":\"Test Post 2\",\"text\":\"Test description 2\",\"likes\":2,\"datum\":" + date_2.getTime();

        this.mockMvc.perform(get("/postsByGenre/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString(expected)));

    }

    @Test
    public void testGetPostsByUserRoute() throws Exception {
        Date date_1 = new Date(System.currentTimeMillis());
        Date date_2 = new Date(System.currentTimeMillis());

        Post post1 = new Post(1L, 1L, 1L, "Test Post 1", "Test description 1", 0, date_1);
        Post post2 = new Post(2L, 1L, 5L, "Test Post 2", "Test description 2", 2, date_2);

        when(service.getPostsByUser(1L)).thenReturn(List.of(post1, post2));

        String expected = "[{\"postID\":1,\"userID\":1,\"genreID\":1,\"titel\":\"Test Post 1\",\"text\":\"Test description 1\",\"likes\":0,\"datum\":" + date_1.getTime() + "},{\"postID\":2,\"userID\":1,\"genreID\":5,\"titel\":\"Test Post 2\",\"text\":\"Test description 2\",\"likes\":2,\"datum\":" + date_2.getTime();

        this.mockMvc.perform(get("/postsByUser/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString(expected)));
    }

    @Test
    public void testGetNumberOfPostsRoute() throws Exception {
        when(service.getNumberOfPosts()).thenReturn(List.of(5, 12));

        String expected = "[5,12]";

        this.mockMvc.perform(get("/numberOfPosts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString(expected)));
    }

    @Test
    public void testDeletePostRoute() throws Exception {

        // delete the post
        this.mockMvc.perform(delete("/deletePost/1"))
                .andExpect(status().isOk());

    }

    @Test
    public void testGetPostsFromTodayRoute() throws Exception {
        Date date_1 = new Date(System.currentTimeMillis());
        Date date_2 = new Date(System.currentTimeMillis());

        Post post1 = new Post(1L, 1L, 1L, "Test Post 1", "Test description 1", 0, date_1);
        Post post2 = new Post(2L, 1L, 5L, "Test Post 2", "Test description 2", 2, date_2);

        when(service.getPostsFromToday()).thenReturn(List.of(post1, post2));

        String expected = "[{\"postID\":1,\"userID\":1,\"genreID\":1,\"titel\":\"Test Post 1\",\"text\":\"Test description 1\",\"likes\":0,\"datum\":" + date_1.getTime() + "},{\"postID\":2,\"userID\":1,\"genreID\":5,\"titel\":\"Test Post 2\",\"text\":\"Test description 2\",\"likes\":2,\"datum\":" + date_2.getTime();

        this.mockMvc.perform(get("/postsFromToday"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString(expected)));
    }



}
