package tests;

import org.junit.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import page.CartPage;
import page.CheckoutStepOnePage;
import page.HomePage;
import page.InventoryPage;
public class CP_007_CompraNoExitosaSinDatoNombre extends BaseTest {
	String userNane = "standard_user";
	String password = "secret_sauce";
	String firstName = "";
	String lastName = "Fernandez";
	String postalCode = "8015";
	String errorMessage = "Error: First Name is required";
		
	@Test(priority=1)
	public void intentarRealizarCompraDeProductoSinNombre() {
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
