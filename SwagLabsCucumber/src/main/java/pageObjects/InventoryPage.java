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


public class InventoryPage {

	private static Logger log = LogManager.getLogger(InventoryPage .class);
	 
	  
	WebDriver driver;
		
		public InventoryPage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		
		}
		
		@FindBy(xpath = "//div[@id='header_container']//span[@class='title']")
		WebElement heading;
		
		@FindBy(xpath="//button[contains(text(),'Add to cart')][1]")
		WebElement AddToCart1;
		
		@FindBy(xpath="//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
		WebElement AddToCart2;

		
		@FindBy(xpath="//div[@class='inventory_list']")
		WebElement inventory;
		
		@FindBy(xpath="//a[@class='shopping_cart_link']") 
		WebElement Cart;
		 
		
		public String getProductHeading() {
			String head=heading.getText();
			return head;
		}
		
		public void addItem(String item) {	
			try {
				log.info("Starting addItem Method");
				log.info("Getting inventory list");
				List<WebElement> inventoryList = inventory.findElements(By.className("inventory_item"));
				log.info("Getting inventory list",inventoryList);
			for(WebElement inventoryItem : inventoryList) {
				log.info("Looping inventory list",inventoryItem.getSize());
				WebElement inventory_item_name=inventoryItem.findElement(By.className("inventory_item_name"));
				log.info("WebElement of inventory_item_name",inventory_item_name.getText());
				String [] s = item.split("#");
				log.info("split item into string array");
				List<String> itemsList = Arrays.asList(s);
				log.info("Converting String array to list",itemsList.size());
				boolean contains = itemsList.contains(inventory_item_name.getText());
				log.info("Checking itemList list contains inventory_item_name ");
				if (contains){
					log.info("Checking if condition");
					WebElement addToCart=inventoryItem.findElement(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory"));			
					log.info("Getting WebElement of addToCart");
					addToCart.click();
					log.info("clicking addToCart element");
				}
			}
			}
			catch(Exception ex) {
				System.out.println("error message is :"+ex.getMessage());
			}
		}
		
		public void cart() {
			log.info("clicking on cart image");
			Cart.click();
		}
}
