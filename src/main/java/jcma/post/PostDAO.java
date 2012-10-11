package jcma.post;

import jcma.domain.Post;
import jcma.domain.User;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class PostDAO {
// ------------------------------ FIELDS ------------------------------

    private List<Post> posts;

// --------------------------- CONSTRUCTORS ---------------------------

    public PostDAO()
    {
        final User author = new User("john@doe.com", "John", "Doe");
        posts = new ArrayList<Post>();
        for (Post post : Arrays.asList(new Post(author, "Content #1", "First post"), new Post(author, "Content #2", "Second post"))) {
            save(post);
        }
    }

// --------------------- GETTER / SETTER METHODS ---------------------

    public List<Post> getPosts()
    {
        return posts;
    }

// -------------------------- OTHER METHODS --------------------------

    public void save(Post post)
    {
        posts.add(post);
        post.setId((long) posts.size());
    }
}
