package sessionBeanPackage;

import entityPackage.Traductionarticle;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TraductionarticleFacade extends AbstractFacade<Traductionarticle> implements TraductionarticleFacadeLocal {
    @PersistenceContext(unitName = "SiteWebNoel-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TraductionarticleFacade() {
        super(Traductionarticle.class);
    }
    
}
