package managedBean;

import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;
import model.Pays;
import model.Utilisateur;
import siteWebEJB.ConnectionEJBLocal;

@Named(value="userMB")
@SessionScoped
public class UserMB {
    @EJB
    private ConnectionEJBLocal connectionEJB;
    private Utilisateur user;
    private String selectedCountry = "1";
    private String pays;
    
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
    
    /*public String UserConnection(String login, String mdp) {
        user = connectionEJB.UserConnection(login);
        if(user.getMotdepasse().equals(mdp)) {
            return "categorie.xhtml";
        }
        else {
            return "error.xhtml";
        }
    }*/
    
    /*public void addUser() {
        user.setIdPays(new Pays(Integer.parseInt(selectedCountry)));
        connectionEJB.AddUser(user);
    }*/
    
    public String getPaysById() {
        this.setPays(connectionEJB.getPaysById(1).getLibelle());
        return connectionEJB.getPaysById(1).getLibelle();
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
    
}