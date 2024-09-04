package tests;

import org.junit.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import page.HomePage;
import page.InventoryPage;
public class CP_003_AgregarProductosAlCarrito extends BaseTest {
	String userNane = "standard_user";
	String password = "secret_sauce";
	
		
	@Test(priority=1)
	public void agregarPruductoAlCarrito() {
		setUrlKey("url");
        setup();
        
		HomePage homePage = new HomePage(driver);
		homePage.enterUserName(userNane)
			.enterPassword(password)
			.clickLoginButton();
	
		InventoryPage inventoryPage = new InventoryPage(driver);
		inventoryPage.clickAddToCart()
			.goToCart();
		
		Assert.assertTrue(inventoryPage.checkRemoveButtonPresent());
	}

}
