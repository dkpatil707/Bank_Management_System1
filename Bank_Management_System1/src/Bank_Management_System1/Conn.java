package Bank_Management_System1;

import java.sql.*;  

public class Conn{
    Connection c;
    Statement s;
    public Conn(){  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            
            c= DriverManager.getConnection("jdbc:mysql:///Bank_Management_System1","root","Sql1234");
            
            s= c.createStatement();
             
		}catch(Exception e ) {
			System.out.println(e);
		}
	}
	

}
