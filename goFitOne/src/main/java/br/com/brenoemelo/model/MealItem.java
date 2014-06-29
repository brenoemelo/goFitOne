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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "meal_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MealItem.findAll", query = "SELECT m FROM MealItem m"),
    @NamedQuery(name = "MealItem.findByIdmealItem", query = "SELECT m FROM MealItem m WHERE m.idmealItem = :idmealItem"),
    @NamedQuery(name = "MealItem.findByQuantity", query = "SELECT m FROM MealItem m WHERE m.quantity = :quantity")})
public class MealItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmeal_item")
    private Integer idmealItem;
    @Size(max = 45)
    @Column(name = "quantity")
    private String quantity;
    @JoinColumn(name = "food_food_id", referencedColumnName = "food_id")
    @ManyToOne(optional = false)
    private Food foodFoodId;
    @JoinColumn(name = "meal_idmeal", referencedColumnName = "idmeal")
    @ManyToOne
    private Meal mealIdmeal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mealItemIdmealItem")
    private Collection<MealItemHist> mealItemHistCollection;

    public MealItem() {
    }

    public MealItem(Integer idmealItem) {
        this.idmealItem = idmealItem;
    }

    public Integer getIdmealItem() {
        return idmealItem;
    }

    public void setIdmealItem(Integer idmealItem) {
        this.idmealItem = idmealItem;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Food getFoodFoodId() {
        return foodFoodId;
    }

    public void setFoodFoodId(Food foodFoodId) {
        this.foodFoodId = foodFoodId;
    }

    public Meal getMealIdmeal() {
        return mealIdmeal;
    }

    public void setMealIdmeal(Meal mealIdmeal) {
        this.mealIdmeal = mealIdmeal;
    }

    @XmlTransient
    public Collection<MealItemHist> getMealItemHistCollection() {
        return mealItemHistCollection;
    }

    public void setMealItemHistCollection(Collection<MealItemHist> mealItemHistCollection) {
        this.mealItemHistCollection = mealItemHistCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmealItem != null ? idmealItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MealItem)) {
            return false;
        }
        MealItem other = (MealItem) object;
        if ((this.idmealItem == null && other.idmealItem != null) || (this.idmealItem != null && !this.idmealItem.equals(other.idmealItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.brenoemelo.model.MealItem[ idmealItem=" + idmealItem + " ]";
    }
    
}
