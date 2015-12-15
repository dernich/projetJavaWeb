package facadePackage;

import entityPackage.Traductionpays;
import java.util.List;
import javax.ejb.Local;

@Local
public interface TraductionpaysFacadeLocal {

    void create(Traductionpays traductionpays);

    void edit(Traductionpays traductionpays);

    void remove(Traductionpays traductionpays);

    Traductionpays find(Object id);

    List<Traductionpays> findAll();

    List<Traductionpays> findRange(int[] range);

    int count();
    
    List<Traductionpays> getAllTradPaysByLanguage(int langue);
    
    String findByIdByLanguage(int id, int langue);
}
