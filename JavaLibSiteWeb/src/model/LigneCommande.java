package model;

public class LigneCommande {
    
    private Article article;
    private int quantiteCommande;
    private double totalArticle;

    public LigneCommande(Article article, int quantiteCommande) {
        this.article = article;
        this.quantiteCommande = quantiteCommande;
        this.totalArticle = article.getPrix() * this.quantiteCommande;
    }

    public LigneCommande() {
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public int getQuantiteCommande() {
        return quantiteCommande;
    }

    public void setQuantiteCommande(int quantiteCommande) {
        this.quantiteCommande = quantiteCommande;
    }

    public double getTotalArticle() {
        return totalArticle;
    }

    public void setTotalArticle(Double prix) {
        this.totalArticle += prix;
    }
}