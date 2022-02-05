import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;

/*
create table logindetails
(
   userid varchar(20),
   password varchar(15)
);

insert into logindetails(userid,password) values('admin','pass');


create table userdetails
(
    name varchar(25),
    email varchar(25),
    mobile varchar(25),
    address varchar(25),
    city varchar(25),
    gender varchar(25),
    interests varchar(25),
    dob varchar(25)
);
*/

public class BackEndForDBOperation 
{
	public boolean loginCheck(String uid, String pass)
	{
	   PreparedStatement pst =null;
	   ResultSet rs = null;
	   Connection mysqlconnection = null;
	   
	   boolean status = false;
	   
	   try
	   {
		  mysqlconnection = DBMySQLConnect.getMySQLConnection();
		   	   
	      String logincheckquery = "select * from logindetails where userid=? and password=?";
		  	   
		  pst = mysqlconnection.prepareStatement(logincheckquery);
		  pst.setString(1, uid);
		  pst.setString(2, pass);
				   
		  rs = pst.executeQuery();
			
		  if(rs.next())
		  {
			status= true;
		  }
		}catch(SQLException e) 
		 {
		     e.printStackTrace();
		   	 //System.out.println("Can't Insert Record - Database Problem");
		 }
		 finally 
		 {
		    try 
		    {
			   if (pst != null)
			      pst.close();
			   if(rs != null)
				  rs.close();
			   if(mysqlconnection != null)
			      mysqlconnection.close();
			} catch (SQLException e) {e.printStackTrace();}
		  } 	
		  
		  return status;
     }
	
	public boolean idCheck(String id)
	{
	   PreparedStatement pst =null;
	   ResultSet rs = null;
	   Connection mysqlconnection = null;
	   
	   boolean status = false;
	   
	   try
	   {
		  mysqlconnection = DBMySQLConnect.getMySQLConnection();
		   	   
	      String idcheckquery = "select * from memberDetails where id=?";
		  	   
		  pst = mysqlconnection.prepareStatement(idcheckquery);
		  pst.setString(1, id);
				   
		  rs = pst.executeQuery();
			
		  if(rs.next())
		  {
			status= true;
		  }
		}catch(SQLException e) 
		 {
		     e.printStackTrace();
		   	 //System.out.println("Can't Insert Record - Database Problem");
		 }
		 finally 
		 {
		    try 
		    {
			   if (pst != null)
			      pst.close();
			   if(rs != null)
				  rs.close();
			   if(mysqlconnection != null)
			      mysqlconnection.close();
			} catch (SQLException e) {e.printStackTrace();}
		  } 	
		  
		  return status;
     }
	
	public int insertmRecord(userModel userobj)
	{
	  PreparedStatement pst =null;
      Connection mysqlconnection = null;
      
      try
      {
   	     mysqlconnection = DBMySQLConnect.getMySQLConnection();
   	   
   	   //Step 3 PREPARE QUERY
   	     String insertquery = "insert into memberDetails(datetime,name,phone,timing,gender,address,coach) values(?,?,?,?,?,?,?)";
  	   
   	     pst = mysqlconnection.prepareStatement(insertquery);
   	     pst.setString(1, userobj.getDatetime());
		 pst.setString(2, userobj.getName());
		 pst.setString(3, userobj.getPhone());
		 pst.setString(4, userobj.getTiming());
		 pst.setString(5, userobj.getGender());
		 pst.setString(6, userobj.getAddress());
		 pst.setString(7, userobj.getCoach());
		   
		 int replycountfromdb = pst.executeUpdate();
		 
		 return replycountfromdb;
  
   	 }catch(SQLException e) 
      {
   		e.printStackTrace();
   		System.out.println("Can't Insert Record - Database Problem");
      }
      finally 
      {
       	try 
       	{
		  if (pst != null)
		    pst.close();
		  if(mysqlconnection != null)
		    mysqlconnection.close();
		} catch (SQLException e) {e.printStackTrace();}
	   } 
	return 0;
    }
	
