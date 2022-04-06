package steps;

import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pages.DatabasePage;
import pages.LoginPage;
import pages.TestBase;

public class LoginStepDefination extends TestBase {

	LoginPage loginPage;
	DatabasePage databasepage;

	@Before
	public void beforeRun() {
		init();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		databasepage = new DatabasePage();
	}

	@Given("^User is on Techfios login page with daata$")
	public void user_is_on_Techfios_login_page_with_daata() throws Throwable {

	}

	@When("^User enter \"([^\"]*)\" from techfios with database$")
	public void user_enter_from_techfios_with_database(String data) throws Throwable {
		switch (data) {
		case "username":
			loginPage.enterUserName(databasepage.getData("username"));
			System.out.println("UserName From DB: " + databasepage.getData("username"));
			Thread.sleep(3000);
			break;
		case "password":
			loginPage.enterPassword(databasepage.getData("password"));
			System.out.println("Password From DB: " + databasepage.getData("password"));
			Thread.sleep(3000);
			break;

		}
	}

	@When("^user clicks on Signin button with database$")
	public void user_clicks_on_Signin_button_with_database() throws Throwable {
		loginPage.clickSignInButton();
		Thread.sleep(3000);
	}

	@Then("^user should land on Dadhbord Page with database$")
	public void user_should_land_on_Dadhbord_Page_with_database() throws Throwable {
		takeScreenShot(driver);
		String actualTitle = loginPage.getPageTitle();
		String expectedTitle = "Dashboard- iBilling";
		Assert.assertEquals("wrong page", expectedTitle, actualTitle);

		Thread.sleep(3000);
	}
@After
public void afterRun() {
	tearDown();
	
}
}
