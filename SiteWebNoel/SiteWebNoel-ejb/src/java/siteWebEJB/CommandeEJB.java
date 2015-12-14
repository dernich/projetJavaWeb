package siteWebEJB;

import facadePackage.CommandeFacadeLocal;
import facadePackage.LignecommandeFacadeLocal;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.LigneCommande;
import model.Utilisateur;

@Stateless
public class CommandeEJB implements CommandeEJBLocal {
    @EJB
    private LignecommandeFacadeLocal lignecommandeFacade;
    @EJB
    private CommandeFacadeLocal commandeFacade;

    public void createCommande(ArrayList<LigneCommande> list, Utilisateur user) {
        entityPackage.Commande c = new entityPackage.Commande();
        Date dateCom = new Date();
        c.setDatecommande(dateCom);
        entityPackage.Utilisateur userBD = new entityPackage.Utilisateur();
        entityPackage.Pays pays = new entityPackage.Pays();
        userBD.setId(user.getId());
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
        c.setIdUtilisateur(userBD);
        commandeFacade.create(c);
        
        entityPackage.Commande com = commandeFacade.findByUserById(user.getId(), dateCom);
        for(LigneCommande l : list) {
            entityPackage.Lignecommande ligne = new entityPackage.Lignecommande();
            entityPackage.Article a = new entityPackage.Article(l.getArticle().getId(),new BigDecimal(l.getArticle().getPrix()), (short)l.getArticle().getQuantiteStock(), l.getArticle().getUrlImage());
            
            ligne.setQuantitecommande(l.getQuantiteCommande());
            ligne.setPrixreel(new BigDecimal(l.getArticle().getPrix(), MathContext.DECIMAL64));
            ligne.setIdArticle(a);
            ligne.setNumeroCommande(com);
            lignecommandeFacade.create(ligne);
        }
    }
}
