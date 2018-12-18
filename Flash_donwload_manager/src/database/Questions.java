package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import models.Question;
import models.Reply;
import models.Thread;

public class Questions {
	
	public ArrayList<Thread> get_Threads() {
		ArrayList<Thread> Threads;
		try {
			Context ctx=new InitialContext();
			DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/sreekar");
			Connection con=ds.getConnection();
			PreparedStatement ps = con.prepareStatement("select Thread.Question_Id, Questions.Question_Title, Questions.Question_Description,Questions.username, Thread.Created_On, Thread.reply_count from " + 
					"Questions INNER JOIN Thread ON " + 
					"Questions.Question_Id = Thread.Question_Id;");
			ResultSet rs = ps.executeQuery();
			Threads = new ArrayList<>();
			while(rs.next()) {
				Threads.add(new Thread(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getTimestamp(5),rs.getInt(6)));
			}
			con.close();
			return Threads;
		}
		catch(Exception e){
			return null;
		} 
	}
	
	public boolean insert_question(String title,String desc,String username) {
		try {
			Context ctx=new InitialContext();
			DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/sreekar");
			Connection con=ds.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into Questions(Question_Title, Question_Description,username) values(?,?,?)");
			ps.setString(1,title);
			ps.setString(2,desc);
			ps.setString(3,username);
			ps.executeUpdate();
			con.close();
			return true;
		}
		catch(Exception e){
			System.out.println("in here5611");
			System.out.println(e.getMessage());
			return false;
		}
	}

	public Question get_Question(int Question_ID) {
		Question question = null;
		try{
			Context ctx=new InitialContext();
			DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/sreekar");
			Connection con=ds.getConnection();
			PreparedStatement ps = con.prepareStatement("select Question_Title, username, Question_Description, Created_On from Questions where Question_Id=?");
			ps.setInt(1, Question_ID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				question = new Question(rs.getString(1),rs.getString(3),rs.getString(2),rs.getTimestamp(4),get_replies(Question_ID));
			}
			return question;
		} catch(Exception e) {
			return null;
		}
	}

	private ArrayList<Reply> get_replies(int Question_ID){
		ArrayList<Reply> result;
		try {
			Context ctx=new InitialContext();
			DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/sreekar");
			Connection con=ds.getConnection();
			PreparedStatement ps = con.prepareStatement("select Reply.username, Reply.Reply_Description, Reply.Replied_On from " + 
					"Questions INNER JOIN Reply ON " + 
					"Questions.Question_Id = Reply.Question_Id " + 
					"where Questions.Question_Id = ?");
			ps.setInt(1, Question_ID);
			ResultSet rs = ps.executeQuery();
			result = new ArrayList<>();
			while(rs.next()) {
				result.add(new Reply(rs.getString(1),rs.getString(2),rs.getTimestamp(3)));
			}
			con.close();
			return result;
		} catch(Exception e) {
			return null;
		}
	}
	public boolean Insert_Reply(int Question_ID,String desc,String username) {
		try {
			Context ctx=new InitialContext();
			DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/sreekar");
			Connection con=ds.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into Reply(Question_Id,username,Reply_Description) values (?,?,?)");
			ps.setInt(1,Question_ID);
			ps.setString(3,desc);
			ps.setString(2,username);
			ps.executeUpdate();
			con.close();
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
}
