package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage {
	public WebDriver driver;
	
	private By signIn = By.xpath("//i[contains(@class,'fa fa-lock')]/following-sibling::span[1]");
	private By title = By.xpath("//div[@class='text-center']//h2[1]");
	private By navBar = By.xpath("//header/div[2]/div[1]/nav[1]/ul[1]");
	
	public landingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public loginPage getLogin() {
		driver.findElement(signIn).click();
		loginPage lp = new loginPage(driver);
		return lp;
	}
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public WebElement getNavBar() {
		return driver.findElement(navBar);
	}
}
