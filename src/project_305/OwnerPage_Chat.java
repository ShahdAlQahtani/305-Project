/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_305;

import java.io.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shahad
 */
public class OwnerPage_Chat extends javax.swing.JFrame {

    static DataOutputStream dos;
    static DataInputStream dis;

    int port;
    ServerSocket server = null;
    static Socket client = null;
    ExecutorService pool = null;
    int clientCount = 0;

    public OwnerPage_Chat() {
        initComponents();
        setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        msgArea = new javax.swing.JTextArea();
        SendingMsg = new javax.swing.JTextField();
        send = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 610, 35, 35);

        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3);
        jLabel3.setBounds(90, 610, 36, 40);

        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4);
        jLabel4.setBounds(170, 610, 37, 38);

        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5);
        jLabel5.setBounds(240, 610, 40, 30);

        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6);
        jLabel6.setBounds(0, 0, 50, 30);

        msgArea.setColumns(20);
        msgArea.setRows(5);
        jScrollPane1.setViewportView(msgArea);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 250, 240, 210);
        jPanel1.add(SendingMsg);
        SendingMsg.setBounds(30, 470, 240, 30);

        send.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        send.setText("Send");
        send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendActionPerformed(evt);
            }
        });
        jPanel1.add(send);
        send.setBounds(110, 520, 60, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project_305/‏‏chat_O.png"))); // NOI18N
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

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        OwnerPage_Home ob = new OwnerPage_Home();
        ob.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        OwnerPage_ViewReq ob = new OwnerPage_ViewReq();
        ob.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        OwnerPage_Comment ob = new OwnerPage_Comment();
        ob.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        OwnerPage_Profile ob = null;
        try {
            ob = new OwnerPage_Profile();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(OwnerPage_Chat.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        ob.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // BBAACCCCKKKKKK
        OwnerPage_ViewReq ob = new OwnerPage_ViewReq();
        ob.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed
        // TODO add your handling code here:
        try {
            String msg = "";
            dos = new DataOutputStream(client.getOutputStream());
            msg = SendingMsg.getText();
            dos.writeUTF(msg);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_sendActionPerformed

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
            java.util.logging.Logger.getLogger(OwnerPage_Chat.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OwnerPage_Chat.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OwnerPage_Chat.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OwnerPage_Chat.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OwnerPage_Chat().setVisible(true);
            }
        });

        OwnerPage_Chat serverobj = new OwnerPage_Chat(1201);
        serverobj.startServer();
    }

    OwnerPage_Chat(int port) {
        this.port = port;
        pool = Executors.newFixedThreadPool(10);
    }

    public void startServer() throws IOException {

        server = new ServerSocket(1201);

        while (true) {
            client = server.accept();
            clientCount++;
            ServerThread thread = new ServerThread(client, clientCount, this);
            pool.execute(thread);
        }

    }

    private static class ServerThread extends Thread {

        OwnerPage_Chat server = null;
        Socket client = null;

        int id;
        String s;

        ServerThread(Socket client, int count, OwnerPage_Chat server) throws IOException {

            this.client = client;
            this.server = server;
            this.id = count;
            msgArea.setText("Connection " + id + "established with client " + client);

            dis = new DataInputStream(client.getInputStream());
            dos = new DataOutputStream(client.getOutputStream());

        }

        @Override
        public void run() {
            int x = 1;
            try {
                while (true) {
                    s = dis.readUTF();
                    msgArea.setText(msgArea.getText() + "\n Server:  " + "Client(" + id + ") :" + s);

                
                    s = dis.readUTF();
                    if (s.equalsIgnoreCase("bye")) {
                        msgArea.setText("BYE");
                        x = 0;
                        msgArea.setText("Connection ended by server");
                        break;
                    }
                    msgArea.setText(s);
                }

                dis.close();
                client.close();
                dos.close();
                if (x == 0) {
                    msgArea.setText("Server cleaning up.");
                    System.exit(0);
                }
            } catch (IOException ex) {
                System.out.println("Error : " + ex);
            }
        }
    }
//        ServerSocket s = new ServerSocket(1201);
//        System.out.println("Server waiting Connection...");
//
//        while (true) {
//            client = s.accept();
//            MyThread m = new MyThread(client);
//            m.start();
//        }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField SendingMsg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextArea msgArea;
    private javax.swing.JButton send;
    // End of variables declaration//GEN-END:variables
}

//class MyThread extends Thread {
//
//    static ServerSocket serverSocket;
//    static Socket socket;
//    static DataInputStream dis;
//    static DataOutputStream dos;
//
//    public MyThread(Socket soc) {
//        this.socket = soc;
//    }
//
//    @Override
//    public void run() {
//
//        String msgin = "";
//
//        try {
//
//            dis = new DataInputStream(socket.getInputStream());
//            dos = new DataOutputStream(socket.getOutputStream());
//            while (!msgin.equalsIgnoreCase("Bye")) {
//                msgin = dis.readUTF();
//                OwnerPage_Chat.msgArea.setText(OwnerPage_Chat.msgArea.getText() + "\n" + msgin);
//            }
//            socket.close();
//        } catch (Exception ex) {
//            Logger.getLogger(OwnerPage_Chat.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//}
