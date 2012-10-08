package pl.com.it_crowd.tutorials;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@ViewScoped
@ManagedBean(name="TheBean")
public class Bean implements Serializable {
// ------------------------------ FIELDS ------------------------------

    private String response;

    private String text;

// --------------------- GETTER / SETTER METHODS ---------------------

    public String getResponse()
    {
        return response;
    }

    public void setResponse(String response)
    {
        this.response = response;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

// -------------------------- OTHER METHODS --------------------------

    public void echo()
    {
        response = "Echo:" + text;
    }
}
