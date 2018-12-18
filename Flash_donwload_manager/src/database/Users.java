package database;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Users {
	public boolean check_crenditials(String Username,String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Download_manager","root","Sreekar@123");
			PreparedStatement ps= con.prepareStatement("select * from Users where username = ? and password = aes_encrypt(?,\"passkey\")");
			ps.setString(1, Username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			boolean flag = rs.next();
			con.close();
			if(flag)
				return true;
			else 
				return false;

		} catch (Exception e) {
			System.out.println("error here");
			e.printStackTrace();
		}
		return false;
	}
	public String get_email(String Username) {
		String email= null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Download_manager","root","Sreekar@123");
			PreparedStatement ps= con.prepareStatement("select * from Users where username = ?");
			ps.setString(1, Username);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
				email = rs.getString("email");
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return email;
	}
	public int register(String username, String Password,String email) {
		try {
			Context ctx=new InitialContext();
			DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/sreekar");
			Connection con=ds.getConnection();
			PreparedStatement ps= con.prepareStatement("insert into Users values(?,aes_encrypt(?,\"passkey\"),?)");
			PreparedStatement ps_check= con.prepareStatement("select * from Users where username = ?");
			ps_check.setString(1, username);
			ResultSet rs_check = ps_check.executeQuery();
			if(rs_check.next())
			{
				System.out.println("went inside this");
				return 1;
			}
			ps.setString(1, username);
			ps.setString(2,Password);
			ps.setString(3, email);
			ps.executeUpdate();
			con.close();
			return 0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 2;
		}
	}
}
