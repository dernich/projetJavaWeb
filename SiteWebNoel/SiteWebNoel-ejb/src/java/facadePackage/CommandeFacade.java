package facadePackage;

import entityPackage.Commande;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class CommandeFacade extends AbstractFacade<Commande> implements CommandeFacadeLocal {
    @PersistenceContext(unitName = "SiteWebNoel-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CommandeFacade() {
        super(Commande.class);
    }
    
    @Override
    public void create(Commande commande) {
        em.persist(commande);
    }
    
    public Commande findByUserById(int idUser, Date dateCom) {
        Query query;
        query = em.createNamedQuery("Commande.findByUser");
        query.setParameter("idUser", idUser);
        query.setParameter("dateCom", dateCom);
        Commande c = (Commande)query.getSingleResult();
        return c;
    }
    
    public List<Commande> findAll() {
        Query query;
        query = em.createNamedQuery("Commande.findAll");
        return query.getResultList();
    }
}
