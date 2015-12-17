package siteWebEJB;

import facadePackage.TraductionpaysFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.TraductionPays;

@Stateless
public class CountryEJB implements CountryEJBLocal {
    
    @EJB
    private TraductionpaysFacadeLocal traductionpaysFacade;
    
    public ArrayList<TraductionPays> getAllTradPaysByLanguage(int langue) {
        List<entityPackage.Traductionpays> listTraduction = traductionpaysFacade.getAllTradPaysByLanguage(langue);
        ArrayList<TraductionPays> listCountries = new ArrayList<>();
        for(entityPackage.Traductionpays t : listTraduction) {
            listCountries.add(new TraductionPays(t.getId(), t.getTradlibellepays(), t.getIdLangue().getId()));
        }
        return listCountries;
    }
    
    public String getCountryByIdByLanguage(int id, int langue) {
        return traductionpaysFacade.findByIdByLanguage(id, langue);
    }
}
