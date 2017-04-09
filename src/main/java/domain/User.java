package domain;

public class User {
	private String username;
	private String password;
	private String email;
	private UserRank rank;
	
	public String getUsername(){
		return this.username;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public UserRank getRank(){
		return this.rank;
	}
	
	public void setRank(UserRank rank){
		this.rank = rank;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}

}
