package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthPage extends BasicPage {

	public AuthPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);

	}

	public WebElement getUserBtn() {
		return this.driver.findElement(By.className("filled")).findElement(By.tagName("a"));

	}

	public void getMyAccountBtn() {
		this.driver.findElement(By.linkText("My Account"));
	}

	public WebElement getLogoutBtn() {
		return this.driver.findElement(By.linkText("My Logout"));
	}

	public void logout() {
		this.getUserBtn().click();
		this.getLogoutBtn().click();
	}

}
