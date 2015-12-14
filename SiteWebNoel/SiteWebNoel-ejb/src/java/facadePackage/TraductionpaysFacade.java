package facadePackage;

import entityPackage.Traductionpays;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class TraductionpaysFacade extends AbstractFacade<Traductionpays> implements TraductionpaysFacadeLocal {
    @PersistenceContext(unitName = "SiteWebNoel-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TraductionpaysFacade() {
        super(Traductionpays.class);
    }
    
    @Override
    public List<Traductionpays> getAllTradPaysByLanguage(int langue) {
        Query query;
        query = em.createNamedQuery("Traductionpays.findByLanguage");
        query.setParameter("idLangue", langue);
        return query.getResultList();
    }
    
    public String findByIdByLanguage(int id, int langue) {
        Query query;
        query = em.createNamedQuery("Traductionpays.findByIdByLanguage");
        query.setParameter("idPays", id);
        query.setParameter("idLangue", langue);
        return (String)query.getSingleResult();
    }
}
