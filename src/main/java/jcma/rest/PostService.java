package jcma.rest;

import jcma.domain.Post;
import jcma.domain.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.Arrays;
import java.util.List;

@Path("/post")
public class PostService {
// ------------------------------ FIELDS ------------------------------

    private List<Post> posts;

// --------------------------- CONSTRUCTORS ---------------------------

    public PostService()
    {
        final User author = new User("john@doe.com", "John", "Doe");
        posts = Arrays.asList(new Post(author, "Content #1", "First post"), new Post(author, "Content #2", "Second post"));
    }

// --------------------- GETTER / SETTER METHODS ---------------------

    @GET
    @Path("/list")
    public List<Post> getPosts()
    {
        return posts;
    }
}
