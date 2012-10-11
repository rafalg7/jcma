package jcma.rest;

import jcma.domain.Post;
import jcma.domain.User;
import jcma.post.PostDAO;
import jcma.user.UserDao;
import org.jboss.resteasy.annotations.providers.jaxb.Wrapped;
import org.jboss.resteasy.spi.NotFoundException;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.List;

@Path("/post")
public class PostService {
// ------------------------------ FIELDS ------------------------------

    @Inject
    private PostDAO postDAO;

    @Inject
    private UserDao userDao;

// -------------------------- OTHER METHODS --------------------------

    @Produces({"application/json", "application/xml"})
    @GET
    @Path("/add")
    public Post addPost(@QueryParam("title") String title, @QueryParam("content") String content)
    {
        final Post post = new Post(getCurrentUser(), content, title);
        postDAO.save(post);
        return post;
    }

    @Produces({"application/json", "application/xml"})
    @GET
    @Path("/{id}")
    public Post getPost(@PathParam("id") Long id)
    {
        final Post post = postDAO.getPostById(id);
        if (post == null) {
            throw new NotFoundException("No post with given id exists: " + id);
        }
        return post;
    }

    @Produces({"application/json", "application/json-in-script"})
    @GET
    @Path("/list")
    public List<Post> getPosts()
    {
        return postDAO.getPosts();
    }

    @Wrapped(element = "posts")
    @Produces("application/xml")
    @GET
    @Path("/list")
    public List<Post> getPostsAsXML()
    {
        return postDAO.getPosts();
    }

    @DELETE
    @Path("/{id}")
    public boolean removePost(@PathParam("id") Long id)
    {
        return postDAO.removePostById(id);
    }

    private User getCurrentUser()
    {
        return userDao.getUsers().get(0);
    }
}
