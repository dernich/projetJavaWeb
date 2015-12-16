package facadePackage;

import entityPackage.Categorie;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CategorieFacadeLocal {

    void create(Categorie categorie);

    void edit(Categorie categorie);

    void remove(Categorie categorie);

    Categorie find(Object id);

    List<Categorie> findAll();

    List<Categorie> findRange(int[] range);

    int count();
    
}
