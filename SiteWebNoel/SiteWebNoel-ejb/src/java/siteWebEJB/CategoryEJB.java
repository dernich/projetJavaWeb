package siteWebEJB;

import facadePackage.TraductioncategorieFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class CategoryEJB implements CategoryEJBLocal {
    
    @EJB
    private TraductioncategorieFacadeLocal traductioncategorieFacade;
    
    @Override
    public ArrayList<model.Categorie> getCategories(int idLangue){
       
        List<entityPackage.Traductioncategorie> listTraduction = traductioncategorieFacade.getCategorie(idLangue);
        ArrayList<model.Categorie> listCategorie = new ArrayList<>();
        for(entityPackage.Traductioncategorie t : listTraduction) {
            listCategorie.add(new model.Categorie(t.getTradlibellecategorie(), t.getIdCategorie().getId()));
        }
        
        return listCategorie;
    }
}
