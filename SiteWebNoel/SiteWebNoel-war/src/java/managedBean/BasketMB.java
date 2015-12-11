package managedBean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import model.Article;

@Named(value = "basketMB")
@SessionScoped
public class BasketMB implements Serializable {

    private ArrayList<Article> article;
    private Double total = 0.0;
    private Double promotion= 0.0;
    private Article art;
    
    public BasketMB() {
        article = new ArrayList<>();
    }
    
    public void addArticleList(Article a) {
        if(a.getQuantiteStock() > 0) {
            article.add(a);
            total += a.getPrix();
        }
    }
    
    public void delArticle(Article a) {
        for(int i=0; i < article.size(); i++) {
            if(article.get(i).equals(a)) {
                article.remove(i);
            }
        }
        total -= a.getPrix();
    }
    
    public ArrayList<Article> getListePanier()
    {
        return article;
    }

    public Double getTotal() {
        total =(double)((int)(total*100))/100;
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
    public int countList() {
        return article.size();
    }

    public Double getPromotion() {
        if(total > 100.00) {
            promotion = 0.2;
        }
        else {
            if(total > 50.00) {
                promotion = 0.1;
            }
        }
        promotion =(double)((int)(promotion*100))/100;
        return promotion * 100;
    }

    public void setPromotion(Double promotion) {
        this.promotion = promotion;
    }

    public Article getArt() {
        return art;
    }

    public void setArt(Article art) {
        this.art = art;
        addArticleList(art);
    }
}
