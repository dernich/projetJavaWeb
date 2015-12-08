package siteWebEJB;

import javax.ejb.Local;
import model.Utilisateur;

@Local
public interface ConnectionEJBLocal {

    void AddUser(Utilisateur user);

    model.Pays getPaysById(Integer id);
            
    //Utilisateur UserConnection(String login);
    
}
