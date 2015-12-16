package entityPackage;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "TRADUCTIONARTICLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Traductionarticle.findAll", query = "SELECT t FROM Traductionarticle t"),
    @NamedQuery(name = "Traductionarticle.findById", query = "SELECT t FROM Traductionarticle t WHERE t.id = :id"),
    @NamedQuery(name = "Traductionarticle.findByTradlibellearticle", query = "SELECT t FROM Traductionarticle t WHERE t.tradlibellearticle = :tradlibellearticle"),
    @NamedQuery(name = "Traductionarticle.findByTraddescriptionarticle", query = "SELECT t FROM Traductionarticle t WHERE t.traddescriptionarticle = :traddescriptionarticle"),
    @NamedQuery(name = "Traductionarticle.findByCategorie", query = "SELECT t FROM Traductionarticle t inner join t.idArticle a inner join t.idLangue l inner join a.idCategorie c WHERE c.id = :idCategorie AND l.id = :idLangue")})
public class Traductionarticle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TRADLIBELLEARTICLE")
    private String tradlibellearticle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "TRADDESCRIPTIONARTICLE")
    private String traddescriptionarticle;
    @JoinColumn(name = "ID_LANGUE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Langue idLangue;
    @JoinColumn(name = "ID_ARTICLE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Article idArticle;

    public Traductionarticle() {
    }

    public Traductionarticle(Integer id) {
        this.id = id;
    }

    public Traductionarticle(Integer id, String tradlibellearticle, String traddescriptionarticle) {
        this.id = id;
        this.tradlibellearticle = tradlibellearticle;
        this.traddescriptionarticle = traddescriptionarticle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTradlibellearticle() {
        return tradlibellearticle;
    }

    public void setTradlibellearticle(String tradlibellearticle) {
        this.tradlibellearticle = tradlibellearticle;
    }

    public String getTraddescriptionarticle() {
        return traddescriptionarticle;
    }

    public void setTraddescriptionarticle(String traddescriptionarticle) {
        this.traddescriptionarticle = traddescriptionarticle;
    }

    public Langue getIdLangue() {
        return idLangue;
    }

    public void setIdLangue(Langue idLangue) {
        this.idLangue = idLangue;
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
        if (!(object instanceof Traductionarticle)) {
            return false;
        }
        Traductionarticle other = (Traductionarticle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityPackage.Traductionarticle[ id=" + id + " ]";
    }
    
}
