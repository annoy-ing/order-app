/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lastorderapp.database;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author doomsayer
 */
@Entity
@Table(name = "ORDERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o")
    , @NamedQuery(name = "Orders.findById", query = "SELECT o FROM Orders o WHERE o.id = :id")
    , @NamedQuery(name = "Orders.findByWorkType", query = "SELECT o FROM Orders o WHERE o.workType = :workType")
    , @NamedQuery(name = "Orders.findByStartDate", query = "SELECT o FROM Orders o WHERE o.startDate = :startDate")
    , @NamedQuery(name = "Orders.findByEndDate", query = "SELECT o FROM Orders o WHERE o.endDate = :endDate")})
public class Orders implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "WORK_TYPE")
    private String workType;
    @Column(name = "START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @JoinTable(name = "TOOLS_ORDER", joinColumns = {
        @JoinColumn(name = "ORDER_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "TOOL_ID", referencedColumnName = "TOOL_ID")})
    @ManyToMany
    private Collection<Tools> toolsCollection;
    @JoinTable(name = "ORDER_WORKERS", joinColumns = {
        @JoinColumn(name = "ORDER_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "WORKER_ID", referencedColumnName = "WORKER_ID")})
    @ManyToMany
    private Collection<Workers> workersCollection;
    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID")
    @ManyToOne
    private Departments departmentId;
    @JoinColumn(name = "ROOM_ID", referencedColumnName = "ROOM_ID")
    @ManyToOne
    private Rooms roomId;
    @JoinColumn(name = "ACCEPTED_JOB_ID", referencedColumnName = "WORKER_ID")
    @ManyToOne
    private Workers acceptedJobId;
    @JoinColumn(name = "ISSUED_JOB_ID", referencedColumnName = "WORKER_ID")
    @ManyToOne
    private Workers issuedJobId;

    public Orders() {
    }

    public Orders(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        Long oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        String oldWorkType = this.workType;
        this.workType = workType;
        changeSupport.firePropertyChange("workType", oldWorkType, workType);
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        Date oldStartDate = this.startDate;
        this.startDate = startDate;
        changeSupport.firePropertyChange("startDate", oldStartDate, startDate);
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        Date oldEndDate = this.endDate;
        this.endDate = endDate;
        changeSupport.firePropertyChange("endDate", oldEndDate, endDate);
    }

    @XmlTransient
    public Collection<Tools> getToolsCollection() {
        return toolsCollection;
    }

    public void setToolsCollection(Collection<Tools> toolsCollection) {
        this.toolsCollection = toolsCollection;
    }

    @XmlTransient
    public Collection<Workers> getWorkersCollection() {
        return workersCollection;
    }

    public void setWorkersCollection(Collection<Workers> workersCollection) {
        this.workersCollection = workersCollection;
    }

    public Departments getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Departments departmentId) {
        Departments oldDepartmentId = this.departmentId;
        this.departmentId = departmentId;
        changeSupport.firePropertyChange("departmentId", oldDepartmentId, departmentId);
    }

    public Rooms getRoomId() {
        return roomId;
    }

    public void setRoomId(Rooms roomId) {
        Rooms oldRoomId = this.roomId;
        this.roomId = roomId;
        changeSupport.firePropertyChange("roomId", oldRoomId, roomId);
    }

    public Workers getAcceptedJobId() {
        return acceptedJobId;
    }

    public void setAcceptedJobId(Workers acceptedJobId) {
        Workers oldAcceptedJobId = this.acceptedJobId;
        this.acceptedJobId = acceptedJobId;
        changeSupport.firePropertyChange("acceptedJobId", oldAcceptedJobId, acceptedJobId);
    }

    public Workers getIssuedJobId() {
        return issuedJobId;
    }

    public void setIssuedJobId(Workers issuedJobId) {
        Workers oldIssuedJobId = this.issuedJobId;
        this.issuedJobId = issuedJobId;
        changeSupport.firePropertyChange("issuedJobId", oldIssuedJobId, issuedJobId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lastorderapp.database.Orders[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
