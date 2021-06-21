package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage {

	public LoginPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);

	}

	public WebElement getEmailField() {
		return this.driver.findElement(By.name("username"));
	}

	public WebElement getPasswordField() {
		return this.driver.findElement(By.name("password"));
	}

	public WebElement getRememberMe() {
		return this.driver.findElement(By.name("remember_me"));
	}

	public void rememberMe() {
		this.getRememberMe().click();
	}

	public WebElement getLoginBtn() {
		return this.driver.findElement(By.name("btn_submit"));
	}

	public void login(String email, String password) {
		this.getEmailField().sendKeys(Keys.chord(Keys.CONTROL, "a", email));
		this.getPasswordField().sendKeys(Keys.chord(Keys.CONTROL, "a", password));
		this.getLoginBtn().click();
	}

}
