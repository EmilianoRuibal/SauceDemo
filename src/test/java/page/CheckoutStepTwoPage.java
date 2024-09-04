package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class CheckoutStepTwoPage extends BaseTest {
    private WebDriverWait wait;
    
    //Elementos Web
    private By finishButtonBy = By.cssSelector("[class='btn btn_action btn_medium cart_button']");
    private By productNameMessageBy = By.cssSelector("[class='inventory_item_name']");
	
	//Constructor
	public CheckoutStepTwoPage(WebDriver driver) {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//Acciones sobre los elementos
	public CheckoutStepTwoPage clickFinishButton() {
		WebElement finishButton = wait.until(ExpectedConditions.elementToBeClickable(finishButtonBy));
		finishButton.click();
		return this;
	}
	
	public boolean confirmProduct() {
		String product = "Sauce Labs Backpack";
		WebElement productNameMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(productNameMessageBy));
		return product.equals(productNameMessage.getText());
	}
	
}
