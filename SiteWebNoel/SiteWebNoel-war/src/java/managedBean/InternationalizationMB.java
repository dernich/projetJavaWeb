package managedBean;

import java.io.Serializable;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

@ManagedBean
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
