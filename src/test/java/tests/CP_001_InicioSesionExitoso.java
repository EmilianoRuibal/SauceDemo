package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import page.HomePage;
public class CP_001_InicioSesionExitoso extends BaseTest {
	String userNane = "standard_user";
	String password = "secret_sauce";
	
		
	@Test(priority=1)
	public void iniciarSesion() {
		setUrlKey("url");
        setup();
        
		HomePage homePage = new HomePage(driver);
		homePage.enterUserName(userNane)
			.enterPassword(password)
			.clickLoginButton();
	}

}
