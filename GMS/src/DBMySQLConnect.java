import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBMySQLConnect 
{
	public static Connection getMySQLConnection()
    {
   	   Connection mysqlconnection = null;
		
       try 
       {
    		//STEP 1 LOAD DRIVER CLASS
    	   Class.forName("com.mysql.cj.jdbc.Driver");
    	   
    	   //STEP 2
    	   mysqlconnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gms","root","Root@123");
    	      
    	   System.out.println("DATABASE CONNECTION SUCCESS.....");
       }catch (ClassNotFoundException e) {e.printStackTrace();}
        catch (SQLException e) {e.printStackTrace();}
       
       if (mysqlconnection != null)
    	   return mysqlconnection;
       else
       {
    	   System.out.println("DB CONNECTION ERROR SO TERMINATE THE APPLICATION");
    	   System.exit(0);
    	   return null;
       }
	
    }
}