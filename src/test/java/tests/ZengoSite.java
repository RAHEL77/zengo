package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.MainPage;

public class ZengoSite {
	private WebDriver driver;
	private WebDriverWait wait;

	@BeforeClass
	public void beforeTest() {
		driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.get("https://zengo.com");
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	@Test
	public void test1() {
		MainPage mainPage = new MainPage(driver, wait);
		mainPage.getFeatures().click();
		mainPage.getBuy().click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://zengowallet.banxa.com/");
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"img[src='https://btc-storage-syd-p1-ap-southeast-2-branding-files.s3.ap-southeast-2.amazonaws.com/ZENGOWEB/logo/M8BBuMvyNP1RKDZAFfadxXzV0Rui1JCPC0zoi0v9.png']")))
				.isDisplayed());

	}

}
