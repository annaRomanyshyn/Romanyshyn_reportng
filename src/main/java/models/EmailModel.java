package models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Email")
public class EmailModel {
	private String emailTo;
	private String subject;
	private String message;

	public String getEmailTo() {
		return emailTo;
	}

	@XmlElement(name = "emailTo")
	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}

	public String getSubject() {
		return subject;
	}

	@XmlElement(name = "subject")
	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	@XmlElement(name = "message")
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "EmailModel [emailTo=" + emailTo + ", subject=" + subject + ", message=" + message + "]";
	}

}