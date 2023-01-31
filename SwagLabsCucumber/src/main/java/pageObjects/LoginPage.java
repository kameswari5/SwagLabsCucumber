package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="user-name")
	WebElement Username;
	
	@FindBy(id="password")
	WebElement Password;
	
	@FindBy(id="login-button")
	WebElement Login ;

	
	@FindBy(xpath ="//h3[@data-test='error']")
	WebElement emptyError;
	
	
		
	public void username(String username) {
		Username.clear();
		Username.sendKeys(username);
	}
	
	public void password(String password) {
		Password.clear();
		Password.sendKeys(password);
	}
	
	public void loginbutton() {
		Login.click();
	}
	
	
	public String getErrorMessage() {
		String errorMessage = emptyError.getText();
		return errorMessage;		
	}
}


