package Academy;

import java.io.IOException;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.landingPage;
import resources.base;

public class validateNavigationBar extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void validateAppNavBar() throws IOException {
		landingPage l = new landingPage(driver);
		Assert.assertTrue(l.getNavBar().isDisplayed());
		log.info("Navigation bar is displayed");
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
}
