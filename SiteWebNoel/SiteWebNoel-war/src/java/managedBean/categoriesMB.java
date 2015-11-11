package managedBean;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class categoriesMB 
{    
    ArrayList<testArticle> article;
    
    public categoriesMB() 
    {
        article = new ArrayList<testArticle>();
        article.add(new testArticle("Collier", "Tres beau bijoux", "http://www.i-class.fr/collier/collier-de-perles-en-acier-inoxydable.jpg", 250.20, 21));
        article.add(new testArticle("Papier", "Papier d'une très haute qualitée","https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSxk79KI5b96fJ0bxxg_2LuNT_ROhyfsJ4wjCvASUdFCOcf89THeQ", 0.50,41));
        article.add(new testArticle("Guirlande", "Guirlande vraiment belle, olala", "http://www.jardindeco.com/img/arbre/Guirlande.jpg", 50.60, 5));
        article.add(new testArticle("PereNoel", "Vieu modèle", "http://i2.cdscdn.com/pdt2/3/1/9/1/200x200/mas5060229971319/rw/masque-carton-pere-noel.jpg", 800.20, 12));
        article.add(new testArticle("Boule de noël", "Boule avec coeur", "http://joliscoeurs.j.o.pic.centerblog.net/cfbcd4a5.jpg", 3.20, 15));
        article.add(new testArticle("Boule de noël", "Boule rouge", "http://www.popstickers.fr/5072-home_default/boule-de-noel-rayee-2.jpg", 2.80, 0));
        article.add(new testArticle("Boule de noël", "Boule rose", "https://www.veronneau.com/components/com_mijoshop/opencart/image/cache/catalog/acomba/BOULE-DE-Noel-EN-PLASTIQUE-ROSE-4-XN0156PK.-200x200.jpg", 3.20, 10));
        article.add(new testArticle("Boule de noël original", "Boule pingouin", "http://static.eprofeel.com/salons/c/2/199n/153265_1.jpg", 4.50, 20));
        article.add(new testArticle("Boule de noël lumineuse", "Boule lumineuse", "http://cdn.monechelle.fr/suspension-lumineuse-led-boule-blanc-chaud-T-264871_1.jpg", 3.40, 20));
        article.add(new testArticle("Boule de noël", "Boule verte", "https://www.veronneau.com/components/com_mijoshop/opencart/image/cache/catalog/acomba/BOULE-METALIQUE-INTERIEURE-VERTE-6-MTB8724V-200x200.jpg", 3.20, 2));
    }
    
    public void addArticleList(testArticle a) {
        article.add(a);
    }
    
    public ArrayList<testArticle> getListeArticle()
    {
        return article;
    }
}