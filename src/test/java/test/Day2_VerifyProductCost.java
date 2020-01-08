package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import test.guru99.base.Browser;

public class Day2_VerifyProductCost extends Browser{

	public Day2_VerifyProductCost(WebDriver driver) {
		super(driver);
	}

	public static void main(String[] args) throws Exception {
		
		Browser browser = new Browser(driver);
		browser.getDriver("chrome");
		browser.launchApplication(driver, "http://live.demoguru99.com/index.php/");
		Assert.assertEquals(driver.getTitle(), "Home page");
		driver.findElement(By.xpath("//*[text()='Mobile']")).click();
		Assert.assertEquals(driver.getTitle(), "Mobile");	
		
		String pricegrid  = "";
		List<WebElement> getprice = driver.findElements(By.xpath("//*[@class='product-name']/following::div/span/span[text()]"));
		for(WebElement a: getprice) {
			pricegrid = a.getText();
			break;
		}
		driver.findElement(By.xpath("//*[text()='Sony Xperia']")).click();
		String pricedetail = driver.findElement(By.xpath("//*[@class='price']")).getText();
		Assert.assertEquals(pricegrid, pricedetail);			
	}

}
