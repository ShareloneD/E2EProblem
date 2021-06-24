package stepDefinition;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.landingPage;
import pageObjects.loginPage;
import pageObjects.portalHomePage;
import resources.base;

public class stepDefinition extends base{
	@Given("^initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver = initializeDriver();
	}

	@Given("^Navigate to \"([^\"]*)\" site$")
	public void navigate_to_site(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get(arg1);
	}

	@Given("^Click on Login link in home page to land on Secure sign in Page$")
	public void click_on_Login_link_in_home_page_to_land_on_Secure_sign_in_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		landingPage l = new landingPage(driver);
		loginPage lp = l.getLogin();
	}
	
	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\" and logs in$")
	public void user_enters_and_and_logs_in(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		loginPage lp = new loginPage(driver);
		lp.getEmail().sendKeys(arg1);
		lp.getPass().sendKeys(arg2);
		lp.getLoginBtn().click();
	}
	
	@Then("^Verify that user is successfully logged in$")
	public void verify_that_user_is_successfully_logged_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    portalHomePage p = new portalHomePage(driver);
	    //Assert.assertTrue(p.getSearchBox().isDisplayed());
	    loginPage lp = new loginPage(driver);
	    Assert.assertTrue(lp.getLoginBtn().isDisplayed());
	}
	
	@And("^Close browsers$")
    public void close_browsers() throws Throwable {
        driver.quit();
    }

}
