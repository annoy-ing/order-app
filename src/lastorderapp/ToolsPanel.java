/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lastorderapp;

import static lastorderapp.OrderPanel.selectedColumn;

/**
 *
 * @author doomsayer
 */
public class ToolsPanel extends javax.swing.JPanel {

    static int selectedTool = 0;
    
    /**
     * Creates new form ToolsPanel
     */
    public ToolsPanel() {
        initComponents();
        selectedTool = jTable1.getSelectedColumn();
        if (selectedTool == -1){
            viewButton.setEnabled(false);
        } else viewButton.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        LastOrderAppPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("LastOrderAppPU").createEntityManager();
        toolsQuery = java.beans.Beans.isDesignTime() ? null : LastOrderAppPUEntityManager.createQuery("SELECT t FROM Tools t ORDER BY t.toolId");
        toolsList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : toolsQuery.getResultList();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        addNewTool = new javax.swing.JButton();
        viewButton = new javax.swing.JButton();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWidths = new int[] {0, 10, 0};
        layout.rowHeights = new int[] {0, 10, 0, 10, 0};
        setLayout(layout);

        jScrollPane1.setMinimumSize(new java.awt.Dimension(200, 200));

        jTable1.setMinimumSize(new java.awt.Dimension(200, 200));

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, toolsList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${toolId}"));
        columnBinding.setColumnName("Tool Id");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${toolName}"));
        columnBinding.setColumnName("Tool Name");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 5;
        add(jScrollPane1, gridBagConstraints);

        addNewTool.setText("Add new tool");
        addNewTool.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewToolActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        add(addNewTool, gridBagConstraints);

        viewButton.setText("View tool history");
        viewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(viewButton, gridBagConstraints);

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void addNewToolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewToolActionPerformed
        // TODO add your handling code here:
        AddNewToolFrame AddNewToolFrame = new AddNewToolFrame();
        AddNewToolFrame.setVisible(true);
        this.getParent().getParent().getParent().getParent().getParent().setVisible(false);
    }//GEN-LAST:event_addNewToolActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        selectedTool = jTable1.getSelectedRow();
        
        if (selectedTool == -1){
            viewButton.setEnabled(false);
        } else{
            viewButton.setEnabled(true);
        }
        System.out.println(selectedTool);
    }//GEN-LAST:event_jTable1MouseClicked

    private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButtonActionPerformed
        // TODO add your handling code here:
        viewToolFrame viewToolFrame = new viewToolFrame();
        viewToolFrame.setVisible(true);
        this.getParent().getParent().getParent().getParent().getParent().setVisible(false);
    }//GEN-LAST:event_viewButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager LastOrderAppPUEntityManager;
    private javax.swing.JButton addNewTool;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private java.util.List<lastorderapp.database.Tools> toolsList;
    private javax.persistence.Query toolsQuery;
    private javax.swing.JButton viewButton;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
