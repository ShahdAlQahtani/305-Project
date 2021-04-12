/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_305;

import java.awt.Image;
import java.sql.*;
import static java.sql.ResultSet.CONCUR_READ_ONLY;
import static java.sql.ResultSet.TYPE_SCROLL_SENSITIVE;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 * This is the halls interface will display all the halls the onwer have
 * @author Group1_CAR
 */
public class OwnerPage_Hall extends javax.swing.JFrame {

    /**
     * Creates new form OwnerPage_Hall
     */
    int id_hall;

    public OwnerPage_Hall() {
        initComponents();
        setLocationRelativeTo(null);
        list();
    }
    /**
     * THS METHOD used to retreive all the owner's hall
     */
    public void list() {
        noHall1.setVisible(false);
        noHall2.setVisible(false);
        DefaultTableModel table = new DefaultTableModel(); //create a TableModel to show the data in it
        table.addColumn("Hall Name"); //one Column in this table

        try {
            Connection connection = null;

            Class.forName("com.mysql.cj.jdbc.Driver"); //Load the correct JDBC driver 
            String ConnectionURL = "jdbc:mysql://localhost:3306/weddinghallreservation"; 
            connection = DriverManager.getConnection(ConnectionURL, "root", "1212"); //Open a Connection to the database
            String query = "select Hallname from hallinfo where `idOwner`='" + Login.Id + "' ";
            Statement stat = connection.createStatement(TYPE_SCROLL_SENSITIVE, CONCUR_READ_ONLY); // create a statement of type TYPE_SCROLL_SENSITIVE and CONCUR_READ_ONLY
            ResultSet rs = stat.executeQuery(query);
            
            if (rs.next()) { //check first if there is any hall
                jScrollPane1.setVisible(true);
                list.setVisible(true);

                rs.previous(); //then go bacl to the  previous
                while (rs.next()) { // and start add row to the table and print elements in it
                    table.addRow(new Object[]{
                        rs.getString("Hallname")
                    });
                }
                list.setModel(table); //Sets the data model for this table
            } else { //if there is no hall then just display "nohall" labels 
                panel2.setVisible(false);
                edit.setVisible(false);
                delete.setVisible(false);
                jScrollPane1.setVisible(false);
                noHall1.setVisible(true);
                noHall2.setVisible(true);
                list.setVisible(false);
            }
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

        panel1 = new java.awt.Panel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        list = new javax.swing.JTable();
        panel2 = new java.awt.Panel();
        HallImage = new javax.swing.JLabel();
        hallName = new javax.swing.JLabel();
        Capacity = new javax.swing.JLabel();
        hallAddress = new javax.swing.JLabel();
        HallPrice = new javax.swing.JLabel();
        HallContact = new javax.swing.JLabel();
        Id = new javax.swing.JLabel();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        noHall2 = new javax.swing.JLabel();
        edit = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        noHall1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setPreferredSize(new java.awt.Dimension(300, 650));
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        jLabel2.setText("Halls");
        panel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 80, -1));

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

        panel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 100, 370));

        panel2.setBackground(new java.awt.Color(243, 246, 251));

        hallName.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        Capacity.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        hallAddress.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        HallPrice.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        HallContact.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        Id.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        label1.setText("label1");

        label2.setText("label2");

        label3.setText("label3");

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(HallImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HallPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HallContact, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Id, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Capacity, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hallAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hallName, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addComponent(HallImage, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hallName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(Id, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(HallContact, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(HallPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(hallAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Capacity, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        panel1.add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 150, 370));

        noHall2.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        noHall2.setForeground(new java.awt.Color(153, 153, 153));
        noHall2.setText("any hall yet.");
        panel1.add(noHall2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 150, -1));

        edit.setBackground(new java.awt.Color(255, 255, 255));
        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        panel1.add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 80, -1));

        delete.setBackground(new java.awt.Color(255, 255, 255));
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        panel1.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 560, 80, -1));

        noHall1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        noHall1.setForeground(new java.awt.Color(153, 153, 153));
        noHall1.setText("You do not have ");
        panel1.add(noHall1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, -1, -1));

        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        panel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, 50, 40));

        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        panel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 600, 50, 50));

        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        panel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 610, 50, 40));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/page_O.png"))); // NOI18N
        jLabel1.setText("Account Information          >>"); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        panel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        OwnerPage_Profile ob = null;
        ob = new OwnerPage_Profile();

        ob.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel1MouseClicked
