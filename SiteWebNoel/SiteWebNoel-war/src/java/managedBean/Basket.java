package managedBean;

import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Article;

@ManagedBean
@SessionScoped
public class Basket {

    private ArrayList<Article> article;
    private Double total = 0.0;
    private Double promotion= 0.0;
    
    public Basket() {
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
        DecimalFormat df = new DecimalFormat("0.00");
        df.format(total);
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
        return promotion * 100;
    }

    public void setPromotion(Double promotion) {
        this.promotion = promotion;
    }
}
