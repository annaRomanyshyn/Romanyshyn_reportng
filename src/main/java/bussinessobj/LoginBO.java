package bussinessobj;

import driver.Driver;
import models.UserModel;
import pageobject.LoginPage;
import testdata.TestData;

public class LoginBO {
	private String source = "src\\main\\java\\driverTestData.properties";

	public void login(UserModel user) {
		LoginPage loginPage = new LoginPage();
		TestData data = new TestData(source);
		Driver.setBaseUrl(data.getBaseUrl());
		loginPage.typeLoginAndSubmit(user.getLogin());
		loginPage.typePasswordAndSubmit(user.getPassword());
	}

}
