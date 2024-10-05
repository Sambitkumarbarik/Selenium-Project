package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage {
	WebDriver driver;
	By Logo = By.xpath("//div[contains(text(),\"Swag Labs\")]");
	By AddTokart = By.xpath("//div[contains(text(),\"Sauce Labs Backpack\")]/ancestor::div[@class=\"inventory_item_label\"]/following-sibling::div/child::button[text()=\"Add to cart\"]");
	By remove = By.xpath("//div[contains(text(),\"Sauce Labs Backpack\")]/ancestor::div[@class=\"inventory_item_label\"]/following-sibling::div/child::button[text()=\"Remove\"]");
	public homePage(WebDriver driver) {
	        this.driver = driver;
	    }

	
	public String verifyLogo() {
		return driver.findElement(Logo).getText();
	}
	
	public void clickOnAddToCart() {
		driver.findElement(AddTokart).click();
	}
	public String getCartText() {
		return driver.findElement(AddTokart).getText();
	}
	public void remove() {
		driver.findElement(remove).click();
	}
	
	public String getRemoveText() {
		return driver.findElement(remove).getText();
	}
	
}
