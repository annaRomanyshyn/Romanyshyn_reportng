package com.epam.testgmail;

import org.testng.annotations.Test;

import bussinessobj.HomePageBO;
import bussinessobj.LoginBO;
import driver.Driver;
import models.EmailModel;
import models.UserModel;
import testdata.Data;
import testdata.DataXL;
import testlistener.MyListener;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class TestGmail {

	@DataProvider(parallel = true)
	public Object[] getData() throws Exception {
		DataXL usersData = new DataXL();
		Object[] data = usersData.getUsersObj().toArray();
		return data;

	}

	@Test(dataProvider = "getData")
	public void testGmail(UserModel user) {
		LoginBO login = new LoginBO();
		login.login(user);
		Data emailData = new Data();
		HomePageBO home = new HomePageBO();
		home.clickCompose();
		home.sendEmail(emailData.getEmails().get(0));
		home.closeErrorAndClearEmailInput();
		home.sendEmail(emailData.getEmails().get(1));
		assertTrue(home.verifyMessageisSent(emailData.getEmails().get(1)));
	}
	public void testSendingEmail() {
		
	}
	@AfterMethod
	public void closeBrowser() {
		Driver.close();
	}
}