/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_305;

import java.awt.Dimension;
import java.awt.*;
import java.util.Scanner;
import java.io.*;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class TenantPage_Hallinfo extends javax.swing.JFrame {

    static int id;
    public static boolean hallInfo = false;
    public static boolean favCheck = false;

    public TenantPage_Hallinfo() {
        this(id);
        initComponents();
        setLocationRelativeTo(null);

        // hallInfo=true;
    }

    public TenantPage_Hallinfo(int HID) {
        System.out.println("4444444");
        id = HID;
        initComponents();
        setLocationRelativeTo(null);

        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String ConnectionURL = "jdbc:mysql://localhost:3306/weddinghallreservation";
            PreparedStatement q;
            connection = DriverManager.getConnection(ConnectionURL, "root", "1212");

            String query = "Select * from `hallinfo` where `idHallInfo`='" + id + "' ";
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt(1);
                String hn = rs.getString(2);
                int hc = rs.getInt(3);
                String ha = rs.getString(4);
                double hp = rs.getDouble(5);
                String cn = rs.getString(6);

                byte[] imagedata = rs.getBytes("image");
                ImageIcon format = null;
                format = new ImageIcon(imagedata);
                Image mm = format.getImage();
                Image img2 = mm.getScaledInstance(110, 133, Image.SCALE_SMOOTH);
                ImageIcon image = new ImageIcon(img2);

                idh.setText("ID: " + id);
                name.setText(hn);
                Capacity.setText(hc + "");
                hallAddress.setText(ha);
                HallPrice.setText(hp + " SR");
                HallContact.setText(cn);
                jLabel2.setIcon(image);

            }

        } catch (Exception e) {
            System.err.println("Error");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();
        label5 = new java.awt.Label();
        hallAddress = new javax.swing.JLabel();
        HallPrice = new javax.swing.JLabel();
        Capacity = new javax.swing.JLabel();
        HallContact = new javax.swing.JLabel();
        name = new java.awt.Label();
        idh = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jButton1.setBackground(new java.awt.Color(243, 246, 251));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("Reserve");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(100, 550, 90, 30);

        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel8);
        jLabel8.setBounds(0, 0, 50, 30);

        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 600, 35, 30);

        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6);
        jLabel6.setBounds(90, 600, 36, 30);

        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7);
        jLabel7.setBounds(170, 600, 37, 30);

        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9);
        jLabel9.setBounds(240, 600, 40, 30);
        jPanel1.add(jLabel2);
        jLabel2.setBounds(60, 190, 160, 160);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        label1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        label1.setText("Capacity:");
        jPanel2.add(label1);
        label1.setBounds(10, 30, 57, 21);

        label3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        label3.setText("Price:");
        jPanel2.add(label3);
        label3.setBounds(10, 10, 37, 21);

        label4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        label4.setName(""); // NOI18N
        label4.setText("Contact Number:");
        jPanel2.add(label4);
        label4.setBounds(10, 60, 101, 21);

        label5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        label5.setText("Address:");
        jPanel2.add(label5);
        label5.setBounds(10, 80, 53, 21);
        jPanel2.add(hallAddress);
        hallAddress.setBounds(70, 80, 200, 21);
        jPanel2.add(HallPrice);
        HallPrice.setBounds(50, 10, 180, 21);
        jPanel2.add(Capacity);
        Capacity.setBounds(70, 30, 170, 22);
        jPanel2.add(HallContact);
        HallContact.setBounds(110, 60, 170, 21);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 420, 280, 110);

        name.setAlignment(java.awt.Label.CENTER);
        name.setBackground(new java.awt.Color(178, 197, 196));
        name.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        name.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel1.add(name);
        name.setBounds(90, 84, 120, 25);

        idh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(idh);
        idh.setBounds(120, 120, 60, 20);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project_305/message.png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel10);
        jLabel10.setBounds(100, 350, 30, 30);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project_305/قلب.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel11);
        jLabel11.setBounds(150, 350, 30, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project_305/tenant.jpeg"))); // NOI18N
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //  hallInfo=false;
        TenantPage_Reservation ob = new TenantPage_Reservation();
        ob.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // BBAACCCCKKKKKK
        TenantPage_Search ob;
        try {
            ob = new TenantPage_Search();
            ob.setVisible(true);
            this.setVisible(false);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TenantPage_Hallinfo.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String ConnectionURL = "jdbc:mysql://localhost:3306/weddinghallreservation";
            PreparedStatement q;
            connection = DriverManager.getConnection(ConnectionURL, "root", "1212");

            String query = "select * from favorites where favorites.idTenant ='" + Login.Id + "' and favorites.idHallInfo='" + id + "'";
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(query);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, " This Hall is already in your favorites !!");
                TenantPage_Favorate ob = new TenantPage_Favorate();
                ob.setVisible(true);
                this.setVisible(false);
            } else {
                String query2 = "insert into favorites (idTenant,idHallinfo) values (" + Login.Id + "," + id + ")";
                Statement stm2 = connection.createStatement();
                stm2.executeUpdate(query2);
                TenantPage_Favorate ob = new TenantPage_Favorate();
                ob.setVisible(true);
                this.setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
         TenantPage_Chat ob = new TenantPage_Chat();
        ob.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_jLabel10MouseClicked

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
            java.util.logging.Logger.getLogger(TenantPage_Hallinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TenantPage_Hallinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TenantPage_Hallinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TenantPage_Hallinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TenantPage_Hallinfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Capacity;
    private javax.swing.JLabel HallContact;
    private javax.swing.JLabel HallPrice;
    private javax.swing.JLabel hallAddress;
    private javax.swing.JLabel idh;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private java.awt.Label label1;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label name;
    // End of variables declaration//GEN-END:variables

}
