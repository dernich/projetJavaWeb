package facadePackage;

import entityPackage.Categorie;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CategorieFacade extends AbstractFacade<Categorie> implements CategorieFacadeLocal {
    @PersistenceContext(unitName = "SiteWebNoel-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategorieFacade() {
        super(Categorie.class);
    }
    
}
