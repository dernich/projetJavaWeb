package siteWebEJB;

import javax.ejb.Stateless;
import sessionBeanPackage.UtilisateurFacade;
import model.Utilisateur;

@Stateless
public class ConnectionEJB implements ConnectionEJBLocal {

    private UtilisateurFacade userFacade;
    
    /*@Override
    public Utilisateur UserConnection(String login) {
        return userFacade.UserConnection(login);
    }*/

    @Override
    public void AddUser(Utilisateur user) {
        userFacade.CreateUser(user);
    }
}
