package models;

import java.sql.Timestamp;

public class Reply {
	private String reply_description;
	private String replied_by;
	private Timestamp replied_on;
	public Reply(String replied_by,String reply_description, Timestamp replied_on) {
		this.reply_description = reply_description;
		this.replied_by = replied_by;
		this.replied_on = replied_on;
	}
	public String getReply_description() {
		return reply_description;
	}
	public String getReplied_by() {
		return replied_by;
	}
	public Timestamp getReplied_on() {
		return replied_on;
	}
	
	
}
