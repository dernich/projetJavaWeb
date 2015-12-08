package siteWebEJB;

import entityPackage.Pays;
import facadePackage.PaysFacadeLocal;
import facadePackage.UtilisateurFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.Utilisateur;

@Stateless
public class ConnectionEJB implements ConnectionEJBLocal {
    @EJB
    private PaysFacadeLocal paysFacade;
    @EJB
    private UtilisateurFacadeLocal utilisateurFacade;
    
    /*@Override
    public Utilisateur UserConnection(String login) {
        return userFacade.UserConnection(login);
    }*/

   @Override
    public void AddUser(Utilisateur user) {
        entityPackage.Utilisateur userBD = new entityPackage.Utilisateur();
        entityPackage.Pays pays = new entityPackage.Pays();
        userBD.setNom(user.getNom());
        userBD.setPrenom(user.getPrenom());
        userBD.setEmail(user.getEmail());
        userBD.setRue(user.getRue());
        userBD.setNumeromaison((short)user.getNumeromaison());
        userBD.setLocalite(user.getLocalite());
        userBD.setCodepostal((short)user.getCodepostal());
        pays.setId(user.getIdPays().getId());
        pays.setLibelle("Belgique");
        userBD.setIdPays(pays);
        userBD.setLogin(user.getLogin());
        userBD.setMotdepasse(user.getMotdepasse());
        utilisateurFacade.create(userBD);
    }
    
    @Override
    public model.Pays getPaysById(Integer id) {
        model.Pays p = paysFacade.getPaysById(id);
        return p;
    }
}
