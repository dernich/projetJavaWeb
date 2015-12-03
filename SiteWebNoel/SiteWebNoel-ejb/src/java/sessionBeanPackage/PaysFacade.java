package sessionBeanPackage;

import entityPackage.Pays;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
}
