/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.ProductDAO;

/**
 *
 * @author Kendall Lauren Chin
 */
public class MainMenuFrame extends javax.swing.JFrame {

    ProductDAO dao;

    /**
     * Creates new form MainMenuFrame
     */
    public MainMenuFrame(ProductDAO aDAO) {
        dao = aDAO;
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblMainMenu = new javax.swing.JLabel();
        btnAddProduct = new javax.swing.JButton();
        btnViewProducts = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        lblMainMenu1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(67, 38, 127));

        lblMainMenu.setFont(new java.awt.Font("Corbert", 0, 24)); // NOI18N
        lblMainMenu.setForeground(new java.awt.Color(255, 255, 255));
        lblMainMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMainMenu.setText("Administration");

        btnAddProduct.setBackground(new java.awt.Color(153, 220, 255));
        btnAddProduct.setFont(new java.awt.Font("Corbert", 0, 14)); // NOI18N
        btnAddProduct.setForeground(new java.awt.Color(255, 255, 255));
        btnAddProduct.setText("Add a New Product");
        btnAddProduct.setBorderPainted(false);
        btnAddProduct.setContentAreaFilled(false);
        btnAddProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAddProduct.setFocusPainted(false);
        btnAddProduct.setFocusable(false);
        btnAddProduct.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductActionPerformed(evt);
            }
        });

        btnViewProducts.setBackground(new java.awt.Color(153, 220, 255));
        btnViewProducts.setFont(new java.awt.Font("Corbert", 0, 14)); // NOI18N
        btnViewProducts.setForeground(new java.awt.Color(255, 255, 255));
        btnViewProducts.setText("View Products");
        btnViewProducts.setBorderPainted(false);
        btnViewProducts.setContentAreaFilled(false);
        btnViewProducts.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnViewProducts.setFocusPainted(false);
        btnViewProducts.setFocusable(false);
        btnViewProducts.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnViewProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewProductsActionPerformed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(153, 220, 255));
        btnExit.setFont(new java.awt.Font("Corbert", 0, 14)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("Exit");
        btnExit.setBorderPainted(false);
        btnExit.setContentAreaFilled(false);
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnExit.setFocusPainted(false);
        btnExit.setFocusable(false);
        btnExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        lblMainMenu1.setFont(new java.awt.Font("Corbert", 0, 24)); // NOI18N
        lblMainMenu1.setForeground(new java.awt.Color(255, 255, 255));
        lblMainMenu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMainMenu1.setText("Product");
        lblMainMenu1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnAddProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnViewProducts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblMainMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblMainMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMainMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMainMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnViewProducts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnViewProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewProductsActionPerformed
        ProductReportDialog dialog = new ProductReportDialog(this, true, dao);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);

    }//GEN-LAST:event_btnViewProductsActionPerformed

    private void btnAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductActionPerformed
        ProductDialog dialog = new ProductDialog(this, true, dao);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);

    }//GEN-LAST:event_btnAddProductActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddProduct;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnViewProducts;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblMainMenu;
    private javax.swing.JLabel lblMainMenu1;
    // End of variables declaration//GEN-END:variables
}
