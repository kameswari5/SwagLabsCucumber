package pageObjects;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CartPage {
	
private static Logger log = LogManager.getLogger(InventoryPage .class);
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[@class='title']")
	WebElement title;
	
	@FindBy(xpath="//div[@class='cart_list']")
	WebElement cartList;
	
	public String getMyTitle() {
		String Title = title.getText();
		return Title;
	}
	
	public  Boolean validateCartItems(String item) {
		log.info("Starting validateCartItems Method");
		log.info("Getting cartItems list");
		List<WebElement> cartItems=cartList.findElements(By.xpath("//div[@class='cart_item']"));
		for(WebElement element : cartItems) {
			WebElement inventoryItemName=element.findElement(By.xpath("//div[@class='inventory_item_name']"));
			String [] itemsArray = item.split("#");
			List<String> itemsList = Arrays.asList(itemsArray);
			if (!itemsList.contains(inventoryItemName.getText()))
			{
				return false;
			}
		}
		return true;
	}
	
	public int getCartItemsCount() {
		List<WebElement> cartItems=cartList.findElements(By.xpath("//div[@class='cart_item']"));
		return cartItems.size();
	}
	
	public boolean validateCartItemsCount(String item) {
		String[] items= item.split("#");
		return getCartItemsCount()== items.length;
	}

}
