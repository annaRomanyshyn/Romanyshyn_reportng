package testdata;

import java.io.File;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import models.EmailModel;
import models.Emails;
import models.UserModel;
import models.Users;

public class Data {
	private Users users;
	private Emails emails;

	public List<UserModel> getUsers() {
		try {
			File file = new File("src/main/java/testdata/users.xml");

			JAXBContext jaxbContext;

			jaxbContext = JAXBContext.newInstance(Users.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			users = (Users) jaxbUnmarshaller.unmarshal(file);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return users.getUsers();

	}

	public List<EmailModel> getEmails() {
		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(Emails.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			emails = (Emails) jaxbUnmarshaller.unmarshal(new File("src/main/java/testdata/emails.xml"));
		} catch (Exception e) {

			e.printStackTrace();
		}

		return emails.getEmails();

	}

}
