package model;

public class TraductionPays {
    
    private int id;
    private String libelle;
    private int idLangue;

    public TraductionPays(int id, String libelle, int idLangue) {
        this.id = id;
        this.libelle = libelle;
        this.idLangue = idLangue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getIdLangue() {
        return idLangue;
    }

    public void setIdLangue(int idLangue) {
        this.idLangue = idLangue;
    }
}
