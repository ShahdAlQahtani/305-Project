/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_305;

import java.io.*;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author shahad
 */
public class TenantPage_Chat extends javax.swing.JFrame {

    DataOutputStream dos;
    DataInputStream dis;
    Socket socket;

    public TenantPage_Chat() {
        initComponents();
        setLocationRelativeTo(null);
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_area = new javax.swing.JTextArea();
        txt = new javax.swing.JTextField();
        send = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel8);
        jLabel8.setBounds(0, 0, 50, 30);

        jLabel1.setText("Client");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(130, 130, 40, 20);

        txt_area.setColumns(20);
        txt_area.setRows(5);
        jScrollPane2.setViewportView(txt_area);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(30, 240, 240, 210);
        jPanel1.add(txt);
        txt.setBounds(30, 460, 200, 30);

        send.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/send m.png"))); // NOI18N
        send.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sendMouseClicked(evt);
            }
        });
        jPanel1.add(send);
        send.setBounds(240, 460, 30, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\shood\\Documents\\NetBeansProjects\\project-305\\src\\Image\\chat_T.png")); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 300, 650);

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
        TenantPage_Hallinfo ob = new TenantPage_Hallinfo();
        ob.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void sendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendMouseClicked
        // TODO add your handling code here:
        try {

            socket = new Socket(Server.ip, Server.portNumber);
            dos = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
            ReceiverThread rt = new ReceiverThread(this, dos, dis);
        } catch (IOException ex) {
            ex.getMessage();
        }

        try {

            String str = txt.getText();
            dos.writeUTF(str);

            if (str.trim().equalsIgnoreCase("BYE")) {

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_sendMouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        TenantPage_Home ob = new TenantPage_Home();
        ob.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        TenantPage_Search ob;

        ob = new TenantPage_Search();
        ob.setVisible(true);
        this.setVisible(false);

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

        ob = new TenantPage_profile();
        ob.setVisible(true);
        this.setVisible(false);
        ob.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_jLabel9MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {
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
            java.util.logging.Logger.getLogger(TenantPage_Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TenantPage_Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TenantPage_Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TenantPage_Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TenantPage_Chat().setVisible(true);
            }
        });
    }

    public class ReceiverThread extends Thread {

        TenantPage_Chat tenantChat;
        DataOutputStream dos;
        DataInputStream dis;

        ReceiverThread(TenantPage_Chat chat, DataOutputStream dos, DataInputStream dis) {

            this.tenantChat = chat;
            this.dos = dos;
            this.dis = dis;
            start();

        }

        public void run() {

            try {

                String str = dis.readUTF();
                tenantChat.txt_area.append("Server: " + str + "\n");

                socket.close();
                dis.close();
                dos.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel send;
    private javax.swing.JTextField txt;
    private javax.swing.JTextArea txt_area;
    // End of variables declaration//GEN-END:variables
}
