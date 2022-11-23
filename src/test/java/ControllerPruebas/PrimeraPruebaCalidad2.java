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

public class PrimeraPruebaCalidad2 {
	private static WebDriver driver;
	private String URL = "https://www.yoytec.com/";
	
	
	
	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("Inicio de las pruebas automatizadas");
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
	
	}
	
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
	}
	
	
	@Test
	public void testIniciarSesion() throws InterruptedException {
		Thread.sleep(3000);
		WebElement bottomLogin = driver.findElement(By.className("te_user_account_name"));
		bottomLogin.click();
		
		WebElement emailText = driver.findElement(By.name("login"));
		WebElement passText = driver.findElement(By.name("password"));
		WebElement bottomIniciar = driver.findElement(By.className("btn"));
		
		emailText.sendKeys("melo.near.m@gmail.com");
		passText.sendKeys("Pass1234%$&/");
		
		emailText.submit();
		passText.submit();
		
		
		bottomIniciar.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
