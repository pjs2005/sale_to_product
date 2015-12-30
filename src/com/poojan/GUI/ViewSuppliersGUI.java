/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poojan.GUI;

import com.poojan.model.DBManager;
import com.poojan.model.Product;
import com.poojan.model.Sale;
import com.poojan.model.Supplier;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Poojan
 */
public class ViewSuppliersGUI extends javax.swing.JFrame {

    DBManager dBManager = new DBManager();

    /**
     * Creates new form ViewSuppliersGUI
     */
    public ViewSuppliersGUI() {
        initComponents();
        setUpTable();
    }

    private void setUpTable() {
        dBManager = new DBManager();
        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        tableHeaders.add("ID");
        tableHeaders.add("Name");
        tableHeaders.add("Phone");
        tableHeaders.add("Email");
        tableHeaders.add("Address");

        for (Supplier supplier : dBManager.getAllSuppliers()) {

            Vector<Object> oneRow = new Vector<Object>();
            oneRow.add(supplier.getId());
            oneRow.add(supplier.getName());
            oneRow.add(supplier.getPhone());
            oneRow.add(supplier.getEmail());
            oneRow.add(supplier.getAddress());

            tableData.add(oneRow);

        }

        supplersTable.setModel(new DefaultTableModel(tableData, tableHeaders));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        viewName = new javax.swing.JLabel();
        suppliersScrollPane = new javax.swing.JScrollPane();
        supplersTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });

        viewName.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        viewName.setText("Suppliers");

        supplersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        supplersTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                supplersTableFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                supplersTableFocusLost(evt);
            }
        });
        supplersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                supplersTableMouseClicked(evt);
            }
        });
        suppliersScrollPane.setViewportView(supplersTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(viewName)
                .addContainerGap(176, Short.MAX_VALUE))
            .addComponent(suppliersScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(viewName)
                .addGap(18, 18, 18)
                .addComponent(suppliersScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void supplersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplersTableMouseClicked
        Supplier found = dBManager.getSupllier((int) supplersTable.getValueAt(supplersTable.getSelectedRow(), 0));
        new NewSupplierGUI(found).setVisible(true);
        setUpTable();
    }//GEN-LAST:event_supplersTableMouseClicked

    private void supplersTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_supplersTableFocusGained
        setUpTable();
    }//GEN-LAST:event_supplersTableFocusGained

    private void supplersTableFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_supplersTableFocusLost
        setUpTable();
    }//GEN-LAST:event_supplersTableFocusLost

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        setUpTable();
    }//GEN-LAST:event_formFocusGained

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
         setUpTable();
    }//GEN-LAST:event_formFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable supplersTable;
    private javax.swing.JScrollPane suppliersScrollPane;
    private javax.swing.JLabel viewName;
    // End of variables declaration//GEN-END:variables
}
