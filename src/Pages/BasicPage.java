package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasicPage {

	protected WebDriver driver;
	protected JavascriptExecutor js;
	protected WebDriverWait waiter;
	
	public BasicPage (WebDriver driver,WebDriverWait waiter,JavascriptExecutor js) {
		this.driver=driver;
		this.waiter=waiter;
		this.js=js;
	}
	
	
	
}
