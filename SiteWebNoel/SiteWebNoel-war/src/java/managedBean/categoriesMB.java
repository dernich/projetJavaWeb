package managedBean;

import java.util.ArrayList;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.Article;
import model.Categorie;
import siteWebEJB.CategoryEJBLocal;

@ManagedBean
@RequestScoped
public class categoriesMB 
{    
    @EJB
    private CategoryEJBLocal categoryEJB;
    private ArrayList<Article> article;
    private ArrayList<String> listCategories;
    
    
    public categoriesMB() 
    {
        article = new ArrayList<>();
        article.add(new Article("Boule Bleue", "Papier d'une très haute qualitée","./images/bBleu.jpg", 0.50,41));
        article.add(new Article("Boule avec coeur", "Guirlande vraiment belle, olala", "./images/bCoeur.jpg", 50.60, 5));
        article.add(new Article("Boule Flocon", "Vieu modèle", "./images/bFlocon.jpg", 800.20, 12));
        article.add(new Article("Boule Jaune", "Boule avec coeur", "./images/bJaune.jpg", 3.20, 15));
        article.add(new Article("Boule Bleue Mate", "Boule rouge", "./images/bMate.jpg", 2.80, 0));
        article.add(new Article("Boule Pingouin", "Boule rose", "./images/bPingouin.jpg", 3.20, 10));
        article.add(new Article("Boule Rose", "Boule pingouin", "./images/bRose.jpg", 4.50, 20));
        article.add(new Article("Boule Verte", "Boule lumineuse", "./images/bVerte.jpg", 3.40, 20));
        article.add(new Article("Boule Verte à motif", "Boule verte", "./images/bVerteF.jpg", 3.20, 1));
    }
    
    public void addArticleList(Article a) {
        article.add(a);
    }
    
    public ArrayList<Article> getListeArticle()
    {
        return article;
    }
    
    public ArrayList<String> getListCategory()
    {
        return listCategories;
    }
    
    public ArrayList<Categorie> getCategoryByLanguage() {
        return categoryEJB.getCategoryByLanguage(1);
    }
}