package connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn { 
    private Connection con;

    public Conn() {
        try {
            Class.forName("org.postgresql.Driver"); 
            System.out.println("Driver O.K.");
            
            // Initialize the database connection
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ecole", "postgres", "pgsql");
            System.out.println("Connection established");
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Expose the connection to other classes
    public Connection etablirconnection() {
        return con;
    }
}
