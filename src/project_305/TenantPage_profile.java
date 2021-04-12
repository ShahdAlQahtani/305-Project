
package project_305;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 * This is the tenant interface
 * @author Group1_CAR
 */
public class TenantPage_profile extends javax.swing.JFrame {

    /**
     * this constracter get the Name and ID of Tenant from database and display
     * it on interface
     */
    public TenantPage_profile(){
        initComponents();
        setLocationRelativeTo(null);
        
        // connection to database
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String ConnectionURL = "jdbc:mysql://localhost:3306/weddinghallreservation";
            connection = DriverManager.getConnection(ConnectionURL, "root", "1212");
            
            
            if (Login.Id.startsWith("14")) { // check for ID that start with 14 for Tenant

                 // select statment to get the name of the Owner from database    
                String query = "Select `firstname` , `lastname`  from `Tenant` where `idTenant` ='" + Login.Id + "'";
                Statement stm = connection.createStatement();
                ResultSet rs = stm.executeQuery(query);
                while (rs.next()) {

                    // for set the Name and ID on Lable
                    name.setText("Hello, " + rs.getString(1) + " " + rs.getString(2));
                    Id.setText("ID: " + Login.Id);

                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        Id = new javax.swing.JLabel();
        label3 = new java.awt.Label();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9);
        jLabel9.setBounds(240, 600, 40, 40);

        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7);
        jLabel7.setBounds(170, 600, 37, 40);

        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6);
        jLabel6.setBounds(90, 600, 36, 40);

        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 600, 35, 40);

        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/logout.png"))); // NOI18N
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });
        jPanel1.add(logout);
        logout.setBounds(260, 10, 30, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/user.png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(120, 220, 72, 70);

        name.setBackground(new java.awt.Color(0, 0, 0));
        name.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        name.setText("Hi Ameera Mohammed");
        jPanel1.add(name);
        name.setBounds(70, 300, 180, 40);

        Id.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Id.setText("ID :1400");
        Id.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(Id);
        Id.setBounds(120, 350, 80, 22);

        label3.setBackground(new java.awt.Color(255, 255, 255));
        label3.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        label3.setText("  Account Information                  >"); // NOI18N
        label3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label3MouseClicked(evt);
            }
        });
        jPanel1.add(label3);
        label3.setBounds(40, 440, 230, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ProfileT.jpg"))); // NOI18N
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

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        TenantPage_profile ob = null;
        ob = new TenantPage_profile();
        ob.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        TenantPage_Favorate ob = new TenantPage_Favorate();
        ob.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        TenantPage_Search ob;
        ob = new TenantPage_Search();
        ob.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        TenantPage_Home ob = new TenantPage_Home();
        ob.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        // TODO add your handling code here:
        Login ob = new Login();
        ob.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_logoutMouseClicked

    private void label3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label3MouseClicked
        // TODO add your handling code here:
        TenantPage_EditProfile ob = new TenantPage_EditProfile();
        ob.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_label3MouseClicked

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
            java.util.logging.Logger.getLogger(TenantPage_profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TenantPage_profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TenantPage_profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TenantPage_profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TenantPage_profile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private java.awt.Label label3;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel name;
    // End of variables declaration//GEN-END:variables
}
