package jcma.post;

import jcma.domain.Post;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PostDAO {
// ------------------------------ FIELDS ------------------------------

    @PersistenceContext(unitName = "jcma")
    private EntityManager entityManager;

// -------------------------- OTHER METHODS --------------------------

    public Post getPostById(Long id)
    {
        return entityManager.find(Post.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Post> getPosts()
    {
        return entityManager.createQuery("select p from Post p").getResultList();
    }

    public boolean removePostById(Long id)
    {
        return 0 < entityManager.createQuery("delete Post where id=:id").setParameter("id", id).executeUpdate();
    }

    public void save(Post post)
    {
        entityManager.merge(post);
    }
}
