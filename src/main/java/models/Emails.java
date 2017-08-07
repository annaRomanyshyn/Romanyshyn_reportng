package models;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Emails")
public class Emails {
	@XmlElement(name = "Email")
	private List<EmailModel> emails;

	public List<EmailModel> getEmails() {
		return emails;
	}

	public void setUsers(List<EmailModel> emails) {
		this.emails = emails;
	}
}
