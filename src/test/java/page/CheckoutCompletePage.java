package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class CheckoutCompletePage extends BaseTest {
    private WebDriverWait wait;
    
    //Elementos Web
    private By purchaseCompletedMessageBy = By.cssSelector("[class='complete-header']");
    private By backHomeButtonBy = By.id("back-to-products");
    
	
	//Constructor
	public CheckoutCompletePage(WebDriver driver) {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//Acciones sobre los elementos
	public boolean confirmPurchaseCompletedMessage() {
		String message = "Thank you for your order!";
		WebElement purchaseCompletedMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(purchaseCompletedMessageBy));
		return message.equals(purchaseCompletedMessage.getText());
	}
	
	public CheckoutCompletePage clickBackHomeButton() {
		WebElement backHomeButton = wait.until(ExpectedConditions.elementToBeClickable(backHomeButtonBy));
		backHomeButton.click();
		return this;
	}
	
}
