package managedBean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Utilisateur;
import siteWebEJB.ConnectionEJBLocal;

@ManagedBean
@SessionScoped
public class UserConnection {
    
    @EJB
    private ConnectionEJBLocal connectionEJB;
    private Utilisateur user;
    
    public UserConnection() {
        user = new Utilisateur();
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
    
    public void addUser() {
        user.setIdPays(1);
        connectionEJB.AddUser(user);
    }
}