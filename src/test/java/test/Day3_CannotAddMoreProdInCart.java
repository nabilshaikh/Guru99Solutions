package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import test.guru99.base.Browser;

public class Day3_CannotAddMoreProdInCart extends Browser{

	public Day3_CannotAddMoreProdInCart(WebDriver driver) {
		super(driver);
	}

	public static void main(String[] args) throws Exception {
		
		Browser browser = new Browser(driver);
		browser.getDriver("chrome");
		browser.launchApplication(driver, "http://live.demoguru99.com/index.php/");
		Assert.assertEquals(driver.getTitle(), "Home page");
		driver.findElement(By.xpath("//*[text()='Mobile']")).click();
		Assert.assertEquals(driver.getTitle(), "Mobile");		
		driver.findElement(By.xpath("//a[@title='Sony Xperia']/following::div/button[@title='Add to Cart']")).click();
		Assert.assertEquals(driver.getTitle(), "Shopping Cart");
		driver.findElement(By.xpath("//input[@title='Qty']")).sendKeys("1000");
		driver.findElement(By.xpath("//button[@title='Update']")).click();
		Assert.assertEquals("* The maximum quantity allowed for purchase is 500." , driver.findElement(By.xpath("//*[contains(text(), 'The maximum quantity allowed for purchase is 500')]")).getText());
		driver.findElement(By.xpath("//button[@title='Empty Cart']")).click();
		Assert.assertEquals("SHOPPING CART IS EMPTY" , driver.findElement(By.xpath("//*[text()='Shopping Cart is Empty']")).getText());
		String abc = driver.findElement(By.xpath("//*[text()='Cart']/following-sibling::span")).getText();
		System.out.println(abc.toString());
		
	}

}
