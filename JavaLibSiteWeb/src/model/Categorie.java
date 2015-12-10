package model;

import java.util.ArrayList;

public class Categorie {
    
    private String libelle;
    private Integer categorie; //Foreign key vers la categorie

    public Categorie(String libelle, Integer categorie) {
        this.libelle = libelle;
        this.categorie = categorie;
    }

    public String getLibelle() {
        return libelle;
    }
    
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    public Integer getCategorie() {
        return categorie;
    }

    public void setCategorie(Integer categorie) {
        this.categorie = categorie;
    }
}
