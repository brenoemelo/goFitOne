/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.brenoemelo.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Breno
 */
@Entity
@Table(name = "meal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Meal.findAll", query = "SELECT m FROM Meal m"),
    @NamedQuery(name = "Meal.findByIdmeal", query = "SELECT m FROM Meal m WHERE m.idmeal = :idmeal"),
    @NamedQuery(name = "Meal.findByName", query = "SELECT m FROM Meal m WHERE m.name = :name"),
    @NamedQuery(name = "Meal.findByHour", query = "SELECT m FROM Meal m WHERE m.hour = :hour")})
public class Meal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmeal")
    private Integer idmeal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Column(name = "hour")
    @Temporal(TemporalType.TIME)
    private Date hour;
    @Lob
    @Size(max = 65535)
    @Column(name = "observation")
    private String observation;
    @JoinTable(name = "user_diet_has_meal", joinColumns = {
        @JoinColumn(name = "meal_idmeal", referencedColumnName = "idmeal")}, inverseJoinColumns = {
        @JoinColumn(name = "user_diet_user_diet_id", referencedColumnName = "user_diet_id")})
    @ManyToMany
    private Collection<UserDiet> userDietCollection;
    @OneToMany(mappedBy = "mealIdmeal")
    private Collection<MealItem> mealItemCollection;
    @JoinColumn(name = "user_diet_user_diet_id", referencedColumnName = "user_diet_id")
    @ManyToOne(optional = false)
    private UserDiet userDietUserDietId;

    public Meal() {
    }

    public Meal(Integer idmeal) {
        this.idmeal = idmeal;
    }

    public Meal(Integer idmeal, String name) {
        this.idmeal = idmeal;
        this.name = name;
    }

    public Integer getIdmeal() {
        return idmeal;
    }

    public void setIdmeal(Integer idmeal) {
        this.idmeal = idmeal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getHour() {
        return hour;
    }

    public void setHour(Date hour) {
        this.hour = hour;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    @XmlTransient
    public Collection<UserDiet> getUserDietCollection() {
        return userDietCollection;
    }

    public void setUserDietCollection(Collection<UserDiet> userDietCollection) {
        this.userDietCollection = userDietCollection;
    }

    @XmlTransient
    public Collection<MealItem> getMealItemCollection() {
        return mealItemCollection;
    }

    public void setMealItemCollection(Collection<MealItem> mealItemCollection) {
        this.mealItemCollection = mealItemCollection;
    }

    public UserDiet getUserDietUserDietId() {
        return userDietUserDietId;
    }

    public void setUserDietUserDietId(UserDiet userDietUserDietId) {
        this.userDietUserDietId = userDietUserDietId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmeal != null ? idmeal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Meal)) {
            return false;
        }
        Meal other = (Meal) object;
        if ((this.idmeal == null && other.idmeal != null) || (this.idmeal != null && !this.idmeal.equals(other.idmeal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.brenoemelo.model.Meal[ idmeal=" + idmeal + " ]";
    }
    
}
