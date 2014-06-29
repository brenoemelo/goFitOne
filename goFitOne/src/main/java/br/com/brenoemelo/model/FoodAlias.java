/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.brenoemelo.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Breno
 */
@Entity
@Table(name = "food_alias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FoodAlias.findAll", query = "SELECT f FROM FoodAlias f"),
    @NamedQuery(name = "FoodAlias.findByFoodAliasId", query = "SELECT f FROM FoodAlias f WHERE f.foodAliasId = :foodAliasId"),
    @NamedQuery(name = "FoodAlias.findByAlias", query = "SELECT f FROM FoodAlias f WHERE f.alias = :alias")})
public class FoodAlias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "food_alias_id")
    private Integer foodAliasId;
    @Size(max = 45)
    @Column(name = "alias")
    private String alias;
    @JoinColumn(name = "food_food_id", referencedColumnName = "food_id")
    @ManyToOne(optional = false)
    private Food foodFoodId;

    public FoodAlias() {
    }

    public FoodAlias(Integer foodAliasId) {
        this.foodAliasId = foodAliasId;
    }

    public Integer getFoodAliasId() {
        return foodAliasId;
    }

    public void setFoodAliasId(Integer foodAliasId) {
        this.foodAliasId = foodAliasId;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Food getFoodFoodId() {
        return foodFoodId;
    }

    public void setFoodFoodId(Food foodFoodId) {
        this.foodFoodId = foodFoodId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (foodAliasId != null ? foodAliasId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FoodAlias)) {
            return false;
        }
        FoodAlias other = (FoodAlias) object;
        if ((this.foodAliasId == null && other.foodAliasId != null) || (this.foodAliasId != null && !this.foodAliasId.equals(other.foodAliasId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.brenoemelo.model.FoodAlias[ foodAliasId=" + foodAliasId + " ]";
    }
    
}
