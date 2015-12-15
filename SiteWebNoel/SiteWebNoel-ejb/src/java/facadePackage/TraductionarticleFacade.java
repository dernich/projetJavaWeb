package facadePackage;

import entityPackage.Traductionarticle;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    
    @Override
    public List<Traductionarticle> getArticleFromCategorie(int langue, int idCategorie){
        Query query;
        query = em.createNamedQuery("Traductionarticle.findByCategorie");
        query.setParameter("idCategorie", idCategorie);
        query.setParameter("idLangue", langue);
        return query.getResultList();
    }
}
