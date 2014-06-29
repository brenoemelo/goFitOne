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
import javax.persistence.Lob;
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
@Table(name = "food")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Food.findAll", query = "SELECT f FROM Food f"),
    @NamedQuery(name = "Food.findByFoodId", query = "SELECT f FROM Food f WHERE f.foodId = :foodId")})
public class Food implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "food_id")
    private Integer foodId;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foodFoodId")
    private Collection<MealItem> mealItemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foodFoodId")
    private Collection<FoodAlias> foodAliasCollection;
    @JoinColumn(name = "food_type_food_type_id", referencedColumnName = "food_type_id")
    @ManyToOne(optional = false)
    private FoodType foodTypeFoodTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "food")
    private Collection<FoodNutrient> foodNutrientCollection;

    public Food() {
    }

    public Food(Integer foodId) {
        this.foodId = foodId;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<MealItem> getMealItemCollection() {
        return mealItemCollection;
    }

    public void setMealItemCollection(Collection<MealItem> mealItemCollection) {
        this.mealItemCollection = mealItemCollection;
    }

    @XmlTransient
    public Collection<FoodAlias> getFoodAliasCollection() {
        return foodAliasCollection;
    }

    public void setFoodAliasCollection(Collection<FoodAlias> foodAliasCollection) {
        this.foodAliasCollection = foodAliasCollection;
    }

    public FoodType getFoodTypeFoodTypeId() {
        return foodTypeFoodTypeId;
    }

    public void setFoodTypeFoodTypeId(FoodType foodTypeFoodTypeId) {
        this.foodTypeFoodTypeId = foodTypeFoodTypeId;
    }

    @XmlTransient
    public Collection<FoodNutrient> getFoodNutrientCollection() {
        return foodNutrientCollection;
    }

    public void setFoodNutrientCollection(Collection<FoodNutrient> foodNutrientCollection) {
        this.foodNutrientCollection = foodNutrientCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (foodId != null ? foodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Food)) {
            return false;
        }
        Food other = (Food) object;
        if ((this.foodId == null && other.foodId != null) || (this.foodId != null && !this.foodId.equals(other.foodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.brenoemelo.model.Food[ foodId=" + foodId + " ]";
    }
    
}
