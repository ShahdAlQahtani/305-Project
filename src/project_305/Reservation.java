/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_305;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author karam
 */
public class Reservation {

    int idTenant;
    int idHall;
    Date reserveDate;
    String Payment;

    public int getIdTenant() {
        return idTenant;
    }

    public int getIdHall() {
        return idHall;
    }

    public Date getReserveDate() {
        return reserveDate;
    }

    public String getPayment() {
        return Payment;
    }

    public void setIdTenant(int idTenant) {
        this.idTenant = idTenant;
    }

    public void setIdHall(int idHall) {
        this.idHall = idHall;
    }

    public void setReserveDate(Date reserveDate) {
        this.reserveDate = reserveDate;
    }

    public void setPayment(String Payment) {
        this.Payment = Payment;
    }

    public ResultSet checkDateForRes(int id, Date date) throws SQLException {
        Connection connection = null;
        String ConnectionURL = "jdbc:mysql://localhost:3306/weddinghallreservation";
        PreparedStatement q;
        connection = DriverManager.getConnection(ConnectionURL, "root", "1212");

        String query = "Select idReserve from `Reservation` where idHallinfo='" + id + "' and resDate='" + date + "'";
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery(query);
        return rs;
    }
    
    public void confirmAndPrintInvoic(int id, int Hid,Reservation res) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException{
         
            Class.forName("com.mysql.cj.jdbc.Driver");

            String ConnectionURL = "jdbc:mysql://localhost:3306/weddinghallreservation";
            PreparedStatement q;
            Connection connection = DriverManager.getConnection(ConnectionURL, "root", "1212");

            String queryT = "Select `firstname`, `Email` from `Tenant` where  `idTenant` ='" +id + "' ";
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(queryT);
            
            File file= new File("invoice.txt");
            PrintWriter fr= new PrintWriter(file);
            
            
            fr.println("|——————————INVOICE—————————-——|");
            fr.println("|                                                                                  |");
            fr.println("|———————WEDDING HALL SYSTEM———————|");
            fr.println("|                                                                                  |");
            fr.println("|--------------------------------------------|");
            fr.println("|                                                                                  |");
           
           
            while (rs.next()) {
                String name= rs.getString(1);
                String email= rs.getString(2);
            fr.printf("| Tenant Info:        Name:%-39s|\n", name);
            fr.printf("|                            Email:%-38s|\n", email);
            }
            
            fr.println("|                                                                                  |");
            
            String queryH = "Select `Hallname`, `Hallcapacity`, `HallPrice` from `hallinfo` where `idHallInfo`='" + Hid + "' ";
            Statement stmH = connection.createStatement();
            ResultSet rsH = stmH.executeQuery(queryH);

            if (rsH.next()) {
            fr.printf("| Reservation Info:  Hall Name: %-31s|\n", rsH.getString(1));
            fr.printf("|                            Capacity:%-37d|\n", rsH.getInt(2));
            fr.printf("|                            Price:%-41d|\n", rsH.getInt(3));
            }
            
            fr.printf("|                            Date:%-36s|\n", res.getReserveDate().toString());
            
           
            
            if (res.getPayment().equals("0")) {
                fr.printf("|                            Payment Method:%-24s|\n", "Cash");
            } else {
                fr.printf("|                            Payment Method:%-24s|\n", "Cridit card");
            }
            

            
            fr.close();
           // fr.flush();
            Desktop desktop = Desktop.getDesktop();
            if(file.exists()) desktop.open(file);
    }
}
