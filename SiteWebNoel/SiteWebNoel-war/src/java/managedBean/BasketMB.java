package managedBean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map.Entry;
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
    private HashMap<Integer, LigneCommande> caddy = new HashMap<>();
    private Double total = 0.0;
    private Double subtotal = 0.0;
    private Double promotion= 0.0;
    private Article art;
    private boolean dejaPresent;
    
    public BasketMB() {
    }
    
    public void addQuantity(Integer id){
        LigneCommande ligne = caddy.get(id);
        int quantity = ligne.getQuantiteCommande();
        if(quantity < ligne.getArticle().getQuantiteStock()) {
            quantity++;
            ligne.setTotalArticle(ligne.getArticle().getPrix());
            subtotal += ligne.getArticle().getPrix();
            calculPromotion();
        }
        ligne.setQuantiteCommande(quantity);
        setSubtotal(subtotal);
    }
   
    public void decQuantity(Integer id){
        LigneCommande ligne = caddy.get(id);
        int quantity = ligne.getQuantiteCommande();
        if(quantity > 1) {
            quantity--;
            ligne.setTotalArticle(-ligne.getArticle().getPrix());
            subtotal -= ligne.getArticle().getPrix();   
            calculPromotion();
        }
        ligne.setQuantiteCommande(quantity);
        setSubtotal(subtotal);
    }
   
    public Article getArt() {
        return art;
    }

    public void setArt(Article art) {
        this.art = art;
    }
    
    public void addArticleList(Article a) {
        dejaPresent = false;
        for(Entry<Integer, LigneCommande> lg : caddy.entrySet()){
            Integer cle = lg.getKey();
            if(a.getId() == cle){
                dejaPresent = true;
            }
        }
        if(a.getQuantiteStock() > 0){
             if(!dejaPresent){
                caddy.put(a.getId(), new LigneCommande(a, a.getQuantiteCommand()));
                subtotal += a.getPrix() * a.getQuantiteCommand();
             } else {
                LigneCommande lg = caddy.get(a.getId());
                lg.setQuantiteCommande(lg.getQuantiteCommande() + a.getQuantiteCommand());
                
                subtotal += a.getPrix() * a.getQuantiteCommand();
                lg.setTotalArticle(a.getPrix() * a.getQuantiteCommand());
            } 
        }
    } 
    
    public void delArticle(LigneCommande ligne) {
        caddy.remove(ligne.getArticle().getId());
        subtotal -= ligne.getTotalArticle();
        calculPromotion();
    }
    
    public HashMap<Integer, LigneCommande> getListePanier()
    {
        return caddy;
    }

    public Double getTotal() {
        total = subtotal - (subtotal * promotion);
        total =(double)((int)(total*100))/100;
        if(total < 0) {
            total = 0.0;
        }
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
        if(this.subtotal < 0 ) {
            this.subtotal = 0.0;
        }
    }
    
    public int countList() {
        return caddy.size();
    }

    public Double getPromotion() {
        calculPromotion();
        return promotion * 100;
    }
    
    public void calculPromotion() {
        if(subtotal > 100.00) {
            promotion = 0.20;
        }
        else {
            if(subtotal > 50.00) {
                promotion = 0.10;
            }
            else {
                promotion = 0.00;
            }
        }
        promotion =(double)((int)(promotion*100))/100;
    }
    
    public void setPromotion(Double promotion) {
        this.promotion = promotion;
    }
    
    public void createCommande(Utilisateur user){
        if(!caddy.isEmpty()) {
            commandeEJB.createCommande(caddy, user, total);
        }
    }
}