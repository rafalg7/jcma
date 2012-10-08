/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.it_crowd.tutorials;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author rafal
 */
@ManagedBean
@SessionScoped
public class LoginBean {
    
    private String login="";
    private String password="";
    private boolean loggedIn;

    public LoginBean() {
        this.loggedIn=false;
    }
    
    public void checkLogin(){
        if(login.equals("admin") && password.equals("admin")){
            this.loggedIn=true;
        }else{
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Wrong login credentials!"));
        }
    }
    
    public void logOut(){
        loggedIn=false;
        this.login="";
        this.password="";
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    
    
    
    
}
