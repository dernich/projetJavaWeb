package facadePackage;

import entityPackage.Commande;
import entityPackage.Utilisateur;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CommandeFacadeLocal {

    void create(Commande commande);

    void edit(Commande commande);

    void remove(Commande commande);

    Commande find(Object id);

    List<Commande> findAll();

    List<Commande> findRange(int[] range);

    int count();
    
    Commande findByUserById(int idUser, Date dateCom);
}
