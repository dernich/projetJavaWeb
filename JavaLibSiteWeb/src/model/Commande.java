package model;

import java.util.Date;

public class Commande {
    
    private Date date;
    private Utilisateur user;

    public Commande() {
    }

    public Commande(Date date, Utilisateur user) {
        this.date = date;
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }
}
