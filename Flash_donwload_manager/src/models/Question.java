package models;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Question {
	private String Question_Title;
	private String Question_ID;
	private String username;
	private String Question_Description;
	Timestamp Created_On;
	private ArrayList<Reply> replies;
	
	public Question(String Question_Title,String Question_Description,String username,Timestamp Created_On,ArrayList<Reply> replies) {
		this.Question_Title=Question_Title;
		this.username=username;
		this.Question_Description =Question_Description;
		this.Created_On = Created_On;
		this.replies = replies; 
	}
		
	public String getQuestion_Title() {
		return Question_Title;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getQuestion_Description() {
		return Question_Description;
	}
	
	public Timestamp getCreated_On() {
		return Created_On;
	}
	
	public ArrayList<Reply> getReplies() {
		return replies;
	}

}
