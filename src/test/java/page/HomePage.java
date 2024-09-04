package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class HomePage extends BaseTest {
    private WebDriverWait wait;
    
    //Elementos Web
    private By userNameFieldBy = By.id("user-name");
    private By passwordFieldBy = By.id("password");
    private By loginButtonBy = By.id("login-button");
    private By accessErrorMessageBy = By.cssSelector("[data-test='error']");
	
	//Constructor
	public HomePage(WebDriver driver) {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//Acciones sobre los elementos
	public HomePage enterUserName(String userName) {
		WebElement userNameField = wait.until(ExpectedConditions.elementToBeClickable(userNameFieldBy));
		userNameField.sendKeys(userName);
		return this;
	}
	
	public HomePage enterPassword(String password) {
		WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(passwordFieldBy));
		passwordField.sendKeys(password);
		return this;
	}
	
	public HomePage clickLoginButton() {
		WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginButtonBy));
		loginButton.click();
		return this;
	}
	
	public boolean accessErrorMessage() {
		String errorMessage = "Epic sadface: Username and password do not match any user in this service";
		WebElement accessErrorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(accessErrorMessageBy));
		return errorMessage.equals(accessErrorMessage.getText());
	}

}
