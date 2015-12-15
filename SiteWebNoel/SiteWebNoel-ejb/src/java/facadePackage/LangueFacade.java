package facadePackage;

import entityPackage.Langue;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class LangueFacade extends AbstractFacade<Langue> implements LangueFacadeLocal {
    @PersistenceContext(unitName = "SiteWebNoel-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LangueFacade() {
        super(Langue.class);
    }
    
}
