package project_305;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class User {

    public String Fname;
    public String Lname;
    public String email;
    public String password;
    public String Cpassword;
    public String Phone_number;


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

    public void createAccount(User user, boolean checkOwner) {

        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String ConnectionURL = "jdbc:mysql://localhost:3306/weddinghallreservation";

            connection = DriverManager.getConnection(ConnectionURL, "root", "1212");

            Statement statement = connection.createStatement();
            if (checkOwner) {
                String query = "insert into OWNER (firstname,lastname,Email,PhoneNumber,Password) values ('" + user.getFname() + "','" + user.getLname() + "','" + user.getEmail() + "','" + user.getPhone_number() + "','" + user.getPassword() + "')";

                statement.executeUpdate(query);
                String queryID = "Select idOwner from Owner Where Email =" + "'" + user.getEmail() + "'";

                ResultSet r = statement.executeQuery(queryID);
                r.next();
                JOptionPane.showMessageDialog(null, "The Owner is Added Successfully \n your ID is " + r.getInt(1));

            } else {
                String query = "insert into TENANT (firstname,lastname,Email,PhoneNumber,Password)  values ('" + user.getFname() + "','" + user.getLname() + "','" + user.getEmail() + "','" + user.getPhone_number() + "','" + user.getPassword() + "')";

                statement.executeUpdate(query);

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

    public void updateAccount(User user, String id) throws ClassNotFoundException, SQLException {
        
        Connection connection = null;

        Class.forName("com.mysql.cj.jdbc.Driver");
        String ConnectionURL = "jdbc:mysql://localhost:3306/weddinghallreservation";
        connection = DriverManager.getConnection(ConnectionURL, "root", "1212");

        PreparedStatement ps = null;
        try {
            if (id.startsWith("12")) {            
                
                ps = connection.prepareStatement("update  Owner set FirstName=?, lastName=?, Email=?, PhoneNumber=?, Password=? where idOwner=" + id + " ");
                ps.setString(1, user.getFname());
                ps.setString(2, user.getLname());
                ps.setString(3, user.getEmail());
                ps.setString(4, user.getPhone_number());
                ps.setString(5, user.getPassword());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "The information updated successfully");
            } else {
                
                ps = connection.prepareStatement("update  tenant set FirstName=?, lastName=?, Email=?, PhoneNumber=?, Password=? where idtenant=" + id + " ");
                ps.setString(1, user.getFname());
                ps.setString(2, user.getLname());
                ps.setString(3, user.getEmail());
                ps.setString(4, user.getPhone_number());
                ps.setString(5, user.getPassword());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "The information updated successfully");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
