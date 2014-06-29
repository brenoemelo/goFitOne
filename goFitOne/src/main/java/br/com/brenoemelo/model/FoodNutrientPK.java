/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.brenoemelo.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Breno
 */
@Embeddable
public class FoodNutrientPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "food_food_id")
    private int foodFoodId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nutrient_nutrient_id")
    private int nutrientNutrientId;

    public FoodNutrientPK() {
    }

    public FoodNutrientPK(int foodFoodId, int nutrientNutrientId) {
        this.foodFoodId = foodFoodId;
        this.nutrientNutrientId = nutrientNutrientId;
    }

    public int getFoodFoodId() {
        return foodFoodId;
    }

    public void setFoodFoodId(int foodFoodId) {
        this.foodFoodId = foodFoodId;
    }

    public int getNutrientNutrientId() {
        return nutrientNutrientId;
    }

    public void setNutrientNutrientId(int nutrientNutrientId) {
        this.nutrientNutrientId = nutrientNutrientId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) foodFoodId;
        hash += (int) nutrientNutrientId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FoodNutrientPK)) {
            return false;
        }
        FoodNutrientPK other = (FoodNutrientPK) object;
        if (this.foodFoodId != other.foodFoodId) {
            return false;
        }
        if (this.nutrientNutrientId != other.nutrientNutrientId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.brenoemelo.model.FoodNutrientPK[ foodFoodId=" + foodFoodId + ", nutrientNutrientId=" + nutrientNutrientId + " ]";
    }
    
}
