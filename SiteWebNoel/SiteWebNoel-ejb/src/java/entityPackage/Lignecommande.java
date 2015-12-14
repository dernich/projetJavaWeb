package entityPackage;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "LIGNECOMMANDE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lignecommande.findAll", query = "SELECT l FROM Lignecommande l"),
    @NamedQuery(name = "Lignecommande.findById", query = "SELECT l FROM Lignecommande l WHERE l.id = :id"),
    @NamedQuery(name = "Lignecommande.findByQuantitecommande", query = "SELECT l FROM Lignecommande l WHERE l.quantitecommande = :quantitecommande"),
    @NamedQuery(name = "Lignecommande.findByPrixreel", query = "SELECT l FROM Lignecommande l WHERE l.prixreel = :prixreel")})
public class Lignecommande implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITECOMMANDE")
    private int quantitecommande;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRIXREEL")
    private BigDecimal prixreel;
    @JoinColumn(name = "NUMERO_COMMANDE", referencedColumnName = "NUMERO")
    @ManyToOne(optional = false)
    private Commande numeroCommande;
    @JoinColumn(name = "ID_ARTICLE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Article idArticle;

    public Lignecommande() {
    }

    public Lignecommande(Integer id) {
        this.id = id;
    }

    public Lignecommande(Integer id, int quantitecommande, BigDecimal prixreel) {
        this.id = id;
        this.quantitecommande = quantitecommande;
        this.prixreel = prixreel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantitecommande() {
        return quantitecommande;
    }

    public void setQuantitecommande(int quantitecommande) {
        this.quantitecommande = quantitecommande;
    }

    public BigDecimal getPrixreel() {
        return prixreel;
    }

    public void setPrixreel(BigDecimal prixreel) {
        this.prixreel = prixreel;
    }

    public Commande getNumeroCommande() {
        return numeroCommande;
    }

    public void setNumeroCommande(Commande numeroCommande) {
        this.numeroCommande = numeroCommande;
    }

    public Article getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Article idArticle) {
        this.idArticle = idArticle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lignecommande)) {
            return false;
        }
        Lignecommande other = (Lignecommande) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityPackage.Lignecommande[ id=" + id + " ]";
    }
    
}
