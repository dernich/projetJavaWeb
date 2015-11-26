package entityPackage;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "ARTICLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Article.findAll", query = "SELECT a FROM Article a"),
    @NamedQuery(name = "Article.findById", query = "SELECT a FROM Article a WHERE a.id = :id"),
    @NamedQuery(name = "Article.findByPrixactuel", query = "SELECT a FROM Article a WHERE a.prixactuel = :prixactuel"),
    @NamedQuery(name = "Article.findByQuantitestock", query = "SELECT a FROM Article a WHERE a.quantitestock = :quantitestock"),
    @NamedQuery(name = "Article.findByUrlimage", query = "SELECT a FROM Article a WHERE a.urlimage = :urlimage")})
public class Article implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRIXACTUEL")
    private BigDecimal prixactuel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITESTOCK")
    private short quantitestock;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "URLIMAGE")
    private String urlimage;
    @JoinColumn(name = "ID_CATEGORIE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Categorie idCategorie;

    public Article() {
    }

    public Article(Integer id) {
        this.id = id;
    }

    public Article(Integer id, BigDecimal prixactuel, short quantitestock, String urlimage) {
        this.id = id;
        this.prixactuel = prixactuel;
        this.quantitestock = quantitestock;
        this.urlimage = urlimage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPrixactuel() {
        return prixactuel;
    }

    public void setPrixactuel(BigDecimal prixactuel) {
        this.prixactuel = prixactuel;
    }

    public short getQuantitestock() {
        return quantitestock;
    }

    public void setQuantitestock(short quantitestock) {
        this.quantitestock = quantitestock;
    }

    public String getUrlimage() {
        return urlimage;
    }

    public void setUrlimage(String urlimage) {
        this.urlimage = urlimage;
    }

    public Categorie getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Categorie idCategorie) {
        this.idCategorie = idCategorie;
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
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityPackage.Article[ id=" + id + " ]";
    }
    
}
