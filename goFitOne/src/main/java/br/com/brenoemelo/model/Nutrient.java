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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Breno
 */
@Entity
@Table(name = "nutrient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nutrient.findAll", query = "SELECT n FROM Nutrient n"),
    @NamedQuery(name = "Nutrient.findByNutrientId", query = "SELECT n FROM Nutrient n WHERE n.nutrientId = :nutrientId"),
    @NamedQuery(name = "Nutrient.findByName", query = "SELECT n FROM Nutrient n WHERE n.name = :name"),
    @NamedQuery(name = "Nutrient.findByDescription", query = "SELECT n FROM Nutrient n WHERE n.description = :description")})
public class Nutrient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nutrient_id")
    private Integer nutrientId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "unity_unity_id", referencedColumnName = "unity_id")
    @ManyToOne(optional = false)
    private Unity unityUnityId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nutrient")
    private Collection<FoodNutrient> foodNutrientCollection;

    public Nutrient() {
    }

    public Nutrient(Integer nutrientId) {
        this.nutrientId = nutrientId;
    }

    public Nutrient(Integer nutrientId, String name) {
        this.nutrientId = nutrientId;
        this.name = name;
    }

    public Integer getNutrientId() {
        return nutrientId;
    }

    public void setNutrientId(Integer nutrientId) {
        this.nutrientId = nutrientId;
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

    public Unity getUnityUnityId() {
        return unityUnityId;
    }

    public void setUnityUnityId(Unity unityUnityId) {
        this.unityUnityId = unityUnityId;
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
        hash += (nutrientId != null ? nutrientId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nutrient)) {
            return false;
        }
        Nutrient other = (Nutrient) object;
        if ((this.nutrientId == null && other.nutrientId != null) || (this.nutrientId != null && !this.nutrientId.equals(other.nutrientId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.brenoemelo.model.Nutrient[ nutrientId=" + nutrientId + " ]";
    }
    
}
