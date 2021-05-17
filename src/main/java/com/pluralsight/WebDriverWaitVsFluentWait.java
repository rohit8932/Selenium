package com.pluralsight;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class WebDriverWaitVsFluentWait {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"/src/main/resources/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		
		
		
		
		
		
		
		try {
			driver.get("https://www.google.com");
			
//			driver.findElement(By.xpath("//*[@id='rohit']"));
//			WebDriverWait wait = new WebDriverWait(driver, 3);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='rohit']")));

			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.withTimeout(5, TimeUnit.SECONDS)
					.pollingEvery(1,TimeUnit.SECONDS)
					.ignoring(NoSuchElementException.class);
			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='rohit']")));
			
			WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver) {
			       return driver.findElement(By.id("foo"));
			     }
			   });
			
			System.out.println("Last Line");

		} finally {
			driver.quit();
		}
		
		
		
		
	}

}
