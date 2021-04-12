
package project_305;

import java.io.*;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 * This class create an object for each hall and store its all information
 * @author Group1_CAR
 */
public class HallInformation {
    // parameter for class Hall Information
    
    public String hallName;
    public String hallAddress;
    public int Capacity;
    public String hallcontactNum;
    public double Hallprice;
    public String Image;
    public InputStream image1;
   /*
    setter and getter for all varible of class hall information
    */
    
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

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int Capacity) {
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
    
    public String getImage() {
        return Image;
    }
    
    public void setImage(String Image) {
        this.Image = Image;
    }

    public void setImage1(InputStream image1) {
        this.image1 = image1;
    }

    public InputStream getImage1() {
        return image1;
    }
    
    /**
     * This method working on inserting the hall information to DataBase
     * @param info we pass object of hallInformation that store the information entered by user
     */
    public void CreateNewHall(HallInformation info) {
        Connection connection = null;
        
        try { 
            // connection to dataBase
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String ConnectionURL = "jdbc:mysql://localhost:3306/weddinghallreservation";

            connection = DriverManager.getConnection(ConnectionURL, "root", "1212");
            // to read the file path of image                                             
            InputStream in = new FileInputStream(new File(info.getImage()));
            
            // Insert statment for store the information of the hall (Name,capacity,address,price,contact number ,the owner of the hall,image) into the table hallinfo in the database 
            PreparedStatement ps = connection.prepareStatement("insert into hallinfo (hallname,hallcapacity,halladdress,hallPrice,contactNumber,idOwner,image) values(?,?,?,?,?,?,? )");
            ps.setString(1, info.getHallName());
            ps.setInt(2, info.getCapacity());
            ps.setString(3, info.getHallAddress());
            ps.setDouble(4, info.getHallprice());
            ps.setString(5, info.getHallcontactNum());
            ps.setInt(6, Integer.parseInt(Login.Id));
            ps.setBlob(7, in); 
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "The Hall ("+info.getHallName()+") was Added Successfully ");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * This method working on updating the hall information in Database
     * @param info we pass object of hallInformation that store the information entered by user
     * @param Hallid id for the hall that we want to update
     */ 
    public void editHall(HallInformation info ,int Hallid) {
        Connection connection = null;
        
        try {
             // connection to dataBase
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String ConnectionURL = "jdbc:mysql://localhost:3306/weddinghallreservation";

            connection = DriverManager.getConnection(ConnectionURL, "root", "1212");
            
              
            
            // update statment for updating iformation hall (Name,capacity,address,price,contact number ,the owner of the hall,image) into the table hallinfo in the database 
            PreparedStatement ps = connection.prepareStatement("update hallinfo set HallName=?, hallcapacity=?, HallAddress=?, Hallprice=?, contactNumber=?, image=? where idHallInfo="+Hallid);
       
            ps.setString(1, info.getHallName());
            ps.setInt(2, info.getCapacity());
            ps.setString(3, info.getHallAddress());
            ps.setDouble(4, info.getHallprice());
            ps.setString(5, info.getHallcontactNum()); 
            
            if(info.getImage()!=null){
                // to read the file path of image 
              InputStream in = new FileInputStream(new File(info.getImage()));
              ps.setBlob(6, in);
            }else{
                ps.setBlob(6, info.getImage1());
            }
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Hall " + info.getHallName() + " is updated Successfully");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
