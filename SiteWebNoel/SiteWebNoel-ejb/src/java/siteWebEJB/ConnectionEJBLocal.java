package siteWebEJB;

import javax.ejb.Local;
import model.Utilisateur;

@Local
public interface ConnectionEJBLocal {

    void AddUser(Utilisateur user);

    //Utilisateur UserConnection(String login);
    
}
