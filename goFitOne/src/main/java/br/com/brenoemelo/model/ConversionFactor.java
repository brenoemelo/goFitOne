/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.brenoemelo.model;

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

/**
 *
 * @author Breno
 */
@Entity
@Table(name = "conversion_factor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConversionFactor.findAll", query = "SELECT c FROM ConversionFactor c"),
    @NamedQuery(name = "ConversionFactor.findByConversionFactorId", query = "SELECT c FROM ConversionFactor c WHERE c.conversionFactorId = :conversionFactorId"),
    @NamedQuery(name = "ConversionFactor.findByFactor", query = "SELECT c FROM ConversionFactor c WHERE c.factor = :factor")})
public class ConversionFactor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "conversion_factor_id")
    private Integer conversionFactorId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "factor")
    private BigDecimal factor;
    @JoinColumn(name = "unity_origin", referencedColumnName = "unity_id")
    @ManyToOne(optional = false)
    private Unity unityOrigin;
    @JoinColumn(name = "unity_destiny", referencedColumnName = "unity_id")
    @ManyToOne(optional = false)
    private Unity unityDestiny;

    public ConversionFactor() {
    }

    public ConversionFactor(Integer conversionFactorId) {
        this.conversionFactorId = conversionFactorId;
    }

    public ConversionFactor(Integer conversionFactorId, BigDecimal factor) {
        this.conversionFactorId = conversionFactorId;
        this.factor = factor;
    }

    public Integer getConversionFactorId() {
        return conversionFactorId;
    }

    public void setConversionFactorId(Integer conversionFactorId) {
        this.conversionFactorId = conversionFactorId;
    }

    public BigDecimal getFactor() {
        return factor;
    }

    public void setFactor(BigDecimal factor) {
        this.factor = factor;
    }

    public Unity getUnityOrigin() {
        return unityOrigin;
    }

    public void setUnityOrigin(Unity unityOrigin) {
        this.unityOrigin = unityOrigin;
    }

    public Unity getUnityDestiny() {
        return unityDestiny;
    }

    public void setUnityDestiny(Unity unityDestiny) {
        this.unityDestiny = unityDestiny;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conversionFactorId != null ? conversionFactorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConversionFactor)) {
            return false;
        }
        ConversionFactor other = (ConversionFactor) object;
        if ((this.conversionFactorId == null && other.conversionFactorId != null) || (this.conversionFactorId != null && !this.conversionFactorId.equals(other.conversionFactorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.brenoemelo.model.ConversionFactor[ conversionFactorId=" + conversionFactorId + " ]";
    }
    
}
