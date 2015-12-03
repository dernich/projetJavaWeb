package sessionBeanPackage;

import entityPackage.Pays;
import java.util.List;
import javax.ejb.Local;

@Local
public interface PaysFacadeLocal {

    void create(Pays pays);

    void edit(Pays pays);

    void remove(Pays pays);

    Pays find(Object id);

    List<Pays> findAll();

    List<Pays> findRange(int[] range);

    int count();
    
}
