package managedBean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Locale;

@Named(value = "internationalizationMB")
@SessionScoped
public class InternationalizationMB implements Serializable {

    private Locale locale = new Locale("fr");

    public Locale getLocale() {
        return locale;
    }
    
    public InternationalizationMB() { }
    
    public void setToEnglish() {
        locale = new Locale("en");
    }
    
    public void setToFrench() {
        locale = new Locale("fr");
    }
}
