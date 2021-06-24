package Academy;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;

import pageObjects.landingPage;
import resources.base;

public class validateTitle extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized.");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page.");
	}
	@Test
	public void validateAppTitle() throws IOException {
		landingPage l = new landingPage(driver);
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSESqwe");
		log.info("Successfully validated text message.");
	}
	@AfterTest
	public void teardown() {
		driver.close();
	}
}
