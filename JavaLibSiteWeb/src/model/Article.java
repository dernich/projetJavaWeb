package model;

import java.text.DecimalFormat;

public class Article {
    
    private String nom;
    private String description;
    private String urlImage;
    private Double prix;
    private Integer quantiteStock;
    private int quantiteCommand = 0;

    public Article(String nom, String description, String urlImage, Double prix, Integer quantiteStock) {
        this.nom = nom;
        this.description = description;
        this.urlImage = urlImage;
        this.prix = prix;
        this.quantiteStock = quantiteStock;
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

    public Integer getQuantiteStock() {
        return quantiteStock;
    }

    public void setQuantiteStock(Integer quantiteStock) {
        this.quantiteStock = quantiteStock;
    }

    public int getQuantiteCommand() {
        return quantiteCommand;
    }

    public void setQuantiteCommand(int quantiteCommand) {
        this.quantiteCommand = quantiteCommand;
    }
    
}