package project_305;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Ameera
 */
public class User {

    public String Fname;
    public String Lname;
    public String email;
    public String password;
    public String Cpassword;
    public String Phone_number;
    
    public boolean type = false;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpassword() {
        return Cpassword;
    }

    public void setCpassword(String Cpassword) {
        this.Cpassword = Cpassword;
    }

    public String getPhone_number() {
        return Phone_number;
    }

    public void setPhone_number(String Phone_number) {
        this.Phone_number = Phone_number;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public void createAccount(User user, boolean checkOwner) {

        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String ConnectionURL = "jdbc:mysql://localhost:3306/weddinghallreservation";

            connection = DriverManager.getConnection(ConnectionURL, "root", "Ameera");
//            connection = DriverManager.getConnection(ConnectionURL, "root", "Ameera");
//            connection = DriverManager.getConnection(ConnectionURL, "root", "Ameera");
//            connection = DriverManager.getConnection(ConnectionURL, "root", "Ameera");

            Statement statement = connection.createStatement();
            if (checkOwner) {
                String query = "insert into OWNER (firstname,lastname,Email,PhoneNumber,Password) values ('" + user.getFname() + "','" + user.getLname() + "','" + user.getEmail() + "','" + user.getPhone_number() + "','" + user.getPassword() + "')";

                statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "The Owner is Added Successfully \n your ID is " );

            } else {
                String query = "insert into TENANT (firstname,lastname,Email,PhoneNumber,Password) TENANT values ('" + user.getFname() + "','" + user.getLname() + "','" + user.getEmail() + "','" + user.getPhone_number() + "','" + user.getPassword() + "')";
                statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "The Tenant is Added Successfully \n your ID is" );
            }
            connection.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}