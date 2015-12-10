package facadePackage;

import entityPackage.Traductioncategorie;
import java.util.List;
import javax.ejb.Local;

@Local
public interface TraductioncategorieFacadeLocal {

    void create(Traductioncategorie traductioncategorie);

    void edit(Traductioncategorie traductioncategorie);

    void remove(Traductioncategorie traductioncategorie);

    Traductioncategorie find(Object id);

    List<Traductioncategorie> findAll();

    List<Traductioncategorie> findRange(int[] range);

    int count();
    
    List<Traductioncategorie> getCategorie(int idLangue);
}
