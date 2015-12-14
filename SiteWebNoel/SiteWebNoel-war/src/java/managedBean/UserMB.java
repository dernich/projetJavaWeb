package managedBean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.security.Key;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.ejb.EJB;
import javax.faces.event.ValueChangeEvent;
import model.Pays;
import model.Utilisateur;
import siteWebEJB.ConnectionEJBLocal;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

@Named(value = "userMB")
@SessionScoped
public class UserMB implements Serializable {
    
    @EJB
    private ConnectionEJBLocal connectionEJB;
    private Utilisateur user = new Utilisateur();
    private String login;
    private String mdp;
    private String selectedCountry = "1";
    private String pays;
    private boolean connected = false;
    private static final byte[] keyCode = new byte [] {'T', 'h', 'i', 's', 'I', 's', 'A', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y'};
    
    public UserMB() {
    }
    
    public void countryChanged(ValueChangeEvent e) {
        selectedCountry = e.getNewValue().toString();
    }

    public String getSelectedCountry() {
        return selectedCountry;
    }

    public void setSelectedCountry(String selectedCountry) {
        this.selectedCountry = selectedCountry;
    }
    
    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }
    
    public String addUser() {
        user.setIdPays(new Pays(Integer.parseInt(selectedCountry)));
        try {
            user.setMotdepasse(cryptPassword(user.getMotdepasse(), true));
        }
        catch(Exception e) {
            
        }
        connectionEJB.AddUser(user);
        setConnected(true);
        return "confirmation.xhtml";
    }
    
    private static Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyCode, "AES");
        return key;
    }
    
    public String connection() throws Exception {
        Utilisateur u = connectionEJB.findUserByLogin(login);
        if(u != null) {
            try {
            u.setMotdepasse(cryptPassword(u.getMotdepasse(), false));
            }
            catch(Exception e) { }
            if(u.getMotdepasse().equals(mdp)) {
                setConnected(true);
                user = u;
                return "categories.xhtml";
            }
            else {
                return "connection.xhtml";
            }
        }
        else {
            return "connection.xhtml";
        }
    }
    
    public String logout() {
        setConnected(false);
        user = null;
        return "connection.xhtml";
    }

    public Boolean getConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    
    public String cryptPassword(String mdp, boolean crypt) throws Exception {
        byte[] mdpByte = mdp.getBytes();
        Key key = generateKey();
        Cipher cipher = Cipher.getInstance("AES");
        if(crypt) {
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] cipherText = cipher.doFinal(mdpByte);
            String encryptedValue = new BASE64Encoder().encode(cipherText);
            return encryptedValue;
        }
        else {
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] password = cipher.doFinal(new BASE64Decoder().decodeBuffer(mdp));
            return new String(password);
        }
    }

    public String getUserPays(Locale langue) {
        String pays;
        switch(langue.getLanguage()){
            case "fr" : pays = connectionEJB.getCountryByIdByLanguage(user.getIdPays().getId(), 1);
                break;
            case "en" : pays = connectionEJB.getCountryByIdByLanguage(user.getIdPays().getId(), 2);
                break;
            default : pays = connectionEJB.getCountryByIdByLanguage(user.getIdPays().getId(), 2);
                break;
        }
        return pays;
    }
}
