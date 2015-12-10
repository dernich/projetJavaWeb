/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityPackage;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Antoine
 */
@Entity
@Table(name = "LANGUE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Langue.findAll", query = "SELECT l FROM Langue l"),
    @NamedQuery(name = "Langue.findById", query = "SELECT l FROM Langue l WHERE l.id = :id")})
public class Langue implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLangue")
    private Collection<Traductioncategorie> traductioncategorieCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLangue")
    private Collection<Traductionpays> traductionpaysCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLangue")
    private Collection<Traductionarticle> traductionarticleCollection;

    public Langue() {
    }

    public Langue(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public Collection<Traductioncategorie> getTraductioncategorieCollection() {
        return traductioncategorieCollection;
    }

    public void setTraductioncategorieCollection(Collection<Traductioncategorie> traductioncategorieCollection) {
        this.traductioncategorieCollection = traductioncategorieCollection;
    }

    @XmlTransient
    public Collection<Traductionpays> getTraductionpaysCollection() {
        return traductionpaysCollection;
    }

    public void setTraductionpaysCollection(Collection<Traductionpays> traductionpaysCollection) {
        this.traductionpaysCollection = traductionpaysCollection;
    }

    @XmlTransient
    public Collection<Traductionarticle> getTraductionarticleCollection() {
        return traductionarticleCollection;
    }

    public void setTraductionarticleCollection(Collection<Traductionarticle> traductionarticleCollection) {
        this.traductionarticleCollection = traductionarticleCollection;
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
        if (!(object instanceof Langue)) {
            return false;
        }
        Langue other = (Langue) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityPackage.Langue[ id=" + id + " ]";
    }
    
}
