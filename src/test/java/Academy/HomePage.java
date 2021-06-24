package Academy;

import java.io.IOException;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.landingPage;
import pageObjects.loginPage;
import resources.base;

public class HomePage extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password, String text) throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		landingPage l = new landingPage(driver);
		loginPage lp = l.getLogin();//click
		//loginPage lp = new loginPage(driver);
		lp.getEmail().sendKeys(username);//type
		lp.getPass().sendKeys(password);//type
		log.info(text);
		lp.getLoginBtn().click();
		ForgotPassword fp = lp.forgotPassword();
		fp.getEmail().sendKeys("xxx");
		fp.sendInstructions().click();
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];
		data[0][0] = "crew";
		data[0][1] = "mate";
		data[0][2] = "not SUS";
		
		data[1][0] = "sussy";
		data[1][1] = "baka";
		data[1][2] = "SUS";
		
		return data;
	}
}
