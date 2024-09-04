package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class CartPage extends BaseTest {
    private WebDriverWait wait;
    
    //Elementos Web
    private By removeButtonBy = By.id("remove-sauce-labs-backpack");
    private By continueShoppingButtonBy = By.name("continue-shopping");
    private By qtyFieldBy = By.cssSelector("[class='cart_quantity']");
    private By checkoutButtonBy = By.cssSelector("[class='btn btn_action btn_medium checkout_button ']");
   	
	//Constructor
	public CartPage(WebDriver driver) {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//Acciones sobre los elementos
	public CartPage clickRemoveButton() {
		WebElement removeButton = wait.until(ExpectedConditions.elementToBeClickable(removeButtonBy));
		removeButton.click();
		return this;
	}
	
	public CartPage clickContinueShoppingButton() {
		WebElement continueShoppingButton = wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButtonBy));
		continueShoppingButton.click();
		return this;
	}
	
	public boolean confirmCurrentPage() {
		String url = "https://www.saucedemo.com/inventory.html";
		return url.equals(driver.getCurrentUrl());
	}
	
	public CartPage changeProductQuantity(String qty) {
		WebElement qtyField = wait.until(ExpectedConditions.presenceOfElementLocated(qtyFieldBy));
		qtyField.sendKeys(qty);
		return this;
	}
	
	public CartPage clickCheckoutButton() {
		WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(checkoutButtonBy));
		checkoutButton.click();
		return this;
	}

}