	public int insertcRecord(userModel userobj1)
	{
	  PreparedStatement pst =null;
      Connection mysqlconnection = null;
      
      try
      {
   	     mysqlconnection = DBMySQLConnect.getMySQLConnection();
   	   
   	   //Step 3 PREPARE QUERY
   	     String insertquery = "insert into coachDetails(name,phone,timing, email) values(?,?,?,?)";
  	   
   	     pst = mysqlconnection.prepareStatement(insertquery);
		 pst.setString(1, userobj1.getCname());
		 pst.setString(2, userobj1.getCphone());
		 pst.setString(3, userobj1.getCtiming());
		 pst.setString(4, userobj1.getEmail());
		   
		 int replycountfromdb = pst.executeUpdate();
		 
		 return replycountfromdb;
  
   	 }catch(SQLException e) 
      {
   		e.printStackTrace();
   		System.out.println("Can't Insert Record - Database Problem");
      }
      finally 
      {
       	try 
       	{
		  if (pst != null)
		    pst.close();
		  if(mysqlconnection != null)
		    mysqlconnection.close();
		} catch (SQLException e) {e.printStackTrace();}
	   } 
	return 0;
    }
	
	public int payment(userModel userobj1) {
		
		PreparedStatement pst =null;
	      Connection mysqlconnection = null;
	      
	      try
	      {
	   	     mysqlconnection = DBMySQLConnect.getMySQLConnection();
	   	   
	   	   //Step 3 PREPARE QUERY
	   	     String insertquery = "insert into payments(timing,id,amount) values(?,?,?)";
	  	   
	   	     pst = mysqlconnection.prepareStatement(insertquery);
			 pst.setString(1, userobj1.getDatetime());
			 pst.setString(2, userobj1.getID());
			 pst.setString(3, userobj1.getAmt());
			   
			 int replycountfromdb = pst.executeUpdate();
			 
			 return replycountfromdb;
	  
	   	 }catch(SQLException e) 
	      {
	   		e.printStackTrace();
	   		System.out.println("Can't Insert Record - Database Problem");
	      }
	      finally 
	      {
	       	try 
	       	{
			  if (pst != null)
			    pst.close();
			  if(mysqlconnection != null)
			    mysqlconnection.close();
			} catch (SQLException e) {e.printStackTrace();}
		   } 
		return 0;
		
	}
	
	public int updateRecord(String id, userModel userobj)
	{
		PreparedStatement pst =null;
		  Connection mysqlconnection = null;
		  try 
		  {
			  mysqlconnection = DBMySQLConnect.getMySQLConnection();
			  
			  String updatequery = "update memberDetails set phone=?, timing=? where coach=?";
		   	   
	    	  pst = mysqlconnection.prepareStatement(updatequery);
	    	  pst.setString(1, userobj.getPhone());
	    	  pst.setString(2, userobj.getTiming());
	    	  pst.setString(3, userobj.getCoach());
	   	      
		   	  int replycountfromdb = pst.executeUpdate();
			 
			  return replycountfromdb;
			   	
			
		  }
		  catch (SQLException e) {e.printStackTrace();}
		  
		  return 0;
	}
	
	public int deleteRecord(String id)
    {
		 PreparedStatement pst =null;
		  Connection mysqlconnection = null;
		  try 
		  {
			  mysqlconnection = DBMySQLConnect.getMySQLConnection();
			  
			  String deletequery = "delete from memberDetails where id = ?";
			  	  	   
		   	  pst = mysqlconnection.prepareStatement(deletequery);
		   	  pst.setString(1, id);
		   	  int replycountfromdb = pst.executeUpdate();
			 
			  return replycountfromdb;
			   	
			
		  }
		  catch (SQLException e) {e.printStackTrace();}
		  
		  return 0;
    }
	

}
