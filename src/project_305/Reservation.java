
package project_305;

import java.awt.Desktop;
import java.io.*;
import java.sql.*;
/**
 * This is the reservation class create an object for the resercation process and stor its info 
 * @author karam
 */
public class Reservation {

    // parameter for class Reservation 
    int idTenant;
    int idHall;
    Date reserveDate;
    String Payment;
    
    //setter and getter
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
    /**
     * this metohd check if there is a reservation on same date and hall the tenant want
     * @param id hall id selected by tenant 
     * @param date date selected by tenant 
     * @return a ResultSet
     * @throws SQLException this method may throw a SQL Exception 
     */
    
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
    /**
     * this method Print Invoic in a file 
     * @param id tenant id
     * @param Hid  hall id
     * @param res object has the reservation detsils
     * @throws ClassNotFoundException this method may throw an Exception of this type
     * @throws SQLException or this type
     * @throws FileNotFoundException or this 
     * @throws IOException or this
     */
    public void confirmAndPrintInvoic(int id, int Hid, Reservation res) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String ConnectionURL = "jdbc:mysql://localhost:3306/weddinghallreservation";
        PreparedStatement q;
        Connection connection = DriverManager.getConnection(ConnectionURL, "root", "1212");
        //retreive some tenant's information
        String queryT = "Select `firstname`, `Email` from `Tenant` where  `idTenant` ='" + id + "' ";
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery(queryT);

        File file = new File("invoice.txt");
        PrintWriter fr = new PrintWriter(file);

        fr.printf("%-23s%-7s%23s\n", "|---------------------", "INVOICE", "---------------------|");
        fr.printf("%-46s%7s\n", "|", "|");
        fr.printf("%-17s%-19s%17s\n", "|", "WEDDING HALL SYSTEM", "|");
        fr.printf("%-46s%7s\n", "|", "|");
        fr.printf("%-50s\n", "|---------------------------------------------------|");
        fr.printf("%-46s%7s\n", "|", "|");

        while (rs.next()) {
            String name = rs.getString(1);
            String email = rs.getString(2);
            fr.printf("%-23s%-6s%-17s%7s\n", "| Tenant Info:", "Name:", name, "|");
            fr.printf("%-23s%-7s%-20s%3s\n", "|", "Email:", email, "|");
        }

        fr.printf("%-46s%7s\n", "|", "|");
        //retreive some hall's information
        String queryH = "Select `Hallname`, `Hallcapacity`, `HallPrice` from `hallinfo` where `idHallInfo`='" + Hid + "' ";
        Statement stmH = connection.createStatement();
        ResultSet rsH = stmH.executeQuery(queryH);

        if (rsH.next()) {
            fr.printf("%-23s%-11s%-17s%2s\n", "| Reservation Info:", "Hall Name:", rsH.getString(1), "|");
            fr.printf("%-23s%-10s%-17s%3s\n", "|", "Capacity:", rsH.getInt(2), "|");
            fr.printf("%-23s%-7s%-17s%6s\n", "|", "Price:", rsH.getInt(3), "|");
        }

        fr.printf("%-23s%-6s%-17s%7s\n", "|", "Date:", res.getReserveDate().toString(), "|");

        if (res.getPayment().equals("Cash")) {
            fr.printf("%-23s%-16s%-11s%3s\n", "|", "Payment Method:", "Cash", "|");
        } else {
            fr.printf("%-23s%-16s%-11s%3s\n", "|", "Payment Method:", "Credit card", "|");
        }
        
        fr.printf("%-46s%7s\n", "|", "|");
        fr.printf("%-50s\n", "|---------------------------------------------------|");
        //colse the file 
        fr.close();
  
        Desktop desktop = Desktop.getDesktop();
        if (file.exists()) {
            desktop.open(file);
        }
    }
}
