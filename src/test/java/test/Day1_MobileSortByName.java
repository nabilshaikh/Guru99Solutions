package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.google.common.base.CharMatcher;

import test.guru99.base.Browser;

public class Day1_MobileSortByName extends Browser{
	
	
	public Day1_MobileSortByName(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		Browser browser = new Browser(driver);
		browser.getDriver("chrome");
		browser.launchApplication(driver, "http://live.demoguru99.com/index.php/");
		Assert.assertEquals(driver.getTitle(), "Home page");
		driver.findElement(By.xpath("//*[text()='Mobile']")).click();
		Assert.assertEquals(driver.getTitle(), "Mobile");
	
		Select select = new Select(driver.findElement(By.xpath("//select[@title='Sort By']")));
		select.selectByVisibleText("Name");
		Assert.assertTrue(driver.getCurrentUrl().contains("order=name"));
		
		int prodbyname = driver.findElements(By.xpath("//div[@class='category-products']/ul/li")).size();
		System.out.println(prodbyname);

		List<WebElement> links =driver.findElements(By.xpath("//*[contains(text(), 'Item(s)')]"));
		//Storing List elements text into String
		String temp = null;
		for(WebElement a: links) {
			temp = a.getText();
			break;
		}		
		Assert.assertEquals(CharMatcher.inRange('0', '9').retainFrom(temp), String.valueOf(prodbyname));
		
		Thread.sleep(3000);
		driver.quit();		
	}
	
	

}
