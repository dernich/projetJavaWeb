package managedBean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import javax.ejb.EJB;
import model.Article;
import model.LigneCommande;
import model.Utilisateur;
import siteWebEJB.CommandeEJBLocal;

@Named(value = "basketMB")
@SessionScoped
public class BasketMB implements Serializable {
    
    @EJB
    private CommandeEJBLocal commandeEJB;
    private ArrayList<LigneCommande> ligneCommande = new ArrayList<>();
    private Double total = 0.0;
    private Double subtotal = 0.0;
    private Double promotion= 0.0;
    private Article art;
    
    public BasketMB() {
        
    }
    
    /*public void quantityChanged(ValueChangeEvent e) {
        int quantiteChange = Integer.parseInt(e.getNewValue().toString());
        ligneCommande.get(i).setQuantite(quantiteChange);
        
    }*/

    public Article getArt() {
        return art;
    }

    public void setArt(Article art) {
        this.art = art;
    }
    
    public void addArticleList(Article a) {
        if(a.getQuantiteStock() > 0) {
            ligneCommande.add(new LigneCommande(a, 1));
            subtotal += a.getPrix();
        }
    }
    
    public void delArticle(LigneCommande ligne) {
        for(LigneCommande l : ligneCommande) {
            if(l.equals(ligne)) {
                ligneCommande.remove(l);
            }
        }
        //total -= a.getPrix();
    }
    
    public ArrayList<LigneCommande> getListePanier()
    {
        return ligneCommande;
    }

    public Double getTotal() {
        total = subtotal - (subtotal * promotion);
        total =(double)((int)(total*100))/100;
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
    public Double getSubtotal() {
        subtotal =(double)((int)(subtotal*100))/100;
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
    
    public int countList() {
        return ligneCommande.size();
    }

    public Double getPromotion() {
        if(subtotal > 100.00) {
            promotion = 0.20;
        }
        else {
            if(subtotal > 50.00) {
                promotion = 0.10;
            }
        }
        promotion =(double)((int)(promotion*100))/100;
        return promotion * 100;
    }

    public void setPromotion(Double promotion) {
        this.promotion = promotion;
    }
    
    public String createCommande(Utilisateur user){
        commandeEJB.createCommande(ligneCommande, user);
        return "confirmation.xhml";
    }
}