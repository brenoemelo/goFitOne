/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.brenoemelo.model;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Breno
 */
@Entity
@Table(name = "unity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unity.findAll", query = "SELECT u FROM Unity u"),
    @NamedQuery(name = "Unity.findByUnityId", query = "SELECT u FROM Unity u WHERE u.unityId = :unityId"),
    @NamedQuery(name = "Unity.findByName", query = "SELECT u FROM Unity u WHERE u.name = :name")})
public class Unity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "unity_id")
    private Integer unityId;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unityUnityId")
    private Collection<Nutrient> nutrientCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unityOrigin")
    private Collection<ConversionFactor> conversionFactorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unityDestiny")
    private Collection<ConversionFactor> conversionFactorCollection1;

    public Unity() {
    }

    public Unity(Integer unityId) {
        this.unityId = unityId;
    }

    public Integer getUnityId() {
        return unityId;
    }

    public void setUnityId(Integer unityId) {
        this.unityId = unityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Nutrient> getNutrientCollection() {
        return nutrientCollection;
    }

    public void setNutrientCollection(Collection<Nutrient> nutrientCollection) {
        this.nutrientCollection = nutrientCollection;
    }

    @XmlTransient
    public Collection<ConversionFactor> getConversionFactorCollection() {
        return conversionFactorCollection;
    }

    public void setConversionFactorCollection(Collection<ConversionFactor> conversionFactorCollection) {
        this.conversionFactorCollection = conversionFactorCollection;
    }

    @XmlTransient
    public Collection<ConversionFactor> getConversionFactorCollection1() {
        return conversionFactorCollection1;
    }

    public void setConversionFactorCollection1(Collection<ConversionFactor> conversionFactorCollection1) {
        this.conversionFactorCollection1 = conversionFactorCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (unityId != null ? unityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unity)) {
            return false;
        }
        Unity other = (Unity) object;
        if ((this.unityId == null && other.unityId != null) || (this.unityId != null && !this.unityId.equals(other.unityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.brenoemelo.model.Unity[ unityId=" + unityId + " ]";
    }
    
}
