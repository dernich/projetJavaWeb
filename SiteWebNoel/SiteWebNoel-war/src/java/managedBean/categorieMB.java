package managedBean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;
import javax.ejb.EJB;
import model.Categorie;
import siteWebEJB.CategoryEJBLocal;

@Named(value = "categorieMB")
@SessionScoped
public class categorieMB implements Serializable {
    @EJB
    private CategoryEJBLocal categoryEJB;
    private ArrayList<Categorie> categories = new ArrayList<>();
    private int categorieSelected;
    
    public categorieMB() {
    }
    
    public ArrayList<Categorie> getCategories(Locale langue){
        
        switch(langue.getLanguage()){
            case "fr" : categories = categoryEJB.getCategories(1);
                break;
            case "en" : categories = categoryEJB.getCategories(2);
                break;
            default : categories = categoryEJB.getCategories(2);
                break;
        }
        
        return categories;
    }
    
    public int getCategorieSelected(){
        return categorieSelected;
    }
    
    public String setCategorieSelected(int categorieSelected){
        
        this.categorieSelected = categorieSelected;
        return "faces/categories.xhtml";
    }
}
