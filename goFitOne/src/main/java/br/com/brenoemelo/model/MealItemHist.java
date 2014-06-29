/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.brenoemelo.model;

import java.io.Serializable;
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
@Table(name = "meal_item_hist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MealItemHist.findAll", query = "SELECT m FROM MealItemHist m"),
    @NamedQuery(name = "MealItemHist.findByIdmealItemHist", query = "SELECT m FROM MealItemHist m WHERE m.idmealItemHist = :idmealItemHist"),
    @NamedQuery(name = "MealItemHist.findByDate", query = "SELECT m FROM MealItemHist m WHERE m.date = :date")})
public class MealItemHist implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmeal_item_hist")
    private Integer idmealItemHist;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @JoinColumn(name = "meal_item_idmeal_item", referencedColumnName = "idmeal_item")
    @ManyToOne(optional = false)
    private MealItem mealItemIdmealItem;

    public MealItemHist() {
    }

    public MealItemHist(Integer idmealItemHist) {
        this.idmealItemHist = idmealItemHist;
    }

    public MealItemHist(Integer idmealItemHist, Date date) {
        this.idmealItemHist = idmealItemHist;
        this.date = date;
    }

    public Integer getIdmealItemHist() {
        return idmealItemHist;
    }

    public void setIdmealItemHist(Integer idmealItemHist) {
        this.idmealItemHist = idmealItemHist;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public MealItem getMealItemIdmealItem() {
        return mealItemIdmealItem;
    }

    public void setMealItemIdmealItem(MealItem mealItemIdmealItem) {
        this.mealItemIdmealItem = mealItemIdmealItem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmealItemHist != null ? idmealItemHist.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MealItemHist)) {
            return false;
        }
        MealItemHist other = (MealItemHist) object;
        if ((this.idmealItemHist == null && other.idmealItemHist != null) || (this.idmealItemHist != null && !this.idmealItemHist.equals(other.idmealItemHist))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.brenoemelo.model.MealItemHist[ idmealItemHist=" + idmealItemHist + " ]";
    }
    
}
