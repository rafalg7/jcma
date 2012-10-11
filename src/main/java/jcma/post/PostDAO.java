package jcma.post;

import jcma.domain.Post;
import jcma.domain.User;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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

    public Post getPostById(Long id)
    {
        if (id == null) {
            return null;
        }
        for (Post post : posts) {
            if (id.equals(post.getId())) {
                return post;
            }
        }
        return null;
    }

    public boolean removePostById(Long id)
    {
        if (id == null) {
            return false;
        }
        for (Iterator<Post> iterator = posts.iterator(); iterator.hasNext(); ) {
            Post post = iterator.next();
            if (id.equals(post.getId())) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public void save(Post post)
    {
        posts.add(post);
        post.setId((long) posts.size());
    }
}
