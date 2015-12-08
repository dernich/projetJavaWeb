package model;

public class Pays {
    
    private Integer id;
    private String libelle;

    public Pays(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public Pays() {
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
