package models;

import java.sql.Timestamp;

public class BugReport {
	 private String BugReportTitle;
     private String BugReportDescription;
     private Timestamp BugCreatedAt;
     private String BugStatus;
     private String username;
     private int BugId;
     
     
     public BugReport(int BugId,String username,String BugReportTitle, String BugReportDescription,Timestamp BugCreatedAt, String BugStatus )
     {
    	 this.BugId = BugId;
    	 this.username = username;
    	 this.BugReportTitle = BugReportTitle;
    	 this.BugReportDescription = BugReportDescription;
         this.BugCreatedAt = BugCreatedAt;
         this.BugStatus = BugStatus;
    	 
     }
	
	public Timestamp getBugCreatedAt() {
		return BugCreatedAt;
	}

	public String getBugStatus() {
		return BugStatus;
	}

	public String getUsername() {
		return username;
	}

	public int getBugId() {
		return BugId;
	}

	public String getBugReportTitle() {
		return BugReportTitle;
	}
	public String getBugReportDescription() {
		return BugReportDescription;
	}
}
