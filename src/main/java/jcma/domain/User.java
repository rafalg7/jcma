package jcma.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class User {
// ------------------------------ FIELDS ------------------------------

    private String email;

    private String firstname;

    @Id
    @GeneratedValue
    private Long id;

    private String lastname;

// --------------------------- CONSTRUCTORS ---------------------------

    public User()
    {
    }

    public User(String email, String firstname, String lastname)
    {
        this.email = email;

        this.firstname = firstname;
        this.lastname = lastname;
    }

// --------------------- GETTER / SETTER METHODS ---------------------

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }
}
