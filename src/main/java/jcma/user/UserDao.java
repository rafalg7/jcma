package jcma.user;

import jcma.domain.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class UserDao {
// ------------------------------ FIELDS ------------------------------

    @PersistenceContext(unitName = "jcma")
    private EntityManager entityManager;

// -------------------------- OTHER METHODS --------------------------

    @SuppressWarnings("unchecked")
    public List<User> getUsers()
    {
        return entityManager.createQuery("select u from User u").getResultList();
    }
}
