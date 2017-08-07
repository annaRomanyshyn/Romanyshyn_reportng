package models;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "User")
public class UserModel {
	String login;
	String password;
   public UserModel(String login, String password) {
	   this.login = login;
	   this.password = password;
   }
	
	
	
	public String getLogin() {
		return login;
	}

	@XmlElement(name = "login")
	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	@XmlElement(name = "password")
	public void setPassword(String password) {
		this.password = password;
	}

	public Object getUser(Object user) {
		return user;
	}

	@Override
	public String toString() {
		return "UserModel [login=" + login + ", password=" + password + "]";
	}

}
