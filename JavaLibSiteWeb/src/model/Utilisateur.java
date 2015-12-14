package model;

public class Utilisateur {
    
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String login;
    private String motdepasse;
    private String rue;
    private int numeromaison;
    private int codepostal;
    private String localite;
    private Pays idPays;

    public Utilisateur() {
    }

    public Utilisateur(int id, String nom, String prenom, String email, String login, String motdepasse, String rue, int numeromaison, int codepostal, String localite, Pays idPays) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.login = login;
        this.motdepasse = motdepasse;
        this.rue = rue;
        this.numeromaison = numeromaison;
        this.codepostal = codepostal;
        this.localite = localite;
        this.idPays = idPays;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public int getNumeromaison() {
        return numeromaison;
    }

    public void setNumeromaison(int numeromaison) {
        this.numeromaison = numeromaison;
    }

    public int getCodepostal() {
        return codepostal;
    }

    public void setCodepostal(int codepostal) {
        this.codepostal = codepostal;
    }

    public String getLocalite() {
        return localite;
    }

    public void setLocalite(String localite) {
        this.localite = localite;
    }

    public Pays getIdPays() {
        return idPays;
    }

    public void setIdPays(Pays idPays) {
        this.idPays = idPays;
    }
}
