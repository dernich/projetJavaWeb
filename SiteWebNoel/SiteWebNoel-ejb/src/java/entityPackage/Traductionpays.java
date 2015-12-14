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
@Table(name = "TRADUCTIONPAYS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Traductionpays.findAll", query = "SELECT t FROM Traductionpays t"),
    @NamedQuery(name = "Traductionpays.findById", query = "SELECT t FROM Traductionpays t WHERE t.id = :id"),
    @NamedQuery(name = "Traductionpays.findByTradlibellepays", query = "SELECT t FROM Traductionpays t WHERE t.tradlibellepays = :tradlibellepays"),
    @NamedQuery(name = "Traductionpays.findByLanguage", query = "SELECT t FROM Traductionpays t inner join t.idLangue l WHERE l.id = :idLangue"),
    @NamedQuery(name = "Traductionpays.findByIdByLanguage", query = "SELECT t.tradlibellepays FROM Traductionpays t inner join t.idLangue l WHERE t.id = :idPays and l.id = :idLangue")})
public class Traductionpays implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TRADLIBELLEPAYS")
    private String tradlibellepays;
    @JoinColumn(name = "ID_PAYS", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Pays idPays;
    @JoinColumn(name = "ID_LANGUE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Langue idLangue;

    public Traductionpays() {
    }

    public Traductionpays(Integer id) {
        this.id = id;
    }

    public Traductionpays(Integer id, String tradlibellepays) {
        this.id = id;
        this.tradlibellepays = tradlibellepays;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTradlibellepays() {
        return tradlibellepays;
    }

    public void setTradlibellepays(String tradlibellepays) {
        this.tradlibellepays = tradlibellepays;
    }

    public Pays getIdPays() {
        return idPays;
    }

    public void setIdPays(Pays idPays) {
        this.idPays = idPays;
    }

    public Langue getIdLangue() {
        return idLangue;
    }

    public void setIdLangue(Langue idLangue) {
        this.idLangue = idLangue;
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
        if (!(object instanceof Traductionpays)) {
            return false;
        }
        Traductionpays other = (Traductionpays) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityPackage.Traductionpays[ id=" + id + " ]";
    }
    
}
