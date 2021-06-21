package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage extends BasicPage {

	public SearchResultPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);

	}

	
	public List<WebElement> getResults() {
		return this.driver.findElements(By.xpath("//*[@class='product-name']/a"));

	}

	public int getNumResults() {
		return getResults().size();
	}

	public ArrayList<String> getTextResults() {
		String meal = "";
		ArrayList<String> meals = new ArrayList<String>();
		for (int i = 0; i < getNumResults() -1 ; i++) {
			meal = getResults().get(i).getText();
			meals.add(meal);
		}
		return meals;

	}



}
