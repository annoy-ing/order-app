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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "WORKERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Workers.findAll", query = "SELECT w FROM Workers w")
    , @NamedQuery(name = "Workers.findByWorkerId", query = "SELECT w FROM Workers w WHERE w.workerId = :workerId")
    , @NamedQuery(name = "Workers.findByWorkerName", query = "SELECT w FROM Workers w WHERE w.workerName = :workerName")
    , @NamedQuery(name = "Workers.findByWorkerPosition", query = "SELECT w FROM Workers w WHERE w.workerPosition = :workerPosition")})
public class Workers implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "WORKER_ID")
    private BigDecimal workerId;
    @Column(name = "WORKER_NAME")
    private String workerName;
    @Column(name = "WORKER_POSITION")
    private String workerPosition;
    @ManyToMany(mappedBy = "workersCollection")
    private Collection<Orders> ordersCollection;
    @JoinColumn(name = "WORKER_DEPARTMENT", referencedColumnName = "DEPARTMENT_ID")
    @ManyToOne
    private Departments workerDepartment;
    @OneToMany(mappedBy = "acceptedJobId")
    private Collection<Orders> ordersCollection1;
    @OneToMany(mappedBy = "issuedJobId")
    private Collection<Orders> ordersCollection2;

    public Workers() {
    }

    public Workers(BigDecimal workerId) {
        this.workerId = workerId;
    }

    public BigDecimal getWorkerId() {
        return workerId;
    }

    public void setWorkerId(BigDecimal workerId) {
        BigDecimal oldWorkerId = this.workerId;
        this.workerId = workerId;
        changeSupport.firePropertyChange("workerId", oldWorkerId, workerId);
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        String oldWorkerName = this.workerName;
        this.workerName = workerName;
        changeSupport.firePropertyChange("workerName", oldWorkerName, workerName);
    }

    public String getWorkerPosition() {
        return workerPosition;
    }

    public void setWorkerPosition(String workerPosition) {
        String oldWorkerPosition = this.workerPosition;
        this.workerPosition = workerPosition;
        changeSupport.firePropertyChange("workerPosition", oldWorkerPosition, workerPosition);
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    public Departments getWorkerDepartment() {
        return workerDepartment;
    }

    public void setWorkerDepartment(Departments workerDepartment) {
        Departments oldWorkerDepartment = this.workerDepartment;
        this.workerDepartment = workerDepartment;
        changeSupport.firePropertyChange("workerDepartment", oldWorkerDepartment, workerDepartment);
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection1() {
        return ordersCollection1;
    }

    public void setOrdersCollection1(Collection<Orders> ordersCollection1) {
        this.ordersCollection1 = ordersCollection1;
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection2() {
        return ordersCollection2;
    }

    public void setOrdersCollection2(Collection<Orders> ordersCollection2) {
        this.ordersCollection2 = ordersCollection2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (workerId != null ? workerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Workers)) {
            return false;
        }
        Workers other = (Workers) object;
        if ((this.workerId == null && other.workerId != null) || (this.workerId != null && !this.workerId.equals(other.workerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return workerId.toString() + ": " + workerName;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
