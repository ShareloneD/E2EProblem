package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	public WebDriver driver;

	By email = By.id("user_email");
	By pass = By.id("user_password");
	By loginBtn = By.name("commit");
	By forgotPass = By.className("link-below-button");

	public loginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getPass() {
		return driver.findElement(pass);
	}

	public WebElement getLoginBtn() {
		return driver.findElement(loginBtn);
	}

	public ForgotPassword forgotPassword() {
		driver.findElement(forgotPass).click();
		ForgotPassword fp = new ForgotPassword(driver);
		return fp;
	}
}
