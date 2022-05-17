package Helper;

import java.sql.Connection;
//import java.sql.Driver;
import java.sql.DriverManager;
//import java.sql.SQLException;

public class DBConnection {

	Connection c = null;
	
	public DBConnection() {}

	public Connection DBCon() {
        
       try {
    	   this.c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ticketix", "postgres", "3241");
    	  // this.c = DriverManager.getConnection("jdbc:mysql://localhost/otomasyon", "root", "");

    	   return c;
       } 
       catch (Exception e) {
    	   // TODO: handle exception
       }
        return c;
    }
}
