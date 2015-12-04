package managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.Article;

@ManagedBean
@RequestScoped
public class articleManager {
    
    private Article articleToManage;
    
    public String outcome(){
        return "details";
    }
    
    public Article getArticleToManage(){
        return articleToManage;
    }
    
    public void setArticleToManage(Article article){
        articleToManage = article;
    }
    
}
