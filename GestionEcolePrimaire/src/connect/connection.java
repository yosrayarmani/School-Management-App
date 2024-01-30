package connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class connection { 
	Connection con;
	public connection()
	{
		try {
			Class.forName("org.postgresql.Driver"); 
			System.out.println("Driver O.K.");
			
			con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ecole","postgres","pgsql");
			System.out.println("connection établie");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Connection etablirconnection() {
		return con;
	}
	//test connection
	/*public static void main(String[] args) {
		
		connection p=new connection();
	
		System.out.println(p.etablirconnection());
	} */
	
	}
	

