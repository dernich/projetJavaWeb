package facadePackage;

import entityPackage.Lignecommande;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class LignecommandeFacade extends AbstractFacade<Lignecommande> implements LignecommandeFacadeLocal {
    @PersistenceContext(unitName = "SiteWebNoel-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LignecommandeFacade() {
        super(Lignecommande.class);
    }
    
    @Override
    public void create(Lignecommande ligne) {
        em.persist(ligne);
    }
}
