package project_305;

import java.sql.*;
import static java.sql.ResultSet.CONCUR_READ_ONLY;
import static java.sql.ResultSet.TYPE_SCROLL_SENSITIVE;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * This interface is showing the Tenant current reservation Then, after the
 * reservation time expired, or the reservation is canceled, the reservation
 * will be removed from this interface
 *
 * @author Group1_CAR
 */
public class TenantPage_Current extends javax.swing.JFrame {

    public static boolean curr = true;
    int idRese = 0;

    public TenantPage_Current() {
        initComponents();
        setLocationRelativeTo(null);
        curr = true;
        list(); //call list method
    }
/**
 * THIS METHOD DISPLAY CURRENT RESERVATION INFORMATION
 */
    public void list() {
        noRes1.setVisible(false);
        noRes2.setVisible(false);
        DefaultTableModel table1 = new DefaultTableModel(); // CREATE A TABLE ON AND IT'S COLUMNS
        table1.addColumn("ReserveId");
        table1.addColumn("Hall Name");
        table1.addColumn("Date");
        Date dayDate = new Date(new java.util.Date().getTime()); // GET TODAY'S DATE
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String ConnectionURL = "jdbc:mysql://localhost:3306/weddinghallreservation";
            connection = DriverManager.getConnection(ConnectionURL, "root", "1212");
            String query = "Select Hallname , resDate , idReserve from hallinfo,Reservation where Reservation.idTenant ='" + Login.Id + "'"
                    + " and hallinfo.idHallInfo=Reservation.idHallInfo";

            Statement stat = connection.createStatement(TYPE_SCROLL_SENSITIVE, CONCUR_READ_ONLY);
            ResultSet rs = stat.executeQuery(query);

            if (rs.next()) {// CHECK IF THERE IS ANY RESERVATION
                jLabel4.setVisible(true);
                jLabel3.setVisible(true);
                jScrollPane2.setVisible(true);
                list1.setVisible(true);

                rs.previous();// GO BACK FOR THE FIRST RESULT

                while (rs.next()) {
                    Date date = rs.getDate(2);// GET THE RESERVATION DATE
                    if (date.after(dayDate)) { // CHECK OF THE DATE IS AFTER THE TODAY DATE THEN PRINT IT'S INFORMATION
                        table1.addRow(new Object[]{rs.getInt(3), rs.getString(1), rs.getDate(2)});
                    }
                }
                list1.setModel(table1);
            } else {// IF NOT THEN THE DISPLAY THERE IS NO RESERVATION
                jLabel4.setVisible(false);
                jLabel3.setVisible(false);
                edit.setVisible(false);
                jScrollPane2.setVisible(false);
                noRes1.setVisible(true);
                noRes2.setVisible(true);
                list1.setVisible(false);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        list1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        noRes1 = new javax.swing.JLabel();
        noRes2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        edit = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel4.setText("Your current reservation:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 210, 170, 20);

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
        jScrollPane2.setBounds(10, 240, 280, 100);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("Current Reservation");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(50, 90, 200, 30);

        noRes1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        noRes1.setText("current reservation.");
        jPanel1.add(noRes1);
        noRes1.setBounds(70, 330, 170, 70);

        noRes2.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        noRes2.setText("You don't have any");
        jPanel1.add(noRes2);
        noRes2.setBounds(70, 300, 160, 60);

        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9);
        jLabel9.setBounds(240, 600, 40, 30);

        edit.setBackground(new java.awt.Color(255, 255, 255));
        edit.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        jPanel1.add(edit);
        edit.setBounds(10, 460, 75, 29);

        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("To edit: select Reserve Id, then click edit");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 440, 260, 16);

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

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/back.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel8);
        jLabel8.setBounds(0, 0, 50, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/tenant.jpeg"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 300, 650);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addGap(0, 0, 0))
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

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // BBAACCCCKKKKKK
        TenantPage_Home ob = new TenantPage_Home();
        ob.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void list1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list1MouseClicked

    }//GEN-LAST:event_list1MouseClicked
/**
 * this method will check if the tenant select the reserved ID(by the Column number) 
 * if so it will open editHall interface, if not it will show a message to tenant to select the reserve ID
 * @param evt 
 */
    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
        try {
            if (list1.getSelectedColumn() >= 1) {
                JOptionPane.showMessageDialog(null, "please choose the ReserveId");
            } else {
                int index = list1.getSelectedRow();
                int idReserve = (int) list1.getValueAt(index, 0);
                TenantPage_EditRes obj = new TenantPage_EditRes(idReserve);
                obj.setVisible(true);
                this.setVisible(false);
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "to edit choose a reservation first");
        }
    }//GEN-LAST:event_editActionPerformed

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
            java.util.logging.Logger.getLogger(TenantPage_Current.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TenantPage_Current.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TenantPage_Current.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TenantPage_Current.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TenantPage_Current().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton edit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable list1;
    private javax.swing.JLabel noRes1;
    private javax.swing.JLabel noRes2;
    // End of variables declaration//GEN-END:variables
}
