package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BasicTest {
	
	private String loginMsg="Login Successfull";
	private String setupMsg="Setup Successful";
	private String logoutMsg="Logout Successfull!";
	private String errorLoginMsg = "[ERROR]: Login isn't successfull!";
	private String errorSetupMsg = "[ERROR]: Setup isn't successfull!";
	private String errorLogoutMsg = "[ERROR]: Logout isn't successfull!";
	
	
	
		
	@Test (priority = 0)
	public void editTest () throws InterruptedException {
		
	this.driver.navigate().to(this.baseUrl+"guest-user/login-form");
	this.locationPopupPage.closeDialogue();
	this.loginPage.login(this.email, this.password);
	Thread.sleep(3000);
	Assert.assertEquals(this.notificationSistemPage.getMsgText().contains(loginMsg), errorLoginMsg);
	Thread.sleep(3000);
	this.driver.navigate().to(baseUrl+"/member/profile");
	this.profilePage.changePersonalInfo("Anastasia", "Engelhardt", "27 Marta", "0000111111", "34000", "United States", "Alabama", "Alabaster");
	Assert.assertEquals(this.notificationSistemPage.getMsgText().contains(setupMsg), errorSetupMsg);
	this.authPage.logout();
	Assert.assertEquals(this.notificationSistemPage.getMsgText().contains(logoutMsg), errorLogoutMsg);
	
	}
	

}
