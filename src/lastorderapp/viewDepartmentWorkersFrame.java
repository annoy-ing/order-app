/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lastorderapp;

import static lastorderapp.DepartmentPanel.selectedDepartmentRow;
import lastorderapp.database.Departments;

/**
 *
 * @author doomsayer
 */
public class viewDepartmentWorkersFrame extends javax.swing.JFrame {

    /**
     * Creates new form viewDepartmentWorkersFrame
     */
    public viewDepartmentWorkersFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        selectedDepartmentComboBox.setVisible(false);
        selectedDepartmentComboBox.setSelectedIndex(selectedDepartmentRow);
        Departments selectedDepartment = (Departments) selectedDepartmentComboBox.getSelectedItem();
        selectedDepartmentLabel.setText("Department '" + selectedDepartment + "' workers");
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
        departmentsQuery = java.beans.Beans.isDesignTime() ? null : LastOrderAppPUEntityManager.createQuery("SELECT d FROM Departments d");
        departmentsList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : departmentsQuery.getResultList();
        workersQuery = java.beans.Beans.isDesignTime() ? null : LastOrderAppPUEntityManager.createQuery("SELECT d.workersCollection FROM Departments d WHERE d.departmentId = "+ (selectedDepartmentRow + 1));
        workersList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : workersQuery.getResultList();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        closeButton = new javax.swing.JButton();
        selectedDepartmentLabel = new javax.swing.JLabel();
        selectedDepartmentComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWidths = new int[] {0, 10, 0};
        layout.rowHeights = new int[] {0, 10, 0, 10, 0, 10, 0};
        getContentPane().setLayout(layout);

        jScrollPane1.setMinimumSize(new java.awt.Dimension(200, 200));

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, workersList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${workerId}"));
        columnBinding.setColumnName("Worker Id");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${workerName}"));
        columnBinding.setColumnName("Worker Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${workerPosition}"));
        columnBinding.setColumnName("Worker Position");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(jTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 5;
        getContentPane().add(jScrollPane1, gridBagConstraints);

        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_END;
        getContentPane().add(closeButton, gridBagConstraints);

        selectedDepartmentLabel.setText("jLabel1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        getContentPane().add(selectedDepartmentLabel, gridBagConstraints);

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, departmentsList, selectedDepartmentComboBox);
        bindingGroup.addBinding(jComboBoxBinding);

        getContentPane().add(selectedDepartmentComboBox, new java.awt.GridBagConstraints());

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        // TODO add your handling code here:
        
        OrderApplication OrderApplication = new OrderApplication();
        OrderApplication.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_closeButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(viewDepartmentWorkersFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewDepartmentWorkersFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewDepartmentWorkersFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewDepartmentWorkersFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewDepartmentWorkersFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager LastOrderAppPUEntityManager;
    private javax.swing.JButton closeButton;
    private java.util.List<lastorderapp.database.Departments> departmentsList;
    private javax.persistence.Query departmentsQuery;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> selectedDepartmentComboBox;
    private javax.swing.JLabel selectedDepartmentLabel;
    private java.util.List<lastorderapp.database.Workers> workersList;
    private javax.persistence.Query workersQuery;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
