/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_305;

import java.awt.Color;
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TenantPage_Search extends javax.swing.JFrame {

    public TenantPage_Search() throws FileNotFoundException {
        initComponents();
        setLocationRelativeTo(null);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel paintPanel = new JPanel();
        JPanel textPanel = new JPanel();

        mainPanel.add(paintPanel);
        mainPanel.add(textPanel);
        //  jPanel5.setVisible(false);
        //details.setVisible(false);
        //Fav.setVisible(false);
        // jPanel7.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        jPanel8 = new javax.swing.JPanel();
        SearchText = new javax.swing.JTextField();
        Search = new javax.swing.JButton();
        textArea1 = new java.awt.TextArea();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(null);

        jLabel2.setText("jLabel2");
        jPanel10.add(jLabel2);
        jLabel2.setBounds(10, 20, 80, 100);

        label1.setText("label1");
        jPanel10.add(label1);
        label1.setBounds(110, 90, 140, 20);

        label2.setText("label1");
        jPanel10.add(label2);
        label2.setBounds(110, 30, 140, 20);

        label3.setText("label1");
        jPanel10.add(label3);
        label3.setBounds(110, 60, 140, 20);

        jPanel1.add(jPanel10);
        jPanel10.setBounds(10, 240, 270, 140);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(null);

        SearchText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchTextActionPerformed(evt);
            }
        });
        jPanel8.add(SearchText);
        SearchText.setBounds(0, 10, 214, 26);

        Search.setBackground(new java.awt.Color(255, 255, 255));
        Search.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        Search.setIcon(new javax.swing.ImageIcon("C:\\Users\\shood\\Documents\\NetBeansProjects\\305-Project\\src\\project_305\\search.png")); // NOI18N
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });
        jPanel8.add(Search);
        Search.setBounds(220, 10, 29, 26);

        jPanel1.add(jPanel8);
        jPanel8.setBounds(10, 180, 260, 40);

        textArea1.setBackground(new java.awt.Color(243, 246, 251));
        jPanel1.add(textArea1);
        textArea1.setBounds(-10, 400, 310, 190);

        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9);
        jLabel9.setBounds(240, 600, 40, 30);

        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7);
        jLabel7.setBounds(170, 600, 37, 30);

        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6);
        jLabel6.setBounds(90, 600, 36, 30);

        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 600, 35, 30);

        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel8);
        jLabel8.setBounds(0, 10, 50, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\shood\\Documents\\NetBeansProjects\\305-Project\\src\\project_305\\page.png")); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 300, 650);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // BBAACCCCKKKKKK
        TenantPage_Home ob = new TenantPage_Home();
        ob.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        TenantPage_Home ob = new TenantPage_Home();
        ob.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        TenantPage_Search ob;
        try {
            ob = new TenantPage_Search();
            ob.setVisible(true);
            this.setVisible(false);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TenantPage_Chat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        TenantPage_Favorate ob = new TenantPage_Favorate();
        ob.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        TenantPage_profile ob = null;
        try {
            ob = new TenantPage_profile();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TenantPage_Chat.class.getName()).log(Level.SEVERE, null, ex);
        }
        ob.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_SearchActionPerformed

    private void SearchTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchTextActionPerformed

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
            java.util.logging.Logger.getLogger(TenantPage_Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TenantPage_Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TenantPage_Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TenantPage_Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TenantPage_Search().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(TenantPage_Search.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Search;
    private javax.swing.JTextField SearchText;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel8;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.TextArea textArea1;
    // End of variables declaration//GEN-END:variables

}
