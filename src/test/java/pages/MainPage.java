package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(linkText = "Features")
	private WebElement features;
	
	@FindBy(linkText = "Buy")
	private WebElement buy;

	public WebElement getFeatures() {
		return features;
	}

	public WebElement getBuy() {
		return buy;
	}

	public MainPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}

}
