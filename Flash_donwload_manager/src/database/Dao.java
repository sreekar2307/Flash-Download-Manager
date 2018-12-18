package database;

import controllers.BugReportCont;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


//import model.BugReport;
public class Dao { 
       public boolean BugReport(String BugReportTitle , String BugReportDescription,String username)
       {
    	   try {
    		   String sql = ("Insert into BugReport(BugReportTitle,BugReportDescription,username) values(?,?,?)");
    		   String url ="jdbc:mysql://localhost:3306/Download_manager";
    		   String user = "root";
    		   String password = "Sreekar@123";
    		   Class.forName("com.mysql.jdbc.Driver");
    		   System.out.println("connected to jdbc");
    		   Connection con = DriverManager.getConnection(url, user, password);
    		   System.out.println("Driver manager  created");
    		   PreparedStatement ps = con.prepareStatement(sql);
    		   ps.setString(1, BugReportTitle);
    		   ps.setString(2, BugReportDescription);
    		   ps.setString(3, username);
             
    		   ps.executeUpdate();
    		   System.out.println("executed");
    		   con.close();
    		   System.out.println("closed");
    		   
    	   }catch(Exception e)
    	   {
    		   e.printStackTrace();
    	   }
		return false;
       }
}
