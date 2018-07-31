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
@Table(name = "ROOMS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rooms.findAll", query = "SELECT r FROM Rooms r")
    , @NamedQuery(name = "Rooms.findByRoomId", query = "SELECT r FROM Rooms r WHERE r.roomId = :roomId")
    , @NamedQuery(name = "Rooms.findByRoomName", query = "SELECT r FROM Rooms r WHERE r.roomName = :roomName")
    , @NamedQuery(name = "Rooms.findByRoomAdress", query = "SELECT r FROM Rooms r WHERE r.roomAdress = :roomAdress")})
public class Rooms implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ROOM_ID")
    private BigDecimal roomId;
    @Column(name = "ROOM_NAME")
    private String roomName;
    @Column(name = "ROOM_ADRESS")
    private String roomAdress;
    @OneToMany(mappedBy = "roomId")
    private Collection<Orders> ordersCollection;

    public Rooms() {
    }

    public Rooms(BigDecimal roomId) {
        this.roomId = roomId;
    }

    public BigDecimal getRoomId() {
        return roomId;
    }

    public void setRoomId(BigDecimal roomId) {
        BigDecimal oldRoomId = this.roomId;
        this.roomId = roomId;
        changeSupport.firePropertyChange("roomId", oldRoomId, roomId);
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        String oldRoomName = this.roomName;
        this.roomName = roomName;
        changeSupport.firePropertyChange("roomName", oldRoomName, roomName);
    }

    public String getRoomAdress() {
        return roomAdress;
    }

    public void setRoomAdress(String roomAdress) {
        String oldRoomAdress = this.roomAdress;
        this.roomAdress = roomAdress;
        changeSupport.firePropertyChange("roomAdress", oldRoomAdress, roomAdress);
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
        hash += (roomId != null ? roomId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rooms)) {
            return false;
        }
        Rooms other = (Rooms) object;
        if ((this.roomId == null && other.roomId != null) || (this.roomId != null && !this.roomId.equals(other.roomId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return roomId + ": " + roomName;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
