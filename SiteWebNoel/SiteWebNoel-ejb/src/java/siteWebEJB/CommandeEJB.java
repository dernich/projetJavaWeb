package siteWebEJB;

import facadePackage.ArticleFacadeLocal;
import facadePackage.CommandeFacadeLocal;
import facadePackage.LignecommandeFacadeLocal;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.LigneCommande;
import model.Utilisateur;

@Stateless
public class CommandeEJB implements CommandeEJBLocal {
    
    @EJB
    private ArticleFacadeLocal articleFacade;
    @EJB
    private LignecommandeFacadeLocal lignecommandeFacade;
    @EJB
    private CommandeFacadeLocal commandeFacade;

    public void createCommande(HashMap<Integer, LigneCommande> list, Utilisateur user, double total) {
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
        c.setPrixtotal(new BigDecimal(total).round(MathContext.DECIMAL32));
        commandeFacade.create(c);
        
        entityPackage.Commande com = commandeFacade.findByUserById(user.getId(), dateCom);
        for(Map.Entry<Integer, LigneCommande> lg : list.entrySet()){
            LigneCommande l = lg.getValue();
            entityPackage.Lignecommande ligne = new entityPackage.Lignecommande();
            entityPackage.Article a = new entityPackage.Article(l.getArticle().getId(),new BigDecimal(l.getArticle().getPrix()), (short)(l.getArticle().getQuantiteStock()- l.getQuantiteCommande()), l.getArticle().getUrlImage());
            
            ligne.setQuantitecommande(l.getQuantiteCommande());
            ligne.setPrixreel(new BigDecimal(l.getArticle().getPrix(), MathContext.DECIMAL64));
            ligne.setIdArticle(a);
            ligne.setNumeroCommande(com);
            lignecommandeFacade.create(ligne);
            entityPackage.Article art = articleFacade.findById(a.getId());
            art.setQuantitestock((short)(art.getQuantitestock() - l.getQuantiteCommande()));
            articleFacade.edit(art);
        }
    }
}
