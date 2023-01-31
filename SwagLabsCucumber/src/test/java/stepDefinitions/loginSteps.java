package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import helper.BrowserUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.*;

public class loginSteps {
	 WebDriver driver =BrowserUtil.startBrowser("chrome","https://www.saucedemo.com/");
	 LoginPage  login;
	 InventoryPage inventory;
	 CartPage cart;
	 

	@Given("User is on SwagLabsLogin page {string}")
	public void user_is_on_swag_labs_login_page(String url ) {
		login = new LoginPage(driver);
		
	}
	
	@When("User enters username as {string} and password as {string}")
	public void user_enters_username_as_and_password_as(String username, String password) {
		login.username(username);
		login.password(password);
	}
	@Then("User should be able to login sucessfully and navigate to iventory page with title {string}")
	public void user_should_be_able_to_login_sucessfully_and_navigate_to_iventory_page_with_title(String title) {
		login.loginbutton();

		InventoryPage inventory = new InventoryPage(driver);
		String actualResult = inventory.getProductHeading();
		Assert.assertEquals(actualResult, title);
	}


	@Then("User should be able to see error message {string}")
	public void user_should_be_able_to_see_error_message(String message) {
	
		login.loginbutton();
	String actualResult = login.getErrorMessage();
	Assert.assertEquals(actualResult, message);
	}


	@When("I add an {string} to cart")
	public void i_add_an_to_cart(String item) {
		inventory= new InventoryPage(driver);
		inventory.addItem(item);
	}
	
	@Then("click on the cart")
	public void click_on_the_cart() {
		inventory.cart();
	}
	@Then("Should see \"<item>\"in cart")
	public void should_see_item_in_cart(String item) {
		Boolean value = cart.validateCartItems(item);
		Assert.assertEquals(true, value);
		boolean flag = cart.validateCartItemsCount(item);
		Assert.assertEquals(true, flag);
	}



}

