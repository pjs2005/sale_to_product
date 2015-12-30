/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poojan.GUI;

import com.poojan.model.DBManager;
import com.poojan.model.Product;
import com.poojan.model.Supplier;
import static java.util.Collections.list;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Poojan
 */
public class ViewProductsGUI extends javax.swing.JFrame {

    DBManager dBManager = new DBManager();
    Supplier supplier = null;

    /**
     * Creates new form ViewProductsGUI
     */
    public ViewProductsGUI() {
        initComponents();
        setUpTable();
    }

    public ViewProductsGUI(Supplier supplier) {
        initComponents();
        this.supplier = dBManager.getSupllier(supplier.getId());

    }

    private void setUpTable() {

        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        tableHeaders.add("ID");
        tableHeaders.add("Name");
        tableHeaders.add("Price");
        tableHeaders.add("Supplier");

        List<Product> list;
        dBManager = new DBManager();
        if (supplier != null) {
            list = dBManager.getAllProducts(supplier);
        } else {
            list = dBManager.getAllProducts();
        }

        for (Product product : list) {

            Vector<Object> oneRow = new Vector<Object>();
            oneRow.add(product.getId());
            oneRow.add(product.getName());
            oneRow.add(product.getPrice());
            oneRow.add(product.getSupplier().getName());
//            Supplier found = dBManager.getSupllier(product.getSupplier().getId());
//            oneRow.add(found.getName());
            tableData.add(oneRow);

        }

        productsTable.setModel(new DefaultTableModel(tableData, tableHeaders));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        productsTable = new javax.swing.JTable();
        titleLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        productsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        productsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        productsTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                productsTableFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                productsTableFocusLost(evt);
            }
        });
        productsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(productsTable);

        titleLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        titleLabel.setText("Products");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(344, 344, 344)
                .addComponent(titleLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void productsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productsTableMouseClicked
        Product found = dBManager.getProduct((int) productsTable.getValueAt(productsTable.getSelectedRow(), 0));

        new NewProductGUI(found).setVisible(true);


    }//GEN-LAST:event_productsTableMouseClicked

    private void productsTableFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_productsTableFocusLost
        setUpTable();
    }//GEN-LAST:event_productsTableFocusLost

    private void productsTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_productsTableFocusGained
        setUpTable();
    }//GEN-LAST:event_productsTableFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable productsTable;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
