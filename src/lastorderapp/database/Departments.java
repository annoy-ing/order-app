/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lastorderapp.database;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author doomsayer
 */
@Entity
@Table(name = "DEPARTMENTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departments.findAll", query = "SELECT d FROM Departments d")
    , @NamedQuery(name = "Departments.findByDepartmentId", query = "SELECT d FROM Departments d WHERE d.departmentId = :departmentId")
    , @NamedQuery(name = "Departments.findByDepartmentName", query = "SELECT d FROM Departments d WHERE d.departmentName = :departmentName")})
public class Departments implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "DEPARTMENT_ID")
    private BigDecimal departmentId;
    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;
    @OneToMany(mappedBy = "workerDepartment")
    private Collection<Workers> workersCollection;
    @OneToMany(mappedBy = "departmentId")
    private Collection<Orders> ordersCollection;

    public Departments() {
    }

    public Departments(BigDecimal departmentId) {
        this.departmentId = departmentId;
    }

    public BigDecimal getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(BigDecimal departmentId) {
        BigDecimal oldDepartmentId = this.departmentId;
        this.departmentId = departmentId;
        changeSupport.firePropertyChange("departmentId", oldDepartmentId, departmentId);
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        String oldDepartmentName = this.departmentName;
        this.departmentName = departmentName;
        changeSupport.firePropertyChange("departmentName", oldDepartmentName, departmentName);
    }

    @XmlTransient
    public Collection<Workers> getWorkersCollection() {
        return workersCollection;
    }

    public void setWorkersCollection(Collection<Workers> workersCollection) {
        this.workersCollection = workersCollection;
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (departmentId != null ? departmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departments)) {
            return false;
        }
        Departments other = (Departments) object;
        if ((this.departmentId == null && other.departmentId != null) || (this.departmentId != null && !this.departmentId.equals(other.departmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return departmentId + ": " +departmentName;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
