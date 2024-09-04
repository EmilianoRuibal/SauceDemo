package tests;

import org.junit.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import page.CartPage;
import page.CheckoutCompletePage;
import page.CheckoutStepOnePage;
import page.CheckoutStepTwoPage;
import page.HomePage;
import page.InventoryPage;
public class CP_006_CompraExitosaDeProducto extends BaseTest {
	String userNane = "standard_user";
	String password = "secret_sauce";
	String firstName = "Rodrigo";
	String lastName = "Fernandez";
	String postalCode = "8015";
	
		
	@Test(priority=1)
	public void realizarCompraDeProducto() {
		setUrlKey("url");
        setup();
        
		HomePage homePage = new HomePage(driver);
		homePage.enterUserName(userNane)
			.enterPassword(password)
			.clickLoginButton();
	
		InventoryPage inventoryPage = new InventoryPage(driver);
		inventoryPage.clickAddToCart()
			.goToCart();
		
		CartPage cartPage = new CartPage(driver);
		cartPage.clickCheckoutButton();
		
		CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage(driver);
		checkoutStepOnePage.enterFirstName(firstName)
			.enterLastName(lastName)
			.enterPostalCode(postalCode)
			.clickContinueButton();
		
		CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
		Assert.assertTrue(checkoutStepTwoPage.confirmProduct());
		checkoutStepTwoPage.clickFinishButton();
		
		CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
		checkoutCompletePage.clickBackHomeButton();
		
	}

}
