package model;

public class Article {
    
    private int id;
    private String nom;
    private String description;
    private String urlImage;
    private Double prix;
    private int quantiteStock;
    private int quantiteCommand = 0;

    public Article(int id, String nom, String description, String urlImage, Double prix, int quantiteStock) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.urlImage = urlImage;
        this.prix = prix;
        this.quantiteStock = quantiteStock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        prix =(double)((int)(prix*100))/100;
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public int getQuantiteStock() {
        return quantiteStock;
    }

    public void setQuantiteStock(int quantiteStock) {
        this.quantiteStock = quantiteStock;
    }

    public int getQuantiteCommand() {
        return quantiteCommand;
    }

    public void setQuantiteCommand(int quantiteCommand) {
        this.quantiteCommand = quantiteCommand;
    }
    
}