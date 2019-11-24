package com.disenoexperimentos.lab;

import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class PruebasFuncionales {
	
	private WebDriver driver;
	
	@Test
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/ChromeDriver/chromedriver.exe");	
		driver=new ChromeDriver ();
		
		driver.manage().window().maximize();
		
		driver.get("https://localhost:8080/empleado/registro");
		
		
		String nombre = "Jorge Landaverry";
		String direccion = "Av. Central #429 Urb. Santa Luisa";
		String celular = "999771220";
		
		WebElement wnombre=driver.findElement(By.id("nombre"));
		wnombre.sendKeys(nombre);
		WebElement wdireccion=driver.findElement(By.id("direccion"));
		wdireccion.sendKeys(direccion);
		WebElement wcelular=driver.findElement(By.id("celular"));
		wcelular.sendKeys(celular);
		WebElement registra=driver.findElement(By.id("Registra"));
		registra.click()
		
		//Registrar una venta
		String fecha = "24/11/2019";
		String cliente = "";
		String metodopago = "1600000000000000";
		String producto = "1";
		String cantidad = "2";
		
		WebElement wfecha=driver.findElement(By.id("fecha"));
		wfecha.sendKeys(fecha);
		WebElement wcliente=driver.findElement(By.id("cliente"));
		wcliente.sendKeys(cliente);
		WebElement wmetodopago=driver.findElement(By.id("metodopago"));
		wmetodopago.sendKeys(metodopago);
		WebElement wproducto=driver.findElement(By.id("producto"));
		wproducto.sendKeys(producto);
		WebElement wcantidad=driver.findElement(By.id("cantidad"));
		wcantidad.sendKeys(cantidad);
		WebElement wregistra=driver.findElement(By.id("Ordenar"));
		registra.click();
		
		//Registrar una promocion
		driver.get("https://localhost:8080/empleado/registro");
		
		String producto1 = "1";
		String cantidad1 = "2";
		String producto2 = "2";
		String cantidad2 = "2";
		String producto3 = "3";
		String cantidad3 = "1";
		String descripcion = "Dos hamburguesas con dos milkshakes y una porción de papas grandes";
		String activa = "1";
		
		WebElement wproducto1=driver.findElement(By.id("producto"));
		wproducto1.sendKeys(producto1);
		WebElement wcantidad1=driver.findElement(By.id("cantidad"));
		wcantidad1.sendKeys(cantidad1);
		WebElement agregar=driver.findElement(By.id("Agregar"));
		agregar.click();
		WebElement wproducto2=driver.findElement(By.id("producto"));
		wproducto2.sendKeys(producto2);
		WebElement wcantidad2=driver.findElement(By.id("cantidad"));
		wcantidad2.sendKeys(cantidad2);
		agregar.click();
		WebElement wproducto3=driver.findElement(By.id("producto"));
		wproducto3.sendKeys(producto3);
		WebElement wcantidad3=driver.findElement(By.id("cantidad"));
		wcantidad3.sendKeys(cantidad3);
		agregar.click();
		WebElement wdescripcion=driver.findElement(By.id("descripcion"));
		wdescripcion.sendKeys(descripcion);
		WebElement wactiva=driver.findElement(By.id("activa"));
		wactiva.sendKeys(activa);
		WebElement crear=driver.findElement(By.id("Crear"));
		crear.click();
		
		//Registrar venta con stock agotado
		driver.get("https://localhost:8080/empleado/registro");
		
		String efecha = "24/11/2019";
		String ecliente = "";
		String emetodopago = "1600000000000000";
		String eproducto = "1";
		String ecantidad = "2";
		
		WebElement wefecha=driver.findElement(By.id("fecha"));
		wefecha.sendKeys(efecha);
		WebElement wecliente=driver.findElement(By.id("cliente"));
		wecliente.sendKeys(ecliente);
		WebElement wemetodopago=driver.findElement(By.id("metodopago"));
		wemetodopago.sendKeys(emetodopago);
		WebElement weproducto=driver.findElement(By.id("producto"));
		weproducto.sendKeys(eproducto);
		WebElement wecantidad=driver.findElement(By.id("cantidad"));
		wecantidad.sendKeys(ecantidad);
		WebElement weregistra=driver.findElement(By.id("Ordenar"));
		registra.click();
	}
	@After

	public void tearDown() {
		
		driver.quit();
	}
	
}