package managedBean;

import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Basket {

    private ArrayList<testArticle> article;
    private Double total = 0.0;
    
    public Basket() {
        article = new ArrayList<>();
    }
    
    public void addArticleList(testArticle a) {
        if(a.getQuantiteStock() > 0) {
            article.add(a);
            total += a.getPrix();
        }
    }
    
    public void delArticle(testArticle a) {
        for(int i=0; i < article.size(); i++) {
            if(article.get(i).equals(a)) {
                article.remove(i);
            }
        }
        total -= a.getPrix();
    }
    
    public ArrayList<testArticle> getListePanier()
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
}
