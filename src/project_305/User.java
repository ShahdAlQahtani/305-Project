package project_305;

import java.sql.*;
import javax.swing.*;

public class User {

    public String Fname;
    public String Lname;
    public String email;
    public String password;
    public String Cpassword;
    public String Phone_number;

    /*
    setter and getter for all varible of class hall information
     */
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

    /**
     * This method for creating Account for the users and store theirinformation in the database
     * @param user we pass object of User that store the information entered by user from Signup interface
     * user
     * @param checkOwner boolean value that specifies whether the user is an
     * Owner or Tenant
     */
    public void createAccount(User user, boolean checkOwner) {

        Connection connection = null;
        try {
            // connection to dataBase
            Class.forName("com.mysql.cj.jdbc.Driver");

            String ConnectionURL = "jdbc:mysql://localhost:3306/weddinghallreservation";

            connection = DriverManager.getConnection(ConnectionURL, "root", "1212");

            Statement statement = connection.createStatement();
            // if the checkOwner is true that mean user is Owner 
            if (checkOwner) {

                // insert statment for adding Owner information in the table of Owner in the dataBase
                String query = "insert into OWNER (firstname,lastname,Email,PhoneNumber,Password) values ('" + user.getFname() + "','" + user.getLname() + "','" + user.getEmail() + "','" + user.getPhone_number() + "','" + user.getPassword() + "')";
                statement.executeUpdate(query);

                // to get id of the Owner that is generate automatically (starts from 1200 and increases with the addition of each user) from database
                String queryID = "Select idOwner from Owner Where Email =" + "'" + user.getEmail() + "'";
                ResultSet r = statement.executeQuery(queryID);
                r.next();
                JOptionPane.showMessageDialog(null, "The Owner is Added Successfully \n your ID is " + r.getInt(1));

            } else { // checkowner is false that mean user is Tenant

                // insert statment for adding Tenant information in the table of Tenant in the dataBase
                String query = "insert into TENANT (firstname,lastname,Email,PhoneNumber,Password)  values ('" + user.getFname() + "','" + user.getLname() + "','" + user.getEmail() + "','" + user.getPhone_number() + "','" + user.getPassword() + "')";
                statement.executeUpdate(query);

                // to get id of the Owner that is generate automatically (starts from 1400 and increases with the addition of each user) from database
                String queryID = "Select idtenant from Tenant Where Email =" + "'" + user.getEmail() + "'";
                ResultSet r = statement.executeQuery(queryID);
                r.next();
                JOptionPane.showMessageDialog(null, "The Tenant is Added Successfully \n your ID is" + r.getInt(1));
            }

            connection.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method for updating Account information for users ans save the update in the database
     * @param user  pass object of User that store the information entered by user from OwnerPage_EditPro and TenantPage_EditProfile interfaces
     * @param id for the user that we want to update
     */
    public void updateAccount(User user, String id) {

        Connection connection = null;
        try {
            // connection to dataBase
            Class.forName("com.mysql.cj.jdbc.Driver");
            String ConnectionURL = "jdbc:mysql://localhost:3306/weddinghallreservation";
            connection = DriverManager.getConnection(ConnectionURL, "root", "1212");

            PreparedStatement ps = null;
         // check if the user who wants to update his information is Owner or Tenant
         
            if (id.startsWith("12")) { //To check the beginning of ID number, since the ID of Owner start with the number 12

                 // update statment for updating Owner information in the table of Owner in the dataBase
                ps = connection.prepareStatement("update  Owner set FirstName=?, lastName=?, Email=?, PhoneNumber=?, Password=? where idOwner=" + id + " ");
                ps.setString(1, user.getFname());
                ps.setString(2, user.getLname());
                ps.setString(3, user.getEmail());
                ps.setString(4, user.getPhone_number());
                ps.setString(5, user.getPassword());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "The information updated successfully");
            } else {

                 // update statment for updating Tenant information in the table of Tenant in the dataBase
                ps = connection.prepareStatement("update  tenant set FirstName=?, lastName=?, Email=?, PhoneNumber=?, Password=? where idtenant=" + id + " ");
                ps.setString(1, user.getFname());
                ps.setString(2, user.getLname());
                ps.setString(3, user.getEmail());
                ps.setString(4, user.getPhone_number());
                ps.setString(5, user.getPassword());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "The information updated successfully");
            }
            connection.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
