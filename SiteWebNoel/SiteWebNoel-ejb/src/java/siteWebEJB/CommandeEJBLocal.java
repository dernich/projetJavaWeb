package siteWebEJB;

import java.util.HashMap;
import javax.ejb.Local;
import model.LigneCommande;
import model.Utilisateur;

@Local
public interface CommandeEJBLocal {
    
    void createCommande(HashMap<Integer, LigneCommande> list, Utilisateur user, double total);
}
