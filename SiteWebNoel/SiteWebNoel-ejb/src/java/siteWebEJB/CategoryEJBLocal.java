package siteWebEJB;

import java.util.ArrayList;
import javax.ejb.Local;

@Local
public interface CategoryEJBLocal {
    
    ArrayList<model.Categorie> getCategories(int idLangue);
}
