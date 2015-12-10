package facadePackage;

import entityPackage.Langue;
import java.util.List;
import javax.ejb.Local;

@Local
public interface LangueFacadeLocal {

    void create(Langue langue);

    void edit(Langue langue);

    void remove(Langue langue);

    Langue find(Object id);

    List<Langue> findAll();

    List<Langue> findRange(int[] range);

    int count();
    
}
