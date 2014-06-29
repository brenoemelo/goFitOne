/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.brenoemelo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Breno
 */
@Entity
@Table(name = "food_nutrient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FoodNutrient.findAll", query = "SELECT f FROM FoodNutrient f"),
    @NamedQuery(name = "FoodNutrient.findByFoodFoodId", query = "SELECT f FROM FoodNutrient f WHERE f.foodNutrientPK.foodFoodId = :foodFoodId"),
    @NamedQuery(name = "FoodNutrient.findByNutrientNutrientId", query = "SELECT f FROM FoodNutrient f WHERE f.foodNutrientPK.nutrientNutrientId = :nutrientNutrientId"),
    @NamedQuery(name = "FoodNutrient.findByQuantity", query = "SELECT f FROM FoodNutrient f WHERE f.quantity = :quantity")})
public class FoodNutrient implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FoodNutrientPK foodNutrientPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantity")
    private BigDecimal quantity;
    @JoinColumn(name = "food_food_id", referencedColumnName = "food_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Food food;
    @JoinColumn(name = "nutrient_nutrient_id", referencedColumnName = "nutrient_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Nutrient nutrient;

    public FoodNutrient() {
    }

    public FoodNutrient(FoodNutrientPK foodNutrientPK) {
        this.foodNutrientPK = foodNutrientPK;
    }

    public FoodNutrient(int foodFoodId, int nutrientNutrientId) {
        this.foodNutrientPK = new FoodNutrientPK(foodFoodId, nutrientNutrientId);
    }

    public FoodNutrientPK getFoodNutrientPK() {
        return foodNutrientPK;
    }

    public void setFoodNutrientPK(FoodNutrientPK foodNutrientPK) {
        this.foodNutrientPK = foodNutrientPK;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Nutrient getNutrient() {
        return nutrient;
    }

    public void setNutrient(Nutrient nutrient) {
        this.nutrient = nutrient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (foodNutrientPK != null ? foodNutrientPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FoodNutrient)) {
            return false;
        }
        FoodNutrient other = (FoodNutrient) object;
        if ((this.foodNutrientPK == null && other.foodNutrientPK != null) || (this.foodNutrientPK != null && !this.foodNutrientPK.equals(other.foodNutrientPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.brenoemelo.model.FoodNutrient[ foodNutrientPK=" + foodNutrientPK + " ]";
    }
    
}
