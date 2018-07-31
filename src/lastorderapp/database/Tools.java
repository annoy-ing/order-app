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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author doomsayer
 */
@Entity
@Table(name = "TOOLS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tools.findAll", query = "SELECT t FROM Tools t")
    , @NamedQuery(name = "Tools.findByToolId", query = "SELECT t FROM Tools t WHERE t.toolId = :toolId")
    , @NamedQuery(name = "Tools.findByToolName", query = "SELECT t FROM Tools t WHERE t.toolName = :toolName")})
public class Tools implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "TOOL_ID")
    private BigDecimal toolId;
    @Column(name = "TOOL_NAME")
    private String toolName;
    @ManyToMany(mappedBy = "toolsCollection")
    private Collection<Orders> ordersCollection;

    public Tools() {
    }

    public Tools(BigDecimal toolId) {
        this.toolId = toolId;
    }

    public BigDecimal getToolId() {
        return toolId;
    }

    public void setToolId(BigDecimal toolId) {
        BigDecimal oldToolId = this.toolId;
        this.toolId = toolId;
        changeSupport.firePropertyChange("toolId", oldToolId, toolId);
    }

    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        String oldToolName = this.toolName;
        this.toolName = toolName;
        changeSupport.firePropertyChange("toolName", oldToolName, toolName);
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
        hash += (toolId != null ? toolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tools)) {
            return false;
        }
        Tools other = (Tools) object;
        if ((this.toolId == null && other.toolId != null) || (this.toolId != null && !this.toolId.equals(other.toolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  toolId + ": " + toolName;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
