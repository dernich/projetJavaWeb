package siteWebEJB;

import java.util.ArrayList;
import javax.ejb.Stateless;
import model.Categorie;
import sessionBeanPackage.TraductioncategorieFacade;

@Stateless
public class CategoryEJB implements CategoryEJBLocal {

    private TraductioncategorieFacade categorieFacade;
    
    @Override
    public ArrayList<Categorie> getCategoryByLanguage(int langue) {
        return categorieFacade.getCategoryByLanguage(langue);
    }
}
