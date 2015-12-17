package facadePackage;

import entityPackage.Article;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ArticleFacade extends AbstractFacade<Article> implements ArticleFacadeLocal {
    @PersistenceContext(unitName = "SiteWebNoel-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArticleFacade() {
        super(Article.class);
    }
    
    public void edit(Article article) {
        em.merge(article);
    }
    
    public Article findById(int id) {
        Query query;
        query = em.createNamedQuery("Article.findById");
        query.setParameter("id", id);
        Article u = (Article)query.getSingleResult();
        return u;
    }
}
