package models;

import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Users")
public class Users {

	private List<UserModel> users;

	public List<UserModel> getUsers() {
		return users;
	}

	@XmlElement(name = "User")
	public void setUsers(List<UserModel> users) {
		this.users = users;
	}

}
