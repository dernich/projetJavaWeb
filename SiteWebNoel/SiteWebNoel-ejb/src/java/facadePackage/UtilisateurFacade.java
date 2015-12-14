package facadePackage;

import entityPackage.Utilisateur;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class UtilisateurFacade extends AbstractFacade<Utilisateur> implements UtilisateurFacadeLocal {
    @PersistenceContext(unitName = "SiteWebNoel-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UtilisateurFacade() {
        super(Utilisateur.class);
    }
    
    @Override
    public void create(Utilisateur user) {
        em.persist(user);
    }
    
    public Utilisateur findUserByLogin(String login) {
        Query query;
        query = em.createNamedQuery("Utilisateur.findByLogin");
        query.setParameter("login", login);
        Utilisateur u = (Utilisateur)query.getSingleResult();
        return u;
    }
}
