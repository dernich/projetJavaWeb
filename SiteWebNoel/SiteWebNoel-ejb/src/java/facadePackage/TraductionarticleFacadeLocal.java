package facadePackage;

import entityPackage.Traductionarticle;
import java.util.List;
import javax.ejb.Local;

@Local
public interface TraductionarticleFacadeLocal {

    void create(Traductionarticle traductionarticle);

    void edit(Traductionarticle traductionarticle);

    void remove(Traductionarticle traductionarticle);

    Traductionarticle find(Object id);

    List<Traductionarticle> findAll();

    List<Traductionarticle> findRange(int[] range);

    int count();
    
    List<Traductionarticle> getArticleFromCategorie(int langue, int idCategorie);
}
