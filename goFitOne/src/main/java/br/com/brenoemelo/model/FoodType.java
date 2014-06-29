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
@Table(name = "food_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FoodType.findAll", query = "SELECT f FROM FoodType f"),
    @NamedQuery(name = "FoodType.findByFoodTypeId", query = "SELECT f FROM FoodType f WHERE f.foodTypeId = :foodTypeId"),
    @NamedQuery(name = "FoodType.findByName", query = "SELECT f FROM FoodType f WHERE f.name = :name")})
public class FoodType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "food_type_id")
    private Integer foodTypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foodTypeFoodTypeId")
    private Collection<Food> foodCollection;

    public FoodType() {
    }

    public FoodType(Integer foodTypeId) {
        this.foodTypeId = foodTypeId;
    }

    public FoodType(Integer foodTypeId, String name) {
        this.foodTypeId = foodTypeId;
        this.name = name;
    }

    public Integer getFoodTypeId() {
        return foodTypeId;
    }

    public void setFoodTypeId(Integer foodTypeId) {
        this.foodTypeId = foodTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Food> getFoodCollection() {
        return foodCollection;
    }

    public void setFoodCollection(Collection<Food> foodCollection) {
        this.foodCollection = foodCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (foodTypeId != null ? foodTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FoodType)) {
            return false;
        }
        FoodType other = (FoodType) object;
        if ((this.foodTypeId == null && other.foodTypeId != null) || (this.foodTypeId != null && !this.foodTypeId.equals(other.foodTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.brenoemelo.model.FoodType[ foodTypeId=" + foodTypeId + " ]";
    }
    
}
