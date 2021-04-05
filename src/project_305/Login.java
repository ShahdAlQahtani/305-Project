/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_305;

import java.io.*;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    boolean checkOwner;
    FileReader d;
    Scanner input;
    static String Id;
    static String first;
    static String last;
    static String firstO;
    static String lastO;
    static String email;

    public Login() throws FileNotFoundException {
        initComponents();
        setLocationRelativeTo(null);
//        this.d = new FileReader("Users.txt");
//        input = new Scanner(d);

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
        id = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        back = new javax.swing.JButton();
        Password = new javax.swing.JPasswordField();
        incorrectPass = new javax.swing.JLabel();
        check = new javax.swing.JCheckBox();
        label1 = new java.awt.Label();
        Login = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });
        jPanel1.add(id);
        id.setBounds(20, 250, 240, 40);

        jPanel4.setBackground(new java.awt.Color(181, 196, 196));

        back.setBackground(new java.awt.Color(144, 161, 161));
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project_305/back.png"))); // NOI18N
        back.setBorder(null);
        back.setContentAreaFilled(false);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(back)
                .addGap(0, 39, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel4);
        jPanel4.setBounds(0, 0, 60, 40);
        jPanel1.add(Password);
        Password.setBounds(20, 330, 240, 40);

        incorrectPass.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(incorrectPass);
        incorrectPass.setBounds(100, 310, 178, 21);

        check.setBackground(new java.awt.Color(243, 246, 251));
        check.setForeground(new java.awt.Color(102, 102, 102));
        check.setText("show password");
        check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkActionPerformed(evt);
            }
        });
        jPanel1.add(check);
        check.setBounds(40, 380, 141, 29);

        label1.setBackground(new java.awt.Color(243, 246, 251));
        label1.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        label1.setForeground(new java.awt.Color(102, 102, 102));
        label1.setText("Forget Password?");
        label1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label1MouseClicked(evt);
            }
        });
        jPanel1.add(label1);
        label1.setBounds(180, 410, 116, 21);

        Login.setBackground(new java.awt.Color(255, 255, 255));
        Login.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        Login.setText("Log in");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });
        jPanel1.add(Login);
        Login.setBounds(90, 520, 127, 35);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Password:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 300, 80, 22);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("ID:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 220, 30, 22);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\shood\\Documents\\NetBeansProjects\\305-Project\\src\\project_305\\login.jpg")); // NOI18N
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

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        Signup ob;
        try {
            ob = new Signup();
            this.setVisible(false);
            ob.setVisible(true);

        } catch (IOException ex) {
            Logger.getLogger(Login.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_backActionPerformed

    private void checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkActionPerformed
        // TODO add your handling code here:

        if (check.isSelected()) {

            Password.setEchoChar((char) 0);
        } else {
            Password.setEchoChar('*');
        }
    }//GEN-LAST:event_checkActionPerformed

    private void label1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label1MouseClicked
        // TODO add your handling code here:

        ForgetPass ob;
        ob = new ForgetPass();
        this.setVisible(false);
        ob.setVisible(true);
    }//GEN-LAST:event_label1MouseClicked

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed

        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String ConnectionURL = "jdbc:mysql://localhost:3306/weddinghallreservation";
           
            PreparedStatement q;

           
            connection = DriverManager.getConnection(ConnectionURL, "root", "1212");
        

            Id = id.getText();
            
            if (Id.startsWith("12")) {
                q = connection.prepareStatement("Select `idOwner` , `Password` from `owner` where `idOwner`=? AND `Password`=? ");
                q.setString(1, Id);
                q.setString(2, String.valueOf(Password.getPassword()));
                ResultSet r = q.executeQuery();
                if (r.next()) {
                    OwnerPage_Home ob = new OwnerPage_Home();
                    ob.setVisible(true);
                    this.setVisible(false);

                } else {
                    incorrectPass.setText("Incorrect email or password");
                }

            } else {
                q = connection.prepareStatement("Select `idTenant` , `Password` from `tenant` where `idTenant`=? AND `Password`=? ");
                q.setString(1, Id);
                q.setString(2, String.valueOf(Password.getPassword()));
                ResultSet r = q.executeQuery();

                if (r.next()) {
                    TenantPage_Home ob = new TenantPage_Home();
                    ob.setVisible(true);
                    this.setVisible(false);
                } else {

                    incorrectPass.setText("Incorrect email or password");
                }

            }

            connection.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_LoginActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Login().setVisible(true);

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Login.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Login;
    private javax.swing.JPasswordField Password;
    private javax.swing.JButton back;
    private javax.swing.JCheckBox check;
    private javax.swing.JTextField id;
    private javax.swing.JLabel incorrectPass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
