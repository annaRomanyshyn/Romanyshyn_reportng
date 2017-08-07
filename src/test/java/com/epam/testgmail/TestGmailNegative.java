package com.epam.testgmail;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import bussinessobj.HomePageBO;
import bussinessobj.LoginBO;
import driver.Driver;
import models.UserModel;
import testdata.Data;
import testdata.DataXL;
import testlistener.MyListener;


public class TestGmailNegative{
	
	@DataProvider(parallel = true)
	public Object[] getData() throws Exception {
		DataXL usersData = new DataXL();
		Object[] data = usersData.getUsersObj().toArray();
		return data;
		
	}

	@Test(dataProvider = "getData")
	public void testLogin(UserModel user) {
		LoginBO login = new LoginBO();
		login.login(user);
		Data emailData = new Data();
		HomePageBO home = new HomePageBO();
		home.clickCompose();
		home.sendEmail(emailData.getEmails().get(0));
		home.closeErrorAndClearEmailInput();
		home.sendEmail(emailData.getEmails().get(1));
		assertFalse(home.verifyMessageisSent(emailData.getEmails().get(1)));
	}
	@AfterMethod
	public void closeBrowser() {
		Driver.close();
	}
}
