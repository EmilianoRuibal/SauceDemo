package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class CheckoutStepOnePage extends BaseTest {
    private WebDriverWait wait;
    
    //Elementos Web
    private By firstNameFieldBy = By.id("first-name");
	private By lastNameFieldBy = By.id("last-name");
	private By postalCodeFieldBy = By.id("postal-code");
	private By continueButtonBy = By.id("continue");
	private By loginErrorMessageBy = By.cssSelector("[data-test='error']");
	
	//Constructor
	public CheckoutStepOnePage(WebDriver driver) {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//Acciones sobre los elementos
	public CheckoutStepOnePage enterFirstName(String firstName) {
		WebElement firstNameField = wait.until(ExpectedConditions.elementToBeClickable(firstNameFieldBy));
		firstNameField.sendKeys(firstName);
		return this;
	}
	
	public CheckoutStepOnePage enterLastName(String lastName) {
		WebElement lastNameField = wait.until(ExpectedConditions.elementToBeClickable(lastNameFieldBy));
		lastNameField.sendKeys(lastName);
		return this;
	}
	
	public CheckoutStepOnePage enterPostalCode(String postalCode) {
		WebElement postalCodeField = wait.until(ExpectedConditions.elementToBeClickable(postalCodeFieldBy));
		postalCodeField.sendKeys(postalCode);
		return this;
	}
	
	public CheckoutStepOnePage clickContinueButton() {
		WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(continueButtonBy));
		continueButton.click();
		return this;
	}
	
	public boolean compareErrorMessage(String errorMessage) {
		WebElement loginErrorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(loginErrorMessageBy));
		return errorMessage.equals(loginErrorMessage.getText());
	}

}
