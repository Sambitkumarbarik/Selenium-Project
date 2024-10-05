package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
	WebDriver driver;
	By Username = By.xpath("//input[contains(@id,\"user-name\")]");
	By Password = By.xpath("//input[contains(@id,\"password\")]");
	By login = By.xpath("//input[contains(@id,\"login-button\")]");
	public loginPage(WebDriver driver) {
	        this.driver = driver;
	    }

	
	public void setUserName(String username) {
		driver.findElement(Username).sendKeys(username);
	}
	
	public void setPassword(String password) {
		driver.findElement(Password).sendKeys(password);
	}
	public void ClickOnlogin() {
		driver.findElement(login).click();
	}
	
}
