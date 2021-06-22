package Tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class MealItemTest extends BasicTest {

	@Test(priority = 0)
	public void addMealToCart() throws InterruptedException {
		driver.navigate().to(this.baseUrl + "meal/lobster-shrimp-chicken-quesadilla-combo");
		this.locationPopupPage.closeDialogue();
		Thread.sleep(2000);
		this.mealPage.addToCart("2");
		this.sa.assertTrue(this.notificationSistemPage.getMsgText().contains("The Following Errors Occurred:"),
				"[ERROR] There is no error message.");
		this.sa.assertTrue(this.notificationSistemPage.getMsgText().contains("Please Select Location"),
				"[ERROR] There is no error message.");
		this.waiter.until(ExpectedConditions.invisibilityOf(this.notificationSistemPage.getMsg()));
		this.locationPopupPage.getDialogue();
		//
		this.locationPopupPage.setLocation("City Center - Albany");
		this.mealPage.addToCart("1");
		this.sa.assertTrue(this.notificationSistemPage.getMsgText().contains("Meal Added To Cart"),
				"[ERROR]: Meal isn`t add to cart ");
		this.sa.assertAll();
	}

	@Test(priority = 5)
	public void addMealToFav() {
		this.driver.navigate().to(baseUrl + "meal/lobster-shrimp-chicken-quesadilla-combo");
		this.locationPopupPage.closeDialogue();
		//
		this.mealPage.favorite();
		this.sa.assertTrue(this.notificationSistemPage.getMsgText().contains("Please login first!"),
				"[ERROR]: Error Please login first isn`t visible ");
		this.driver.navigate().to(baseUrl + "guest-user/login-form");
		this.loginPage.login(email, password);
		this.driver.navigate().to(baseUrl + "meal/lobster-shrimp-chicken-quesadilla-combo");
		this.mealPage.favorite();
		this.sa.assertTrue(
				this.notificationSistemPage.getMsgText().contains("Product has been added to your favorites."),
				"[ERROR]:Product hasnt been added to favorites");
		this.sa.assertAll();
	}

}
