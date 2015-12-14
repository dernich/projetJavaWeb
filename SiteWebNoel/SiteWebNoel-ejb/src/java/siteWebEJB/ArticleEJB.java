package siteWebEJB;

import facadePackage.TraductionarticleFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ArticleEJB implements ArticleEJBLocal {
    
    @EJB
    private TraductionarticleFacadeLocal traductionarticleFacade;
    
    public ArrayList<model.Article> getArticleFromCategorie(int langue, int idCategorie){
        
        List<entityPackage.Traductionarticle> listTraduction = traductionarticleFacade.getArticleFromCategorie(langue, idCategorie);
        ArrayList<model.Article> listArticle = new ArrayList<model.Article>();
        for(int i = 0; i < listTraduction.size(); i++){
            
            listArticle.add(new model.Article(
                    listTraduction.get(i).getIdArticle().getId(),
                listTraduction.get(i).getTradlibellearticle(),
                listTraduction.get(i).getTraddescriptionarticle(),
                listTraduction.get(i).getIdArticle().getUrlimage(),
                listTraduction.get(i).getIdArticle().getPrixactuel().doubleValue(),
                (int)listTraduction.get(i).getIdArticle().getQuantitestock()));
        }
        
        return listArticle;
    }
}
