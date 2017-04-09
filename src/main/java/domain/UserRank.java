package domain;

public enum UserRank {
	USER (0, "User"), 
	PREMIUM (1, "Premium User"), 
	ADMIN (2, "Administrator");
	
	int flag;
	String label;
	
	UserRank(int flag, String label){
		this.flag = flag;
		this.label = label;
	}
	
	public int getFlag(){
		return this.flag;
	}
	
	public String getLabel(){
		return this.label;
	}
}
