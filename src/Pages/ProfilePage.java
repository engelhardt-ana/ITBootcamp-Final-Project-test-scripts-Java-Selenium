package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage {

	public ProfilePage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);

	}

	public WebElement getFirstName() {
		return this.driver.findElement(By.name("user_first_name"));
	}

	public WebElement getLastName() {
		return this.driver.findElement(By.name("user_last_name"));
	}

	public WebElement getEmail() {
		return this.driver.findElement(By.name("user_email"));
	}

	public WebElement getAddress() {
		return this.driver.findElement(By.name("user_address"));
	}

	public WebElement getPhone() {
		return this.driver.findElement(By.name("user_phone"));
	}

	public WebElement getZipCode() {
		return this.driver.findElement(By.name("user_zip"));
	}

	// dropdown Country
	public Select selectCountry() {
		Select country = new Select(this.driver.findElement(By.id("user_country_id")));
		return country;
	}

	public void getCountry(String countryName) {
		this.selectCountry().selectByVisibleText(countryName);

	}

	// dropdown State
	public Select selectState() {
		Select state = new Select(this.driver.findElement(By.id("user_state_id")));
		return state;
	}

	public void getState(String stateName) {
		this.selectCountry().selectByVisibleText(stateName);

	}

	// dropdown City
	public Select selectCity() {
		Select city = new Select(this.driver.findElement(By.id("user_city")));
		return city;
	}

	public void getCity(String cityName) {
		this.selectCountry().selectByVisibleText(cityName);

	}


	public WebElement getSaveInfoBtn() {
		WebElement div = this.driver.findElement(By.className("col-lg-12"));
		return div.findElement(By.name("btn_submit"));
	}

	public void changePersonalInfo(String firstName, String lastName, String address, String phone, String zipCode,
			String countryName, String stateName, String cityName) throws InterruptedException {

		// clear all fields
		this.getFirstName().clear();
		this.getLastName().clear();
		this.getAddress().clear();
		this.getPhone().clear();
		this.getZipCode().clear();

		// put info

		this.getFirstName().sendKeys(firstName);
		this.getLastName().sendKeys(lastName);	
		this.getAddress().sendKeys(address);
		this.getPhone().sendKeys(phone);
		this.getZipCode().sendKeys(zipCode);
		this.getCountry(countryName);
		Thread.sleep(3000);
		this.getState(stateName);
		Thread.sleep(3000);
		this.getCity(cityName);
		Thread.sleep(3000);
		this.getSaveInfoBtn().click();

	}

	public WebElement getUploadPhotoBtn() {
		return this.driver.findElement(By.className("uploadFile-Js"));
	}

	public WebElement getRemovePhotoBtn() {
		return this.driver.findElement(By.className("remove"));
	}

	public void removePhoto() {
		this.js.executeScript("arguments[0].click();", this.getRemovePhotoBtn());
	}

	public void UploadPic(String filePath) throws InterruptedException {
		this.js.executeScript("arguments[0].click();", getUploadPhotoBtn());
		this.driver.findElement(By.xpath("//input[@type='file']")).sendKeys(filePath);
		Thread.sleep(3000);

	}

}
