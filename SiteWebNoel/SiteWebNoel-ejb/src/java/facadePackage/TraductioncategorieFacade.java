package facadePackage;

import entityPackage.Traductioncategorie;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class TraductioncategorieFacade extends AbstractFacade<Traductioncategorie> implements TraductioncategorieFacadeLocal {
    @PersistenceContext(unitName = "SiteWebNoel-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TraductioncategorieFacade() {
        super(Traductioncategorie.class);
    }
    
    @Override
    public List<Traductioncategorie> getCategorie(int idLangue){
        Query query;
        query = em.createNamedQuery("Traductioncategorie.findByLanguage");
        query.setParameter("idLangue", idLangue);
        return query.getResultList();
    }
}
