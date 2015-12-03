package sessionBeanPackage;

import entityPackage.Utilisateur;
import java.util.List;
import javax.ejb.Local;

@Local
public interface UtilisateurFacadeLocal {

    void create(Utilisateur utilisateur);

    void edit(Utilisateur utilisateur);

    void remove(Utilisateur utilisateur);

    Utilisateur find(Object id);

    List<Utilisateur> findAll();

    List<Utilisateur> findRange(int[] range);

    int count();
    
    //Utilisateur UserConnection(String login);

    void CreateUser(model.Utilisateur user);
}
