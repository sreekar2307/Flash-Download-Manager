package models;

public class User {
  private String username=null;
  private String email=null;
  public User(String username,String email){
	  this.username=username;
	  this.email=email;
  }
@Override
public String toString() {
	return "User [username=" + username + ", email=" + email + "]";
}
public String getUsername() {
	return username;
}
public String getEmail() {
	return email;
}
  
}
