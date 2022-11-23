package ControllerPruebas;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class PrimeraPruebaCalidad {
	private static WebDriver driver;
	private String URL = "https://www.yoytec.com/web/signup";
	
	
	
	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("Inicio de las pruebas automatizadas");
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
	
	}
	
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.get(URL);
	}
	
	@Test
	public void testPruebasRegistro() throws InterruptedException {
		Thread.sleep(3000);
		WebElement emailText = driver.findElement(By.name("login"));
		WebElement nameText = driver.findElement(By.name("name"));
		WebElement passText = driver.findElement(By.name("password"));
		WebElement confirPassText = driver.findElement(By.name("confirm_password"));
		WebElement bottomRegister = driver.findElement(By.className("btn"));
		emailText.sendKeys("kevin.santamaria@utp.ac.pa");
		nameText.sendKeys("Kevin");
		passText.sendKeys("Pass1234%$&/");
		confirPassText.sendKeys("Pass1234%$&/");
		
		emailText.submit();
		nameText.submit();
		passText.submit();
		confirPassText.submit();
		
		bottomRegister.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.manage().timeouts().setScriptTimeout(3, TimeUnit.MINUTES);
		
		//String titulo = driver.getTitle();
		//Assert.assertTrue("Valida el titulo", titulo.contains("Kevin"));
	}
	
	@After
	public void tearDow() throws InterruptedException {
		Thread.sleep(3000);
			driver.quit();
		
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() {
		
		System.out.println("Pruebas finalizadas");
	}
	
}
