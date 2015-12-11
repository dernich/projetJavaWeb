package managedBean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.ejb.EJB;
import javax.faces.event.ValueChangeEvent;
import model.Pays;
import model.Utilisateur;
import siteWebEJB.ConnectionEJBLocal;

@Named(value = "userMB")
@SessionScoped
public class UserMB implements Serializable {
    
    @EJB
    private ConnectionEJBLocal connectionEJB;
    private Utilisateur user;
    private String login;
    private String mdp;
    private String selectedCountry = "1";
    private String pays;
    private boolean connected = false;
    private KeyGenerator keyGen;
    private Key key;
    
    public UserMB() throws Exception {
        user = new Utilisateur();
        try {
        keyGen = KeyGenerator.getInstance("DES");
        keyGen.init(56);
        key = keyGen.generateKey();
        }
        catch(Exception e) { }
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
        /*try {
            user.setMotdepasse(cryptPassword(user.getMotdepasse(), true));
        }
        catch(Exception e) {
            
        }*/
        connectionEJB.AddUser(user);
        setConnected(true);
        return "confirmation.xhtml";
    }
    
    public String connection() {
        Utilisateur u = connectionEJB.findUserByLogin(login);
        if(u != null) {
            /*try {
            u.setMotdepasse(cryptPassword(u.getMotdepasse(), false));
            }
            catch(Exception e) {
                
            }*/
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
        
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        if(crypt) {
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] cipherText = cipher.doFinal(mdpByte);
            System.out.println(new String(cipherText, "UTF8"));
            return new String(cipherText, "UTF8");
        }
        else {
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] password = cipher.doFinal(mdpByte);
            return new String(password, "UTF8");
        }
    }
}
