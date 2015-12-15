package siteWebEJB;

import java.util.ArrayList;
import javax.ejb.Local;

@Local
public interface CountryEJBLocal {
    
    ArrayList<model.TraductionPays> getAllTradPaysByLanguage(int langue);
    
    String getCountryByIdByLanguage(int id, int langue);
}
