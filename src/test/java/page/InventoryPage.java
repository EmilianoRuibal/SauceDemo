package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class InventoryPage extends BaseTest {
    private WebDriverWait wait;
    
    //Elementos Web
    private By addToCartButtonBy = By.id("add-to-cart-sauce-labs-backpack");
    private By removeButtonBy = By.id("remove-sauce-labs-backpack");
    private By cartButtonBy = By.cssSelector("[class='shopping_cart_badge']");
    
   	
	//Constructor
	public InventoryPage(WebDriver driver) {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//Acciones sobre los elementos
	public InventoryPage clickAddToCart() {
		WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(addToCartButtonBy));
		addToCartButton.click();
		return this;
	}
	
	public boolean checkRemoveButtonPresent() {
		WebElement removeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(removeButtonBy));
		return removeButton.isDisplayed();		
	}
	
	public InventoryPage goToCart() {
		WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(cartButtonBy));
		cartButton.click();
		return this;
	}

}
