package models;

import java.sql.Timestamp;

public class Thread extends Question{
	private int reply_count;
	private int Question_Id;
	public Thread(int Question_Id, String Question_Title, String Question_Description, String username,
			Timestamp Created_On,int reply_count) {
		super(Question_Title, Question_Description, username, Created_On,null);
		this.Question_Id = Question_Id;
		this.reply_count = reply_count;
	}

	public int getReply_count() {
		return reply_count;
	}

	public int getQuestion_Id() {
		return Question_Id;
	}
	

}
