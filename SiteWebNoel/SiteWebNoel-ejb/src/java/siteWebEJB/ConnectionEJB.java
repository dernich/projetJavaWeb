package siteWebEJB;

import facadePackage.TraductionpaysFacadeLocal;
import facadePackage.UtilisateurFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.Pays;
import model.TraductionPays;
import model.Utilisateur;

@Stateless
public class ConnectionEJB implements ConnectionEJBLocal {
    
    @EJB
    private TraductionpaysFacadeLocal traductionpaysFacade;
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
    
    public ArrayList<TraductionPays> getAllTradPaysByLanguage(int langue) {
        List<entityPackage.Traductionpays> listTraduction = traductionpaysFacade.getAllTradPaysByLanguage(langue);
        ArrayList<TraductionPays> listCountries = new ArrayList<>();
        for(entityPackage.Traductionpays t : listTraduction) {
            listCountries.add(new TraductionPays(t.getId(), t.getTradlibellepays(), t.getIdLangue().getId()));
        }
        return listCountries;
    }
    
    public String getCountryByIdByLanguage(int id, int langue) {
        return traductionpaysFacade.findByIdByLanguage(id, langue);
    }
}
