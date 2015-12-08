package facadePackage;

import entityPackage.Pays;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class PaysFacade extends AbstractFacade<Pays> implements PaysFacadeLocal {
    @PersistenceContext(unitName = "SiteWebNoel-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PaysFacade() {
        super(Pays.class);
    }
    
    @Override
    public model.Pays getPaysById(Integer id) {
        Query query;
        query = em.createNamedQuery("Pays.findById");
        query.setParameter("id", id);
        Pays p = (Pays)query.getSingleResult();
        model.Pays pays = new model.Pays(p.getId(), p.getLibelle());
        return pays;
    }
}
