package driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import testdata.TestData;

public class Driver {

	private static ThreadLocal<WebDriver> pool = new ThreadLocal<WebDriver>();
	private static String source = "src\\main\\java\\driverTestData.properties";

	public static WebDriver getDriver() {

		return pool.get() != null ? pool.get() : setWebDriver();
	}

	public static WebDriver setWebDriver() {
		TestData data = new TestData(source);
		System.setProperty(data.getDriverProperty(), data.getDriverPath());
		pool.set(new ChromeDriver() {
			{
				manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
		});
		return pool.get();
	}

	public static void setBaseUrl(String baseUrl) {
		pool.get().get(baseUrl);
	}

	public static void close() {
		if (pool.get() != null) {
			pool.get().quit();
		}
	}

}
