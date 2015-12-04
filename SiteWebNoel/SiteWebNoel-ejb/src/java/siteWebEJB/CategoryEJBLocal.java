package siteWebEJB;

import java.util.ArrayList;
import javax.ejb.Local;
import model.Categorie;

@Local
public interface CategoryEJBLocal {
    
    ArrayList<Categorie> getCategoryByLanguage(int langue);
}
