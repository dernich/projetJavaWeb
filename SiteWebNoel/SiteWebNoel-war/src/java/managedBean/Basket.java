package managedBean;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Basket {

    private ArrayList<testArticle> article;
    private Double total;
    
    public Basket() {
        article = new ArrayList<testArticle>();
    }
    
    public void addArticleList(testArticle a) {
        if(a.getQuantiteStock() > 0) {
            article.add(a);
        }
    }
    
    public ArrayList<testArticle> getListePanier()
    {
        return article;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
