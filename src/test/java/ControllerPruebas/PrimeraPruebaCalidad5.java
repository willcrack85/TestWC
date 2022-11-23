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

public class PrimeraPruebaCalidad5 {
	private static WebDriver driver;
	private String URL = "https://www.yoytec.com/shop/category/componentes-375";
	
	
	
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
		
		WebElement elementToHover = driver.findElement(By.className("table"));
		List<WebElement> elementos = elementToHover.findElements(By.tagName("tbody"));
		
		WebElement elemento = elementos.get(0);
		
		WebElement elementToHover2 = elemento.findElement(By.tagName("tr"));
		List<WebElement> elementos2 = elementToHover2.findElements(By.tagName("td"));
		
		WebElement elemento2 = elementos2.get(2);
		
		WebElement elementToHover3 = elemento2.findElement(By.className("o_wsale_product_grid_wrapper"));
		List<WebElement> elementos3 = elementToHover3.findElements(By.className("card"));
		
		WebElement elemento3 = elementos3.get(0);
		
		/////////////////////////////////////////77777
		WebElement elementToHover4 = elemento3.findElement(By.className("p-0"));
		List<WebElement> elementos4 = elementToHover4.findElements(By.tagName("div"));
		
		
		WebElement elemento4 = elementos4.get(3);
		//WebElement elementToHover5 = elemento4.findElement(By.className("o_wsale_product_btn"));
		List<WebElement> elementos5 = elemento4.findElements(By.tagName("a"));
		System.out.println("Peso: "+elementos5.size());
		
		for(WebElement items: elementos5) {
			System.out.println("Letras: "+items.getText());
		}
		
		WebElement elemento5 = elementos5.get(1);
		elemento5.click();
		/*
		 * Procedimiento para agregar o restar productos similares a la compra 
		 * */
		Thread.sleep(3000);
		WebElement elementCarrito = driver.findElement(By.className("mb64"));
		List<WebElement> resultadoElementos = elementCarrito.findElements(By.tagName("tbody"));
		WebElement resultado = resultadoElementos.get(0);
		
		WebElement elementCarrito2 = resultado.findElement(By.tagName("tr"));
		List<WebElement> resultadoElementos2 = elementCarrito2.findElements(By.tagName("td"));
		WebElement resultado2 = resultadoElementos2.get(3);
		
		WebElement elementCarrito3 = resultado2.findElement(By.className("css_quantity"));
		List<WebElement> resultadoElemento3 = elementCarrito3.findElements(By.tagName("div"));
		WebElement resultado3 = resultadoElemento3.get(1);
		
		resultado3.click();
		resultado3.click();
		resultado3.click();
		
		
		resultado3 = resultadoElemento3.get(0);
		resultado3.click();
		resultado3.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.manage().timeouts().setScriptTimeout(3, TimeUnit.MINUTES);
		
		//String titulo = driver.getTitle();
		//Assert.assertTrue("Valida el titulo", titulo.contains("Kevin"));
	}
	
	@After
	public void tearDow() throws InterruptedException {
		Thread.sleep(4000);
			driver.quit();
		
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() {
		
		System.out.println("Pruebas finalizadas");
	}
	
}
