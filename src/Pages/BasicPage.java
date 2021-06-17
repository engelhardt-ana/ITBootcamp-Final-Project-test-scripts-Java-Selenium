package Pages;

import org.openqa.selenium.WebDriver;

public abstract class BasicPage {

	protected WebDriver driver;
	
	public BasicPage (WebDriver driver) {
		this.driver=driver;
	}
	
	
	
}
