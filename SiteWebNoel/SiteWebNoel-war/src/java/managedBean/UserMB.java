package managedBean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.event.ValueChangeEvent;
import model.Pays;
import model.Utilisateur;
import siteWebEJB.ConnectionEJBLocal;

@Named(value = "userMB")
@SessionScoped
public class UserMB implements Serializable {
    
    @EJB
    private ConnectionEJBLocal connectionEJB;
    private Utilisateur user;
    private String login;
    private String mdp;
    private String selectedCountry = "1";
    private String pays;
    private boolean connected = false;
    
    public UserMB() {
        user = new Utilisateur();
    }
    
    public void countryChanged(ValueChangeEvent e) {
        selectedCountry = e.getNewValue().toString();
    }

    public String getSelectedCountry() {
        return selectedCountry;
    }

    public void setSelectedCountry(String selectedCountry) {
        this.selectedCountry = selectedCountry;
    }
    
    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }
    
    public String addUser() {
        user.setIdPays(new Pays(Integer.parseInt(selectedCountry)));
        connectionEJB.AddUser(user);
        setConnected(true);
        return "confirmation.xhtml";
    }
    
    public String connection() {
        Utilisateur u = connectionEJB.findUserByLogin(login);
        if(u != null && u.getMotdepasse().equals(mdp)) {
            setConnected(true);
            user = u;
            return "categories.xhtml";
        }
        else {
            return "connection.xhtml";
        }
    }
    
    public String logout() {
        setConnected(false);
        user = null;
        return "connection.xhtml";
    }

    public Boolean getConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}