/**
 * this message the hall name the onwer select and display its information
 * @param evt 
 */
    private void listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMouseClicked
        // TODO add your handling code here:
        int index = list.getSelectedRow(); //take index of row selected by the owner from the table
        String name = list.getValueAt(index, 0).toString(); // get the value specified in this cell
        Connection connection = null;
        panel2.setVisible(true);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String ConnectionURL = "jdbc:mysql://localhost:3306/weddinghallreservation";
            connection = DriverManager.getConnection(ConnectionURL, "root", "1212");
            String query = "Select `idhallinfo`,`Hallname` , `hallcapacity` , `hallAddress`, `hallPrice`, `contactNumber`,`image` from `hallinfo` where `Hallname`='" + name + "' and `idOwner`='" + Login.Id + "' ";
            Statement stat = connection.createStatement();
            ResultSet rs = stat.executeQuery(query);

            while (rs.next()) {
                id_hall = rs.getInt(1); //display selected hall information
                Id.setText("ID: " + id_hall);
                hallName.setText("Name: " + rs.getString(2));
                Capacity.setText("Capacity: " + rs.getInt(3));
                hallAddress.setText("Address: " + rs.getString(4));
                HallPrice.setText("Price: " + rs.getDouble(5));
                HallContact.setText("Phone: " + rs.getString(6));

                byte[] imagedata = rs.getBytes("image");//to get the image from database and display it
                ImageIcon format = null;
                format = new ImageIcon(imagedata);
                Image mm = format.getImage();
                Image img2 = mm.getScaledInstance(110, 133, Image.SCALE_SMOOTH);
                ImageIcon image = new ImageIcon(img2);
                HallImage.setIcon(image);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_listMouseClicked

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
        OwnerPage_EditHall ob = null;
        ob = new OwnerPage_EditHall(id_hall);
        ob.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_editActionPerformed
/**
 * this method to delete the selected hall
 * @param evt 
 */
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        int index = list.getSelectedRow();
        String name = list.getValueAt(index, 0).toString();
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String ConnectionURL = "jdbc:mysql://localhost:3306/weddinghallreservation";

            connection = DriverManager.getConnection(ConnectionURL, "root", "1212");

            Statement stat = connection.createStatement();
            ResultSet reserved_hall = stat.executeQuery("select * from reservation where idHallinfo=" + id_hall);

            
            if (reserved_hall.next() == true) {//check if there is any reservation in this hall
                JOptionPane.showMessageDialog(null, "cannot delete this hall because there is reservation in it");
            } else {//if not
                int delete = stat.executeUpdate("delete from hallinfo where Hallname ='" + name + "' ");

                if (delete == 1) {
                    JOptionPane.showMessageDialog(null, "The Hall was Deleted Successfully ");

                }

                panel2.setVisible(false);
                list();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_deleteActionPerformed

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
            java.util.logging.Logger.getLogger(OwnerPage_Hall.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OwnerPage_Hall.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OwnerPage_Hall.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OwnerPage_Hall.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OwnerPage_Hall().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Capacity;
    private javax.swing.JLabel HallContact;
    private javax.swing.JLabel HallImage;
    private javax.swing.JLabel HallPrice;
    private javax.swing.JLabel Id;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JLabel hallAddress;
    private javax.swing.JLabel hallName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private javax.swing.JTable list;
    private javax.swing.JLabel noHall1;
    private javax.swing.JLabel noHall2;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    // End of variables declaration//GEN-END:variables
}
