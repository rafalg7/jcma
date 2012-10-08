package jcma;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ManagedBean
public class Bean {
// ------------------------------ FIELDS ------------------------------

    private String name;

    private List<Contact> people = Arrays.asList(new Contact("John", "Doe"), new Contact("Franz", "K"), new Contact("Teddy", "Ros"));

    private List<String> selectedContacts = new ArrayList<String>();

    private Map<Contact, Boolean> selection = new HashMap<Contact, Boolean>();

// --------------------- GETTER / SETTER METHODS ---------------------

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Contact> getPeople()
    {
        return people;
    }

    public List<String> getSelectedContacts()
    {
        return selectedContacts;
    }

    public void setSelectedContacts(List<String> selectedContacts)
    {
        this.selectedContacts = selectedContacts;
    }

    public Map<Contact, Boolean> getSelection()
    {
        return selection;
    }

// -------------------------- OTHER METHODS --------------------------

    public void greetSelectedContacts()
    {
        for (Map.Entry<Contact, Boolean> enty : selection.entrySet()) {
            if (enty.getValue()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hi " + enty.getKey().getFirstname() + " " + enty.getKey().getLastname()));
            }
        }
    }

    public void sayHi()
    {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hi " + name));
    }
}
