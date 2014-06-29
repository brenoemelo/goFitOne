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
import javax.persistence.ManyToMany;
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
@Table(name = "user_diet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserDiet.findAll", query = "SELECT u FROM UserDiet u"),
    @NamedQuery(name = "UserDiet.findByUserDietId", query = "SELECT u FROM UserDiet u WHERE u.userDietId = :userDietId"),
    @NamedQuery(name = "UserDiet.findByName", query = "SELECT u FROM UserDiet u WHERE u.name = :name")})
public class UserDiet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_diet_id")
    private Integer userDietId;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Lob
    @Size(max = 65535)
    @Column(name = "observation")
    private String observation;
    @ManyToMany(mappedBy = "userDietCollection")
    private Collection<Meal> mealCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userDietUserDietId")
    private Collection<Meal> mealCollection1;
    @JoinColumn(name = "user_user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userUserId;

    public UserDiet() {
    }

    public UserDiet(Integer userDietId) {
        this.userDietId = userDietId;
    }

    public Integer getUserDietId() {
        return userDietId;
    }

    public void setUserDietId(Integer userDietId) {
        this.userDietId = userDietId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    @XmlTransient
    public Collection<Meal> getMealCollection() {
        return mealCollection;
    }

    public void setMealCollection(Collection<Meal> mealCollection) {
        this.mealCollection = mealCollection;
    }

    @XmlTransient
    public Collection<Meal> getMealCollection1() {
        return mealCollection1;
    }

    public void setMealCollection1(Collection<Meal> mealCollection1) {
        this.mealCollection1 = mealCollection1;
    }

    public User getUserUserId() {
        return userUserId;
    }

    public void setUserUserId(User userUserId) {
        this.userUserId = userUserId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userDietId != null ? userDietId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserDiet)) {
            return false;
        }
        UserDiet other = (UserDiet) object;
        if ((this.userDietId == null && other.userDietId != null) || (this.userDietId != null && !this.userDietId.equals(other.userDietId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.brenoemelo.model.UserDiet[ userDietId=" + userDietId + " ]";
    }
    
}
