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
@Table(name = "TRADUCTIONCATEGORIE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Traductioncategorie.findAll", query = "SELECT t FROM Traductioncategorie t"),
    @NamedQuery(name = "Traductioncategorie.findById", query = "SELECT t FROM Traductioncategorie t WHERE t.id = :id"),
    @NamedQuery(name = "Traductioncategorie.findByTradlibellecategorie", query = "SELECT t FROM Traductioncategorie t WHERE t.tradlibellecategorie = :tradlibellecategorie"),
    @NamedQuery(name = "Traductioncategorie.findByLanguage", query = "SELECT t FROM Traductioncategorie t inner join t.idLangue l WHERE l.id = :idLangue")})
public class Traductioncategorie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TRADLIBELLECATEGORIE")
    private String tradlibellecategorie;
    @JoinColumn(name = "ID_LANGUE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Langue idLangue;
    @JoinColumn(name = "ID_CATEGORIE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Categorie idCategorie;

    public Traductioncategorie() {
    }

    public Traductioncategorie(Integer id) {
        this.id = id;
    }

    public Traductioncategorie(Integer id, String tradlibellecategorie) {
        this.id = id;
        this.tradlibellecategorie = tradlibellecategorie;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTradlibellecategorie() {
        return tradlibellecategorie;
    }

    public void setTradlibellecategorie(String tradlibellecategorie) {
        this.tradlibellecategorie = tradlibellecategorie;
    }

    public Langue getIdLangue() {
        return idLangue;
    }

    public void setIdLangue(Langue idLangue) {
        this.idLangue = idLangue;
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
        if (!(object instanceof Traductioncategorie)) {
            return false;
        }
        Traductioncategorie other = (Traductioncategorie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityPackage.Traductioncategorie[ id=" + id + " ]";
    }
    
}
