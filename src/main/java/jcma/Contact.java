package jcma;

public class Contact {
// ------------------------------ FIELDS ------------------------------

    private String firstname;

    private String lastname;

// --------------------------- CONSTRUCTORS ---------------------------

    public Contact()
    {

    }

    public Contact(String firstname, String lastname)
    {
        this.firstname = firstname;
        this.lastname = lastname;
    }

// --------------------- GETTER / SETTER METHODS ---------------------

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
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
