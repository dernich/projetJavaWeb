package managedBean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;
import javax.ejb.EJB;
import model.TraductionPays;
import siteWebEJB.ConnectionEJBLocal;
import siteWebEJB.CountryEJBLocal;

@Named(value = "paysMB")
@SessionScoped
public class PaysMB implements Serializable {
    
    @EJB
    private CountryEJBLocal countryEJB;
    private ArrayList<TraductionPays> countries;
    
    public PaysMB() {
        
    }

    public ArrayList<TraductionPays> getAllTradPaysByLanguage(Locale langue) {
        countries = new ArrayList<>();
        switch(langue.getLanguage()){
            case "fr" : countries = countryEJB.getAllTradPaysByLanguage(1);
                break;
            case "en" : countries = countryEJB.getAllTradPaysByLanguage(2);
                break;
            default : countries = countryEJB.getAllTradPaysByLanguage(2);
                break;
        }
        
        return countries;
    }
}
