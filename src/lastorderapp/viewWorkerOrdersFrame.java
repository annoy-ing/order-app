/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lastorderapp;

import static lastorderapp.WorkerPanel.selectedWorkerRow;
import lastorderapp.database.Workers;

/**
 *
 * @author doomsayer
 */
public class viewWorkerOrdersFrame extends javax.swing.JFrame {

    /**
     * Creates new form viewWorkerOrdersFrame
     */
    public viewWorkerOrdersFrame() {
        initComponents();
        selectedWorkerComboBox.setVisible(false);
        selectedWorkerComboBox.setSelectedIndex(selectedWorkerRow);
        Workers selectedWorker = (Workers) selectedWorkerComboBox.getSelectedItem();
        selectedWorkerLabel.setText(selectedWorker + " orders");
        this.setLocationRelativeTo(null);
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
        workersQuery = java.beans.Beans.isDesignTime() ? null : LastOrderAppPUEntityManager.createQuery("SELECT w FROM Workers w");
        workersList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : workersQuery.getResultList();
        workersQuery1 = java.beans.Beans.isDesignTime() ? null : LastOrderAppPUEntityManager.createQuery("SELECT w FROM Workers w");
        workersList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : workersQuery1.getResultList();
        ordersQuery = java.beans.Beans.isDesignTime() ? null : LastOrderAppPUEntityManager.createQuery("SELECT w.ordersCollection FROM Workers w WHERE w.workerId = " + (selectedWorkerRow + 1));
        ordersList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : ordersQuery.getResultList();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        selectedWorkerComboBox = new javax.swing.JComboBox<>();
        closeButton = new javax.swing.JButton();
        selectedWorkerLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWidths = new int[] {0, 10, 0, 10, 0, 10, 0};
        layout.rowHeights = new int[] {0, 10, 0, 10, 0, 10, 0};
        getContentPane().setLayout(layout);

        jScrollPane1.setMinimumSize(new java.awt.Dimension(230, 230));

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, ordersList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Long.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${workType}"));
        columnBinding.setColumnName("Work Type");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${startDate}"));
        columnBinding.setColumnName("Start Date");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${endDate}"));
        columnBinding.setColumnName("End Date");
        columnBinding.setColumnClass(java.util.Date.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(jTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 5;
        getContentPane().add(jScrollPane1, gridBagConstraints);

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, workersList, selectedWorkerComboBox);
        bindingGroup.addBinding(jComboBoxBinding);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        getContentPane().add(selectedWorkerComboBox, gridBagConstraints);

        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_END;
        getContentPane().add(closeButton, gridBagConstraints);

        selectedWorkerLabel.setText("jLabel1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        getContentPane().add(selectedWorkerLabel, gridBagConstraints);

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
            java.util.logging.Logger.getLogger(viewWorkerOrdersFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewWorkerOrdersFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewWorkerOrdersFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewWorkerOrdersFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewWorkerOrdersFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager LastOrderAppPUEntityManager;
    private javax.swing.JButton closeButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private java.util.List<lastorderapp.database.Orders> ordersList;
    private javax.persistence.Query ordersQuery;
    private javax.swing.JComboBox<String> selectedWorkerComboBox;
    private javax.swing.JLabel selectedWorkerLabel;
    private java.util.List<lastorderapp.database.Workers> workersList;
    private java.util.List<lastorderapp.database.Workers> workersList1;
    private javax.persistence.Query workersQuery;
    private javax.persistence.Query workersQuery1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
