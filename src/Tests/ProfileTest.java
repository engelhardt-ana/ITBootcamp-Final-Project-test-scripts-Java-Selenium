package Tests;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class ProfileTest extends BasicTest {

	private String loginMsg = "Login Successfull";
	private String setupMsg = "Setup Successful";
	private String logoutMsg = "Logout Successfull!";
	private String errorLoginMsg = "[ERROR]: Login isn't successfull!";
	private String errorSetupMsg = "[ERROR]: Setup isn't successfull!";
	private String errorLogoutMsg = "[ERROR]: Logout isn't successfull!";

	@Test(priority = 0)
	public void editTest() throws InterruptedException {

		this.driver.navigate().to(this.baseUrl + "guest-user/login-form");
		this.locationPopupPage.closeDialogue();
		this.loginPage.login(this.email, this.password);
		Thread.sleep(3000);
				
		this.sa.assertTrue(this.notificationSistemPage.getMsgText().contains(loginMsg), errorLoginMsg);
		Thread.sleep(3000);
		this.driver.navigate().to(baseUrl + "/member/profile");
		this.profilePage.changePersonalInfo("Anastasia", "Engelhardt", "27 Marta", "0000111111", "34000",
				"United States", "Alabama", "Alabaster");
		this.sa.assertTrue(this.notificationSistemPage.getMsgText().contains(setupMsg), errorSetupMsg);
		this.authPage.logout();
		this.sa.assertTrue(this.notificationSistemPage.getMsgText().contains(logoutMsg), errorLogoutMsg);
		this.sa.assertAll();

	}

	@Test(priority = 5)
	public void changeProfileImage () throws InterruptedException, IOException {
		this.driver.navigate().to(this.baseUrl + "guest-user/login-form");
		this.locationPopupPage.closeDialogue();
		this.loginPage.login(this.email, this.password);
		Thread.sleep(3000);
		this.sa.assertTrue(this.notificationSistemPage.getMsgText().contains(loginMsg), errorLoginMsg);
		Thread.sleep(3000);
		this.driver.navigate().to(baseUrl + "/member/profile");
		String imgPath = new File("img/img.jpg").getCanonicalPath();
		this.profilePage.UploadPic(imgPath);
		this.sa.assertTrue(this.notificationSistemPage.getMsgText().contains("Profile Image Uploaded Successfully"), "[ERROR]: Profile Image  isn't Uploaded Successfully ");
		this.waiter.until(ExpectedConditions.invisibilityOf(this.notificationSistemPage.getMsg()));
		this.profilePage.removePhoto();
		this.sa.assertTrue(this.notificationSistemPage.getMsgText().contains("Profile Image Deleted Successfully"), "[ERROR]: Profile Image isnt Deleted Successfully ");
		this.waiter.until(ExpectedConditions.invisibilityOf(this.notificationSistemPage.getMsg()));
		this.authPage.logout();
		this.sa.assertTrue(this.notificationSistemPage.getMsgText().contains("Logout Successfull!"), "[ERROR]: Logout isnt Successfull ");
		this.sa.assertAll();
	}
	
	
	
	
	
	
}
