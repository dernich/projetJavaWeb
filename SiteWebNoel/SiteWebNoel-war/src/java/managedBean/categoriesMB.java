
package managedBean;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class categoriesMB {
    
    ArrayList<testArticle> article = new ArrayList<testArticle>();
    
    public categoriesMB() {
        
    
    testArticle a1 = new testArticle("Collier", "Tres beau bijoux", "http://www.i-class.fr/collier/collier-de-perles-en-acier-inoxydable.jpg", 250.20);
    testArticle a2 = new testArticle("Papier", "Papier d'une très haute qualitée","https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSxk79KI5b96fJ0bxxg_2LuNT_ROhyfsJ4wjCvASUdFCOcf89THeQ", 0.50 );
    testArticle a3 = new testArticle("Guirlande", "Guirlande vraiment belle, olala", "http://www.jardindeco.com/img/arbre/Guirlande.jpg", 50.60);
    testArticle a4 = new testArticle("PereNoel", "Vieu modèle", "http://i2.cdscdn.com/pdt2/3/1/9/1/200x200/mas5060229971319/rw/masque-carton-pere-noel.jpg", 800.20);
    
    article.add(a1);
    article.add(a2);
    article.add(a3);
    article.add(a4);
    
    }
    
    public ArrayList<testArticle> getListeArticle(){
        
        return article;
    }
    
}


