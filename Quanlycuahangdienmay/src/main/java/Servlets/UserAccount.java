package Servlets;

public class UserAccount {

public static final String Gender_MALE="M";

public static final String Gender_FEMALE="F";

private String Username;

private String Gender;

private String PassWord;

public UserAccount(){}
public UserAccount(String Username, String Gender, String PassWord){

this.Username=Username;

this.Gender=Gender;

this.PassWord=PassWord;

}

public UserAccount(String Username, String PassWord) {

this.Username=Username;

this.PassWord=PassWord;

}

public UserAccount(UserAccount us){

this.Username=us.Username;

this.Gender=us.Gender;

this.PassWord=us.PassWord;

}

public String getUsername() { 
	return Username;
}
public String getGender() { 
	return Gender; 
	}

public String getPassWord() { 
	return PassWord; 
	}

public void setUsername(String Username){ 
	this.Username = Username; 
	}

public void setGender(String Gender) { 
	this.Gender = Gender; 
	}

public void setPassWord(String PassWord) { 
	this.PassWord = PassWord; 
	} 

}