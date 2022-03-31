package healin.DAO;

import java.text.*;
import java.util.*;
import java.sql.*;
import healin.connection.ConnectionManager;
import healin.model.Staff;

public class LoginStaffDAO {
    static Connection currentCon = null;
    static ResultSet rs = null;

    public static Staff login(Staff staff) {

        // preparing some objects for connection
        System.out.println("JIJIJI");
        Statement stmt = null;

        String username = staff.getUsername();
        String password = staff.getPassword();

        String searchQuery = "select * from staff where username ='" + username + "' AND password='" + password + "'";

        // "System.out.println" prints in the console; Normally used to trace the process
      
        System.out.println("Query: " + searchQuery);

        try {
            // connect to DB
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();

            // if user does not exist set the isValid variable to false
            if (!more) {
                System.out.println("Sorry, you are not a registered user! Please sign up first");
                staff.setValid(false);
            }

            // if user exists set the isValid variable to true
            else if (more) {
                staff.setValid(true);
            }
        }

        catch (Exception ex) {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        }

        // some exception handling
        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                }
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                }
                stmt = null;
            }

            if (currentCon != null) {
                try {
                    currentCon.close();
                } catch (Exception e) {
                }

                currentCon = null;
            }
        }

        return staff;

    }
}