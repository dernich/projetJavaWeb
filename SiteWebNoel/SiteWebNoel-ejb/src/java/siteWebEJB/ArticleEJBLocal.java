package siteWebEJB;

import java.util.ArrayList;
import javax.ejb.Local;

@Local
public interface ArticleEJBLocal {
    
    ArrayList<model.Article> getArticleFromCategorie(int langue, int idCategorie);
}
