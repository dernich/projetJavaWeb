package managedBean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;
import javax.ejb.EJB;
import model.TraductionPays;
import siteWebEJB.ConnectionEJBLocal;

@Named(value = "paysMB")
@SessionScoped
public class PaysMB implements Serializable {
    
    @EJB
    private ConnectionEJBLocal connectionEJB;
    private ArrayList<TraductionPays> countries;
    
    public PaysMB() {
        
    }

    public ArrayList<TraductionPays> getAllTradPaysByLanguage(Locale langue) {
        countries = new ArrayList<>();
        switch(langue.getLanguage()){
            case "fr" : countries = connectionEJB.getAllTradPaysByLanguage(1);
                break;
            case "en" : countries = connectionEJB.getAllTradPaysByLanguage(2);
                break;
            default : countries = connectionEJB.getAllTradPaysByLanguage(2);
                break;
        }
        
        return countries;
    }
}
