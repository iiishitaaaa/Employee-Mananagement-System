package employee.management.system.java;

import java.sql.*;

public class Connect {
    
    Connection c;
    Statement s;
    
    public Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///employee_management_system", "root", "Sayam@123");
            s = c.createStatement();
        } catch(Exception e) {
            e.printStackTrace();
        }
    } 
}
