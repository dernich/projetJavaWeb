package managedBean;

public class testArticle {
    
    private String nom;
    private String description;
    private String urlImage;
    private Double prix;

    public testArticle(String nom, String description, String urlImage, Double prix) {
        this.nom = nom;
        this.description = description;
        this.urlImage = urlImage;
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }
    
    
}
