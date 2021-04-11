
package project_305;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import javax.swing.JOptionPane;

public class HallInformation {
    public int idHallinfo;
    public String hallName;
    public String hallAddress;
    public int Capacity;
    public String hallcontactNum;
    public double Hallprice;
    public String Image;
    public InputStream Bimage;

    public int getIdHallinfo() {
        return idHallinfo;
    }

    public void setIdHallinfo(int idHallinfo) {
        this.idHallinfo = idHallinfo;
    }
    
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

    public InputStream getBimage() {
        return Bimage;
    }

    public void setBimage(InputStream Bimage) {
        this.Bimage = Bimage;
    }
    
    public void CreateNewHall(HallInformation info) {
        Connection connection = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String ConnectionURL = "jdbc:mysql://localhost:3306/weddinghallreservation";

            connection = DriverManager.getConnection(ConnectionURL, "root", "1212");
            
            InputStream in = new FileInputStream(new File(info.getImage()));
            
            PreparedStatement ps = connection.prepareStatement("insert into hallinfo (hallname,hallcapacity,halladdress,hallPrice,contactNumber,idOwner,image) values(?,?,?,?,?,?,? )");
            ps.setString(1, info.getHallName());
            ps.setInt(2, info.getCapacity());
            ps.setString(3, info.getHallAddress());
            ps.setDouble(4, info.getHallprice());
            ps.setString(5, info.getHallcontactNum());
            ps.setInt(6, Integer.parseInt(Login.Id));
            ps.setBlob(7, in); 
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "The Hall was Added Successfully ");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void editHall(HallInformation info ,int Hallid) {
        Connection connection = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String ConnectionURL = "jdbc:mysql://localhost:3306/weddinghallreservation";

            connection = DriverManager.getConnection(ConnectionURL, "root", "1212");
            
         //   InputStream in = new FileInputStream(new File(info.getImage()));
            
            PreparedStatement ps = connection.prepareStatement("update hallinfo set HallName=?, hallcapacity=?, HallAddress=?, Hallprice=?, contactNumber=?, image=? where idHallInfo="+Hallid);
       
            ps.setString(1, info.getHallName());
            ps.setInt(2, info.getCapacity());
            ps.setString(3, info.getHallAddress());
            ps.setDouble(4, info.getHallprice());
            ps.setString(5, info.getHallcontactNum()); 
           // ps.setBlob(6, in);
            
            if(info.getImage()!=null){
                InputStream in = new FileInputStream(new File(info.getImage()));
            ps.setBlob(6, in);}
            else
                ps.setBlob(6, info.getBimage());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Hall " + info.getHallName() + " is updated Successfully");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
