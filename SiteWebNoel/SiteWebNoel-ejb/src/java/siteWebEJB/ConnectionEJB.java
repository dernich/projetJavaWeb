package siteWebEJB;

import facadePackage.UtilisateurFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.Pays;
import model.Utilisateur;

@Stateless
public class ConnectionEJB implements ConnectionEJBLocal {
    
    @EJB
    private UtilisateurFacadeLocal utilisateurFacade;

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
        userBD.setIdPays(pays);
        userBD.setLogin(user.getLogin());
        userBD.setMotdepasse(user.getMotdepasse());
        userBD.setTelephone(user.getTelephone());
        utilisateurFacade.create(userBD);
    }
    
    public Utilisateur findUserByLogin(String login) {
        entityPackage.Utilisateur userBD = utilisateurFacade.findUserByLogin(login);
        if(userBD == null) {
            return null;
        }
        else {
            Pays p = new Pays(userBD.getIdPays().getId());
            Utilisateur u = new Utilisateur(userBD.getId(), userBD.getNom(),userBD.getPrenom(), userBD.getEmail(), userBD.getLogin(), userBD.getMotdepasse(), userBD.getRue(), userBD.getNumeromaison(), userBD.getCodepostal(), userBD.getLocalite(), p);
            return u;
        }
    }
    
    @Override
    public ArrayList<String> findAllLogin(){
        List<String> listLogin = utilisateurFacade.findAllLogin();
        ArrayList<String> allLogin = new ArrayList(listLogin);
        return allLogin;
    }
}
