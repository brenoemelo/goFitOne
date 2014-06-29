/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.brenoemelo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Breno
 */
@Entity
@Table(name = "measure_historic")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MeasureHistoric.findAll", query = "SELECT m FROM MeasureHistoric m"),
    @NamedQuery(name = "MeasureHistoric.findByMeasureHistoricId", query = "SELECT m FROM MeasureHistoric m WHERE m.measureHistoricId = :measureHistoricId"),
    @NamedQuery(name = "MeasureHistoric.findByDate", query = "SELECT m FROM MeasureHistoric m WHERE m.date = :date"),
    @NamedQuery(name = "MeasureHistoric.findByValue", query = "SELECT m FROM MeasureHistoric m WHERE m.value = :value")})
public class MeasureHistoric implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "measure_historic_id")
    private Integer measureHistoricId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "value")
    private BigDecimal value;
    @JoinColumn(name = "user_user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userUserId;
    @JoinColumn(name = "measure_type_idmeasure_type", referencedColumnName = "idmeasure_type")
    @ManyToOne(optional = false)
    private MeasureType measureTypeIdmeasureType;

    public MeasureHistoric() {
    }

    public MeasureHistoric(Integer measureHistoricId) {
        this.measureHistoricId = measureHistoricId;
    }

    public MeasureHistoric(Integer measureHistoricId, Date date, BigDecimal value) {
        this.measureHistoricId = measureHistoricId;
        this.date = date;
        this.value = value;
    }

    public Integer getMeasureHistoricId() {
        return measureHistoricId;
    }

    public void setMeasureHistoricId(Integer measureHistoricId) {
        this.measureHistoricId = measureHistoricId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public User getUserUserId() {
        return userUserId;
    }

    public void setUserUserId(User userUserId) {
        this.userUserId = userUserId;
    }

    public MeasureType getMeasureTypeIdmeasureType() {
        return measureTypeIdmeasureType;
    }

    public void setMeasureTypeIdmeasureType(MeasureType measureTypeIdmeasureType) {
        this.measureTypeIdmeasureType = measureTypeIdmeasureType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (measureHistoricId != null ? measureHistoricId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MeasureHistoric)) {
            return false;
        }
        MeasureHistoric other = (MeasureHistoric) object;
        if ((this.measureHistoricId == null && other.measureHistoricId != null) || (this.measureHistoricId != null && !this.measureHistoricId.equals(other.measureHistoricId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.brenoemelo.model.MeasureHistoric[ measureHistoricId=" + measureHistoricId + " ]";
    }
    
}
