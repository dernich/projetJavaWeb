package facadePackage;

import entityPackage.Pays;
import java.util.ArrayList;
import java.util.List;
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
    public ArrayList<model.Pays> getAllPays() {
        List<Pays> list = findAll();
        ArrayList<model.Pays> list2 = new ArrayList<>();
        for(Pays p : list) {
            list2.add(new model.Pays(p.getId()));
        }
        return list2;
    }
    
    @Override
    public model.Pays getPaysById(Integer id) {
        Query query;
        query = em.createNamedQuery("Pays.findById");
        query.setParameter("id", id);
        Pays p = (Pays)query.getSingleResult();
        model.Pays pays = new model.Pays(p.getId());
        return pays;
    }
}
