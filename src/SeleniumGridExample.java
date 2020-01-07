import org.openqa.selenium.*;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.*;


public class SeleniumGridExample {
	static WebDriver driver;
	String baseUrl, nodeURL;
	static Wait<WebDriver> wait;

	@BeforeTest
	public void setup() throws MalformedURLException {
		baseUrl = "http://www.google.com";
		nodeURL = "http://192.168.1.95:5566/wd/hub";

		//DesiredCapabilites is used to set the type of browser and OS that we will automate
		DesiredCapabilities capability = DesiredCapabilities.firefox();
		capability.setBrowserName("firefox");
		capability.setPlatform(Platform.WINDOWS);
		//RemoteWebDriver is used to set which node (or machine) that our test will run against.
		driver = new RemoteWebDriver(new URL(nodeURL), capability);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	@Test
	public void simpleTest() {
		driver.get(baseUrl);
		Assert.assertEquals("Google", driver.getTitle());
	}
}
