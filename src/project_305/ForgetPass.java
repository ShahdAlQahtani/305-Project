package project_305;

import java.sql.*;
import javax.swing.*;
/**
 * This interface to set the new passwrod if the user forgot
 * @author Group1_CAR
 */
public class ForgetPass extends javax.swing.JFrame {

    /**
     * Creates new form ForgetPass
     */
    public ForgetPass() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        coPass = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        pass = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        invalid = new javax.swing.JLabel();
        onwerOrTen = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        coPass.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        coPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coPassActionPerformed(evt);
            }
        });
        jPanel1.add(coPass);
        coPass.setBounds(30, 410, 240, 30);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(70, 530, 160, 30);

        jPanel3.setBackground(new java.awt.Color(181, 196, 196));

        jButton4.setBackground(new java.awt.Color(144, 161, 161));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/back.png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 0, 60, 40);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Enter Your Email");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 220, 150, 22);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Enter new password");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 310, 180, 22);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Confirm password");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 390, 150, 20);

        email.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel1.add(email);
        email.setBounds(30, 250, 240, 30);

        pass.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel1.add(pass);
        pass.setBounds(30, 340, 240, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel5.setText("Forget Password");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(70, 90, 170, 28);
        jPanel1.add(invalid);
        invalid.setBounds(110, 470, 0, 0);

        onwerOrTen.setText("Owner");
        onwerOrTen.setBorder(null);
        onwerOrTen.setContentAreaFilled(false);
        jPanel1.add(onwerOrTen);
        onwerOrTen.setBounds(30, 460, 79, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/page without home.jpg"))); // NOI18N
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

    /**
     * this method is for changing the user password in case of "forget password"
     * it takes the user email, a new password and confirmed password, then update it in the database depends on the queryPass
     * @param evt 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Submit

        String checkPass = Signup.isValid(pass.getText(), coPass.getText());
        if (checkPass.equals("Wrong match password")) {
            invalid.setText(checkPass);
            invalid.setVisible(true);
        } else if (checkPass.equals("invalid Password")) {
            invalid.setText(checkPass);
            invalid.setVisible(true);
        } else {
            Connection connection = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                String ConnectionURL = "jdbc:mysql://localhost:3306/weddinghallreservation";
                
                connection = DriverManager.getConnection(ConnectionURL, "root", "1212");
                PreparedStatement ps = null;

                String queryPass;
                if (onwerOrTen.isSelected()) {
                    queryPass = "Update Owner set password=?  Where Email =" + "'" + email.getText() + "'";
                } else {
                    queryPass = "Update Tenant set password=? Where Email =" + "'" + email.getText() + "'";
                }
                ps = connection.prepareStatement(queryPass);
                ps.setString(1, pass.getText());
                ps.executeUpdate();

                JOptionPane.showMessageDialog(null, " your password is updated");
                connection.close();
                Login object = new Login();
                object.setVisible(true);
                this.setVisible(false);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void coPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coPassActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_coPassActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Login ob;
        ob = new Login();
        ob.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(ForgetPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgetPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgetPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgetPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgetPass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField coPass;
    private javax.swing.JTextField email;
    private javax.swing.JLabel invalid;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton onwerOrTen;
    private javax.swing.JTextField pass;
    // End of variables declaration//GEN-END:variables
}
