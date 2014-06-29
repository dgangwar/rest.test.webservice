package Appium.SoundCloud;

import io.appium.java_client.AppiumDriver;

import java.io.File;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * <a href="https://github.com/appium/appium">Appium</a> test which runs against
 * a local Appium instance deployed with the 'UICatalog' iPhone project which is
 * included in the Appium source distribution.
 * 
 * @author Ross Rowe
 */
public class TestAppium {
	private AppiumDriver driver;

	@Before
	public void setUp() throws Exception {
		// set up appium
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(
				classpathRoot,
				"/../../Library/Developer/Xcode/DerivedData/sharebuilder-bjempclduyhpoyeacvdgfqqedofb/Build/Products/Debug-iphonesimulator/");
		File app = new File(appDir, "sharebuilder.app");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("platformVersion", "7.1");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("deviceName", "iPhone Simulator");
		capabilities.setCapability("app", app.getAbsolutePath());
		driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test_location() {
		// get third row location
		boolean directory = driver
				.findElement(
						By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[1]"))
				.isDisplayed();
		System.out.println(directory);
	}
	

}