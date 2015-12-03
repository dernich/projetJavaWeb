package sessionBeanPackage;

import entityPackage.Utilisateur;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class UtilisateurFacade extends AbstractFacade<Utilisateur> implements UtilisateurFacadeLocal {
    @PersistenceContext(unitName = "SiteWebNoel-ejbPU")
    private EntityManager em;
    private Utilisateur utilisateur;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UtilisateurFacade() {
        super(Utilisateur.class);
    }
    
    /*@Override
    public Utilisateur UserConnection(String login) {
        Query query;
        query = em.createNamedQuery("Utilisateur.findByLogin");
        query.setParameter("login", login);
        return (Utilisateur)query.getSingleResult();
    }*/

    @Override
    public void CreateUser(model.Utilisateur user) {
        utilisateur = new entityPackage.Utilisateur();
        utilisateur.setNom(user.getNom());
        utilisateur.setPrenom(user.getPrenom());
        utilisateur.setEmail(user.getEmail());
        utilisateur.setRue(user.getRue());
        utilisateur.setNumeromaison((short)user.getNumeromaison());
        utilisateur.setLocalite(user.getLocalite());
        utilisateur.setCodepostal((short)user.getCodepostal());
        utilisateur.setLogin(user.getLogin());
        utilisateur.setMotdepasse(user.getMotdepasse());
        create(utilisateur);
    }
    
}
