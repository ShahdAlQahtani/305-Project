/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_305;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Ameera
 */
public class HallInformation {

    public String hallName;

    public String hallAddress;

    public String Capacity;

    public String hallcontactNum;

    public double Hallprice;
    public String Image;

    public String OwnerId;

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public String getHallAddress() {
        return hallAddress;
    }

    public void setHallAddress(String hallAddress) {
        this.hallAddress = hallAddress;
    }

    public String getCapacity() {
        return Capacity;
    }

    public void setCapacity(String Capacity) {
        this.Capacity = Capacity;
    }

    public String getHallcontactNum() {
        return hallcontactNum;
    }

    public void setHallcontactNum(String hallcontactNum) {
        this.hallcontactNum = hallcontactNum;
    }

    public double getHallprice() {
        return Hallprice;
    }

    public void setHallprice(double Hallprice) {
        this.Hallprice = Hallprice;
    }

    public String getOwnerId() {
        return OwnerId;
    }

    public void setOwnerId(String OwnerId) {
        this.OwnerId = OwnerId;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public void CreateNewHall(HallInformation info) {
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String ConnectionURL = "jdbc:mysql://localhost:3306/weddinghallreservation";

         // connection = DriverManager.getConnection(ConnectionURL, "root", "Ameera");
              connection = DriverManager.getConnection(ConnectionURL, "root", "1212");
            
            InputStream in = new FileInputStream(new File(info.getImage()));
            PreparedStatement ps = connection.prepareStatement("insert into hallinfo (hallname,hallcapacity,halladdress,hallPrice,contactNumber,image) values(?,?,?,?,?,? )");
            ps.setString(1, info.getHallName());
            ps.setString(2, info.getCapacity());
            ps.setString(3, info.getHallAddress());
            ps.setDouble(4, info.getHallprice());
            ps.setString(5, info.getHallcontactNum());
            ps.setBlob(6, in);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "The Hall was Added Successfully ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
        public void updateHall(HallInformation info) {
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String ConnectionURL = "jdbc:mysql://localhost:3306/weddinghallreservation";

         // connection = DriverManager.getConnection(ConnectionURL, "root", "Ameera");
            connection = DriverManager.getConnection(ConnectionURL, "root", "1212");
            
            InputStream in = new FileInputStream(new File(info.getImage()));
            PreparedStatement ps = connection.prepareStatement("insert into hallinfo (hallname,hallcapacity,halladdress,hallPrice,contactNumber,image) values(?,?,?,?,?,? )");
            ps.setString(1, info.getHallName());
            ps.setString(2, info.getCapacity());
            ps.setString(3, info.getHallAddress());
            ps.setDouble(4, info.getHallprice());
            ps.setString(5, info.getHallcontactNum());
            ps.setBlob(6, in);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "The Hall was Added Successfully ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
