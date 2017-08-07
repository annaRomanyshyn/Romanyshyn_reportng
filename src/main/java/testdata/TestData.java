package testdata;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class TestData {
	private Properties prop;

	public TestData(String source) {
		try {
			prop = new Properties();
			File file = new File(source);
			FileInputStream reader = new FileInputStream(file);
			prop.load(reader);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public String getDriverProperty() {
		String testData = prop.getProperty("chromeDriver");
		return testData;
	}

	public String getDriverPath() {
		String testData = prop.getProperty("driverPath");
		return testData;
	}

	public String getBaseUrl() {
		String testData = prop.getProperty("baseUrl");
		return testData;
	}

}
