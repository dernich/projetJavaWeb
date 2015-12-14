package model;

public class LigneCommande {
    
    private Article article;
    private int quantiteCommande;
    private double totalArticle;

    public LigneCommande(Article article, int quantiteCommande) {
        this.article = article;
        this.quantiteCommande = quantiteCommande;
        setTotalArticle();
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

    public void setTotalArticle() {
        this.totalArticle = this.quantiteCommande * this.article.getPrix();
    }
}
