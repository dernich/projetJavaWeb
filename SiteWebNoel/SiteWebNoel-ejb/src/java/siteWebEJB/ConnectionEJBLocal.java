package siteWebEJB;

import java.util.ArrayList;
import javax.ejb.Local;
import model.Utilisateur;

@Local
public interface ConnectionEJBLocal {

    void AddUser(Utilisateur user);
            
    Utilisateur findUserByLogin(String login);
    
    ArrayList<String> findAllLogin();
}
