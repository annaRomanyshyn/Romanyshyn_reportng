package testlistener;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;




public class MyListener implements ITestListener{
	Logger logger = Logger.getLogger(MyListener.class);
	public void onFinish(ITestContext tr) {
		
		
	}

	public void onStart(ITestContext tr) {
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult tr) {
		 logger.info("Test " + tr.getName()+" is failed");
		
	}

	public void onTestFailure(ITestResult tr) {
		 logger.info("Test " + tr.getName()+" is failed");
		
	}

	public void onTestSkipped(ITestResult tr) {
		 logger.info("Test " + tr.getName()+" is skipped" );
		
	}

	public void onTestStart(ITestResult tr) {
		 logger.info("Test " + tr.getName()+" is started");
		
	}

	public void onTestSuccess(ITestResult tr) {
		 logger.info("Test " + tr.getName()+" is successfull");
		
	}

}
