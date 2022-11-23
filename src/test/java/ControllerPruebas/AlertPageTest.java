package ControllerPruebas;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPageTest {
	private WebDriver driver;
	By alertBtn = By.id("alertexamples");
	By confirmBtn = By.id("confirmexample");
	By promptBtn = By.id("promptexample");
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");
	}
	
	@Test
	public void testAlertPage() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(alertBtn).click();
		Thread.sleep(700);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(1000);
		driver.findElement(confirmBtn).click();
		Thread.sleep(700);
		alert.dismiss();
		Thread.sleep(1000);
		driver.findElement(confirmBtn).click();
		Thread.sleep(700);
		alert.accept();
		Thread.sleep(1000);
		driver.findElement(promptBtn).click();
		Thread.sleep(700);
		alert.sendKeys("Profe, pónganos A");
		Thread.sleep(500);
		alert.accept();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
