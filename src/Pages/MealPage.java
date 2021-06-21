package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MealPage extends BasicPage {

	public MealPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);

	}

	public WebElement getFavorite() {
		return this.driver.findElement(By.id("item_95"));
	}

	public void favorite() {
		this.getFavorite().click();
	}

	public WebElement getAddToCartBtn() {
		return this.driver.findElement(By.className("js-proceedtoAddInCart"));
	}

	public WebElement getQuantity() {
		return this.driver.findElement(By.name("product_qty"));

	}

	public List<WebElement> getProduct() {
		return this.driver.findElements(By.xpath("//div[@class='product-wrapper']/a"));

	}

	public void addToCart(String quantity) throws InterruptedException {
		this.getQuantity().clear();
		this.getQuantity().sendKeys(quantity);
		Thread.sleep(3000);
		this.getAddToCartBtn().click();
	}

}
