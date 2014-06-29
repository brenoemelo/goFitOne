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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Breno
 */
@Entity
@Table(name = "measure_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MeasureType.findAll", query = "SELECT m FROM MeasureType m"),
    @NamedQuery(name = "MeasureType.findByIdmeasureType", query = "SELECT m FROM MeasureType m WHERE m.idmeasureType = :idmeasureType"),
    @NamedQuery(name = "MeasureType.findByName", query = "SELECT m FROM MeasureType m WHERE m.name = :name")})
public class MeasureType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmeasure_type")
    private Integer idmeasureType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Lob
    @Size(max = 65535)
    @Column(name = "tip")
    private String tip;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "measureTypeIdmeasureType")
    private Collection<MeasureHistoric> measureHistoricCollection;

    public MeasureType() {
    }

    public MeasureType(Integer idmeasureType) {
        this.idmeasureType = idmeasureType;
    }

    public MeasureType(Integer idmeasureType, String name) {
        this.idmeasureType = idmeasureType;
        this.name = name;
    }

    public Integer getIdmeasureType() {
        return idmeasureType;
    }

    public void setIdmeasureType(Integer idmeasureType) {
        this.idmeasureType = idmeasureType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    @XmlTransient
    public Collection<MeasureHistoric> getMeasureHistoricCollection() {
        return measureHistoricCollection;
    }

    public void setMeasureHistoricCollection(Collection<MeasureHistoric> measureHistoricCollection) {
        this.measureHistoricCollection = measureHistoricCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmeasureType != null ? idmeasureType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MeasureType)) {
            return false;
        }
        MeasureType other = (MeasureType) object;
        if ((this.idmeasureType == null && other.idmeasureType != null) || (this.idmeasureType != null && !this.idmeasureType.equals(other.idmeasureType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.brenoemelo.model.MeasureType[ idmeasureType=" + idmeasureType + " ]";
    }
    
}
