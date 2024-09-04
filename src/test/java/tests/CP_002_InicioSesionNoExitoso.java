package tests;

import org.junit.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import page.HomePage;
public class CP_002_InicioSesionNoExitoso extends BaseTest {
	String userNane = "fail_user";
	String password = "fail_pass";
	
		
	@Test(priority=1)
	public void iniciarSesion() {
		setUrlKey("url");
        setup();
        
		HomePage homePage = new HomePage(driver);
		homePage.enterUserName(userNane)
			.enterPassword(password)
			.clickLoginButton();
		
		Assert.assertTrue(homePage.accessErrorMessage());
	}

}
