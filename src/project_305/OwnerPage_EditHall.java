/**
 * This interface allows the owner to edit his hall information
 */
package project_305;

import java.io.*;
import java.sql.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
/**
 * This is the edit Hall interface let the onwer to edit the hall information
 * @author Group1_CAR
 */
public class OwnerPage_EditHall extends javax.swing.JFrame {

    String path;// to save path of the image
    InputStream image1;
    public OwnerPage_EditHall() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public OwnerPage_EditHall(int id) {

        initComponents();
        setLocationRelativeTo(null);
        display(id);//call display method 
    }

    /**
     *  This Method display the Hall info into TextField from the Database
     * @param id the hall id that will print its information
     */
    public void display(int id) {
         // connection to database
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String ConnectionURL = "jdbc:mysql://localhost:3306/weddinghallreservation";

            connection = DriverManager.getConnection(ConnectionURL, "root", "1212");
             
            // select statment to get all data of the Hall from database  
            String query = "Select `Hallname` , `hallcapacity` , `hallAddress`, `hallPrice`, `contactNumber`,`image` from `hallinfo` where `idhallinfo`='" + id + "' ";
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(query);// result of query
            Hallid.setText(id + "");
            while (rs.next()) {
              // set all data into TextField to display it for Owner
                hallName.setText(rs.getString(1));
                Capacity.setText(rs.getInt(2) + "");
                hallAddress.setText(rs.getString(3));
                HallPrice.setText(rs.getDouble(4) + "");
                HallContact.setText(rs.getString(5));
                image1=rs.getBlob(6).getBinaryStream();

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
        jPanel5 = new javax.swing.JPanel();
        HallPrice = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        HallContact = new javax.swing.JTextField();
        update = new javax.swing.JButton();
        imag = new javax.swing.JButton();
        s2 = new javax.swing.JPanel();
        hallName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Capacity = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        hallAddress = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Hallid = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jPanel5.setBackground(new java.awt.Color(243, 246, 251));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(HallPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(HallPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel5);
        jPanel5.setBounds(0, 380, 290, 50);

        jPanel7.setBackground(new java.awt.Color(243, 246, 251));

        update.setBackground(new java.awt.Color(255, 255, 255));
        update.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        update.setForeground(new java.awt.Color(51, 51, 51));
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        imag.setBackground(new java.awt.Color(255, 255, 255));
        imag.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        imag.setText("Upload Image");
        imag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imagActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(update)
                .addGap(39, 39, 39))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imag)
                    .addComponent(HallContact, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(HallContact, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(imag)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel7);
        jPanel7.setBounds(0, 460, 310, 122);

        s2.setBackground(new java.awt.Color(243, 246, 251));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Hall capacity*");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Hall address*");

        javax.swing.GroupLayout s2Layout = new javax.swing.GroupLayout(s2);
        s2.setLayout(s2Layout);
        s2Layout.setHorizontalGroup(
            s2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(s2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(s2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Capacity, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addComponent(hallName, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addGroup(s2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(s2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(hallAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        s2Layout.setVerticalGroup(
            s2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(s2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(hallName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(0, 0, 0)
                .addComponent(Capacity, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(0, 0, 0)
                .addComponent(hallAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(s2);
        s2.setBounds(10, 210, 280, 150);

        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 610, 35, 30);

        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5);
        jLabel5.setBounds(90, 610, 36, 30);

        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6);
        jLabel6.setBounds(170, 610, 37, 30);

        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7);
        jLabel7.setBounds(240, 610, 40, 30);

        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel8);
        jLabel8.setBounds(0, 0, 50, 30);

        Hallid.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jPanel1.add(Hallid);
        Hallid.setBounds(110, 150, 70, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/hallInfo_O.png"))); // NOI18N
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
     * This Method takes input from Owner then update his hall info in the Database
     * 
     */
    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
      
         // object from Hall to store the information on it
        HallInformation info = new HallInformation();
       
        // to takes the updated information from TextFeild that entry by Owner
        info.setHallName(hallName.getText());
        info.setCapacity(Integer.parseInt(Capacity.getText()));
        info.setHallAddress(hallAddress.getText());
        info.setHallprice(Double.parseDouble(HallPrice.getText()));
        info.setHallcontactNum(HallContact.getText());
        if(path!=null)
            info.setImage(path);
        else
            info.setImage1(image1);
        

        info.editHall(info, Integer.parseInt(Hallid.getText()));// call edit hall method and pass the object of hall and id
        OwnerPage_Hall obj = new OwnerPage_Hall();
        obj.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_updateActionPerformed
    /**
     * This button allows the owner to choose a picture then update it in Database
     * 
     */
    private void imagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imagActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChos = new JFileChooser();
        fileChos.showOpenDialog(this);
        File file = fileChos.getSelectedFile();
        try {
            path = file.getAbsolutePath();
        } catch (NullPointerException n) {
            JOptionPane.showMessageDialog(null, " Please choose a picture ");
        }

    }//GEN-LAST:event_imagActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        OwnerPage_Home ob = new OwnerPage_Home();
        ob.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        OwnerPage_ViewReq ob = new OwnerPage_ViewReq();
        ob.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        OwnerPage_Hall ob = new OwnerPage_Hall();
        ob.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        OwnerPage_Profile ob = null;
        ob = new OwnerPage_Profile();
        ob.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // BBAACCCCKKKKKK
        OwnerPage_Hall ob = null;
        ob = new OwnerPage_Hall();
        ob.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel8MouseClicked

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
            java.util.logging.Logger.getLogger(OwnerPage_EditHall.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OwnerPage_EditHall.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OwnerPage_EditHall.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OwnerPage_EditHall.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OwnerPage_EditHall().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Capacity;
    private javax.swing.JTextField HallContact;
    private javax.swing.JTextField HallPrice;
    private javax.swing.JLabel Hallid;
    private javax.swing.JTextField hallAddress;
    private javax.swing.JTextField hallName;
    private javax.swing.JButton imag;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel s2;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
