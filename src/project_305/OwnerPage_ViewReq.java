/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_305;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import static java.sql.ResultSet.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author shahad
 */
public class OwnerPage_ViewReq extends javax.swing.JFrame {

    /**
     * Creates new form OwnerPage_ViewReq
     */
    public OwnerPage_ViewReq() {
        initComponents();
        setLocationRelativeTo(null);
        list();
    }

    public void list() {
        jScrollPane2.setVisible(false);
        list1.setVisible(false);
        NoRes.setVisible(false);
        NoRes.setVisible(false);
        DefaultTableModel table = new DefaultTableModel();
        table.addColumn("Hall Name");

        try {
            Connection connection = null;

            Class.forName("com.mysql.cj.jdbc.Driver");
            String ConnectionURL = "jdbc:mysql://localhost:3306/weddinghallreservation";
            connection = DriverManager.getConnection(ConnectionURL, "root", "1212");

            String query = "Select `Hallname` from `hallinfo` where `hallinfo`.`idOwner`='" + Login.Id + "'";
            Statement stat = connection.createStatement();
            ResultSet rs = stat.executeQuery(query);

            while (rs.next()) {

                table.addRow(new Object[]{rs.getString(1)});

            }
            list.setModel(table);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        } catch (Exception e) {
            e.printStackTrace();
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
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        NoRes = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        list = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        list1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

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
        jLabel5.setBounds(20, 610, 35, 30);

        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6);
        jLabel6.setBounds(90, 610, 36, 30);

        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7);
        jLabel7.setBounds(170, 610, 37, 30);

        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9);
        jLabel9.setBounds(240, 610, 40, 30);

        NoRes.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        NoRes.setText("No Rservation For This Hall..!");
        jPanel1.add(NoRes);
        NoRes.setBounds(40, 400, 224, 40);

        jScrollPane1.setBackground(new java.awt.Color(243, 246, 251));
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        list.setBackground(new java.awt.Color(243, 246, 251));
        list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        list.setColumnSelectionAllowed(true);
        list.setFillsViewportHeight(true);
        list.setFocusCycleRoot(true);
        list.setSelectionForeground(new java.awt.Color(243, 246, 251));
        list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(list);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(60, 230, 180, 80);

        jScrollPane2.setBackground(new java.awt.Color(243, 246, 251));
        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        list1.setBackground(new java.awt.Color(243, 246, 251));
        list1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        list1.setColumnSelectionAllowed(true);
        list1.setFillsViewportHeight(true);
        list1.setFocusCycleRoot(true);
        list1.setSelectionForeground(new java.awt.Color(243, 246, 251));
        list1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(list1);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(10, 390, 280, 120);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/page.png"))); // NOI18N
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
        OwnerPage_Home ob = new OwnerPage_Home();
        ob.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        OwnerPage_Home ob = new OwnerPage_Home();
        ob.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        OwnerPage_ViewReq ob = new OwnerPage_ViewReq();
        ob.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        OwnerPage_Comment ob = new OwnerPage_Comment();
        ob.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        OwnerPage_Profile ob = null;
        ob = new OwnerPage_Profile();
        ob.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMouseClicked
        // TODO add your handling code here:
        int index = list.getSelectedRow();
        String name = list.getValueAt(index, 0).toString();

        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String ConnectionURL = "jdbc:mysql://localhost:3306/weddinghallreservation";
            connection = DriverManager.getConnection(ConnectionURL, "root", "1212");

            String query = "Select `firstname` , `lastname`,`resDate` from `tenant`,`reservation`,`hallinfo` where `tenant`.`idTenant` =`reservation`.`idTenant` and `hallinfo`.`idOwner`='" + Login.Id + "' and `hallinfo`.`Hallname` ='" + name + "' and `reservation`.`idHallInfo` =`hallinfo`.`idHallInfo`";

            Statement stat = connection.createStatement(TYPE_SCROLL_SENSITIVE, CONCUR_READ_ONLY);
            ResultSet rs = stat.executeQuery(query);

            if (rs.next()) {
                jScrollPane2.setVisible(true);
                list1.setVisible(true);
                NoRes.setVisible(false);
                
                rs.previous();
                DefaultTableModel table1 = new DefaultTableModel();
                
                table1.addColumn("Reserved by");
                table1.addColumn("Date");
                
                while (rs.next()) {
                    table1.addRow(new Object[]{rs.getString(1)+" "+rs.getString(2), rs.getString(3)});
                }
                list1.setModel(table1);
            } else {
                jScrollPane2.setVisible(false);
                list1.setVisible(false);
                NoRes.setVisible(true);
                NoRes.setVisible(true);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_listMouseClicked

    private void list1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_list1MouseClicked

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
            java.util.logging.Logger.getLogger(OwnerPage_ViewReq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OwnerPage_ViewReq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OwnerPage_ViewReq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OwnerPage_ViewReq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OwnerPage_ViewReq().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NoRes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable list;
    private javax.swing.JTable list1;
    // End of variables declaration//GEN-END:variables
}
