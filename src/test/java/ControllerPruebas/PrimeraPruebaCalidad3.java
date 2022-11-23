package ControllerPruebas;

import static org.junit.Assert.assertEquals;

import java.util.List;
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
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class PrimeraPruebaCalidad3 {
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
		
		Thread.sleep(2000);
		WebElement elementToHover = driver.findElement(By.id("top_menu"));
		List<WebElement> elementos = elementToHover.findElements(By.tagName("li"));
		
		WebElement elemento = elementos.get(1);
		System.out.println(elemento.getText());
		elemento.click();
		
		WebElement elementToHover2 = elemento.findElement(By.className("dropdown-menu"));
		List<WebElement> elementos2 = elementToHover2.findElements(By.tagName("li"));
		WebElement elemento2 = elementos2.get(2);
		elemento2.click();
		
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
