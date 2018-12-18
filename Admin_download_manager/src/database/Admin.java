package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import models.BugReport;



public class Admin {
	ArrayList<BugReport> Bugs = new ArrayList<>();;
	public ArrayList<BugReport> get_BugReport_processing() {
	 try {
		   String sql = ("select BugId ,username ,BugReportTitle , BugReportDescription, BugCreatedAt , BugStatus from BugReport where BugStatus=\"processing\" ");
		   String url ="jdbc:mysql://localhost:3306/Download_manager";
		   String user = "root";
		   String password = "Sreekar@123";
		   Class.forName("com.mysql.jdbc.Driver");
		   System.out.println("connected to jdbc");
		   Connection con = DriverManager.getConnection(url, user, password);
		   System.out.println("Driver manager  created");
		   PreparedStatement ps = con.prepareStatement(sql);
		  
		   ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Bugs.add(new BugReport(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getTimestamp(5),rs.getString(6)));
			}
		   
		   System.out.println("executed");
		   con.close();
		   return Bugs;
		  
		   
	   }catch(Exception e)
	   {
		   return null;
	   }
	}
	 public boolean delete_bug(int Bug_id) {
		 try {
			   String sql = ("DELETE FROM BugReport WHERE BugId=?;");
			   String url ="jdbc:mysql://localhost:3306/Download_manager";
			   String user = "root";
			   String password = "Sreekar@123";
			   Class.forName("com.mysql.jdbc.Driver");
			   System.out.println("connected to jdbc");
			   Connection con = DriverManager.getConnection(url, user, password);
			   System.out.println("Driver manager  created");
			   PreparedStatement ps = con.prepareStatement(sql);
			   ps.setInt(1, Bug_id);
			   for(int i=0;i<Bugs.size();i++)
			   {
				   if(Bugs.get(i).getBugId()==Bug_id) {
					   Bugs.remove(i);
					  }
			   }
			   ps.executeUpdate();
			   return true;
		 }
		 catch(Exception e) {
			 e.printStackTrace();
			 return false;
		 }
	 }
}
