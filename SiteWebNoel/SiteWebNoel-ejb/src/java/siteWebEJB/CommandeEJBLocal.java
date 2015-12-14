package siteWebEJB;

import java.util.ArrayList;
import javax.ejb.Local;
import model.LigneCommande;
import model.Utilisateur;

@Local
public interface CommandeEJBLocal {
    
    void createCommande(ArrayList<LigneCommande> list, Utilisateur user);
}
