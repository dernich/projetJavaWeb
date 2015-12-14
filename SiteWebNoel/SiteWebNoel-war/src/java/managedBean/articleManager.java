package managedBean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;
import javax.ejb.EJB;
import model.Article;
import siteWebEJB.ArticleEJBLocal;

@Named(value = "articleManager")
@SessionScoped
public class articleManager implements Serializable {
    
    @EJB
    private ArticleEJBLocal articleEJB;
    private Article articleToManage;
    private ArrayList<Article> articles = new ArrayList<>();
    private BasketMB basket = new BasketMB();
    
    public articleManager() {
    }
    
    public String outcome(){
        return "details";
    }
    
    public Article getArticleToManage(){
        return articleToManage;
    }
    
    public void setArticleToManage(Article article){
        articleToManage = article;
    }
    
    public ArrayList<Article> getArticleFromCategorie(Locale langue, int idCategorie){
        
        switch(langue.getLanguage()){
            case "fr" : articles = articleEJB.getArticleFromCategorie(1, idCategorie);
                break;
            case "en" : articles = articleEJB.getArticleFromCategorie(2, idCategorie);
                break;
            default : articles = articleEJB.getArticleFromCategorie(3, idCategorie);
                break;
        }
        
        return articles;
    }
    
    public String setArticleDetails(Article article){
        setArticleToManage(article);
        return "details.xhtml";
    }
    
    public void addArticle() {
        basket.addArticleList(articleToManage);
    }
}
