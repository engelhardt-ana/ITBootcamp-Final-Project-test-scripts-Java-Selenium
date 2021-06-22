package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocationPopupPage extends BasicPage {

	public LocationPopupPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);

	}
	// location btn

	public WebElement getLocation() {
		return this.driver.findElement(By.className("location-selector")).findElement(By.tagName("a"));

	}

	// close-btn

	public WebElement getCloseBtn() {
		return this.driver.findElement(By.className("close-btn-white"));

	}

	public WebElement getKeyword() {
		return this.driver.findElement(By.id("locality_keyword"));
	}

	public WebElement getLocationItem(String locationName) {
		return this.driver.findElement(By.xpath("//li/a[contains(text(), '" + locationName + "')]/.."));
	}

	public WebElement getLocationInput() {
		return this.driver.findElement(By.id("location_id"));

	}

	public WebElement getSubmit() {
		return this.driver.findElement(By.xpath("//*[@name='btn_submit']"));
	}

	// Dialog about location

	public void getDialogue() {
		getLocation().click();
	}

	public void setLocation(String locationName) throws InterruptedException {
		this.getKeyword().click();
		String data = getLocationItem(locationName).getAttribute("data-value");
		this.js.executeScript("arguments[0].value=arguments[1]", getLocationInput(), data);
		Thread.sleep(2000);
		this.js.executeScript("arguments[0].click();", getSubmit());

	}

	public void closeDialogue() {
		getCloseBtn().click();
	}

}
