package tests;

import org.junit.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import page.CartPage;
import page.CheckoutStepOnePage;
import page.HomePage;
import page.InventoryPage;
public class CP_009_CompraNoExitosaSinDatoCodigoPostal extends BaseTest {
	String userNane = "standard_user";
	String password = "secret_sauce";
	String firstName = "Rodrigo";
	String lastName = "Fernandez";
	String postalCode = "";
	String errorMessage = "Error: Postal Code is required";
		
	@Test(priority=1)
	public void intentarRealizarCompraDeProductoSinCodigoPostal() {
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
		
		Assert.assertTrue(checkoutStepOnePage.compareErrorMessage(errorMessage));
		
	}

}
