/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgnew;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Kush
 */
@Entity
@Table(name = "users", catalog = "company", schema = "")
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findByName", query = "SELECT u FROM Users u WHERE u.name = :name")
    , @NamedQuery(name = "Users.findByUserId", query = "SELECT u FROM Users u WHERE u.userId = :userId")
    , @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password")
    , @NamedQuery(name = "Users.findByManagerId", query = "SELECT u FROM Users u WHERE u.managerId = :managerId")
    , @NamedQuery(name = "Users.findByDateofJoining", query = "SELECT u FROM Users u WHERE u.dateofJoining = :dateofJoining")})
public class Users implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "password")
    private String password;
    @Column(name = "manager_id")
    private String managerId;
    @Column(name = "Date_of_Joining")
    @Temporal(TemporalType.DATE)
    private Date dateofJoining;

    public Users() {
    }

    public Users(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        String oldUserId = this.userId;
        this.userId = userId;
        changeSupport.firePropertyChange("userId", oldUserId, userId);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        String oldPassword = this.password;
        this.password = password;
        changeSupport.firePropertyChange("password", oldPassword, password);
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        String oldManagerId = this.managerId;
        this.managerId = managerId;
        changeSupport.firePropertyChange("managerId", oldManagerId, managerId);
    }

    public Date getDateofJoining() {
        return dateofJoining;
    }

    public void setDateofJoining(Date dateofJoining) {
        Date oldDateofJoining = this.dateofJoining;
        this.dateofJoining = dateofJoining;
        changeSupport.firePropertyChange("dateofJoining", oldDateofJoining, dateofJoining);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pkgnew.Users[ name=" + name + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
