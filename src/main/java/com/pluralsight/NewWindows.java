package com.pluralsight;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewWindows {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"/src/main/resources/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.demoqa.com/browser-windows");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		String originalWindow = driver.getWindowHandle();
		driver.findElement(By.id("tabButton")).click();
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		
		
		for(String window: driver.getWindowHandles()) {
			if(!window.equals(originalWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
		
		System.out.println(driver.findElement(By.id("sampleHeading")).getText());
		driver.close();
		driver.switchTo().window(originalWindow);
		System.out.println(driver.findElement(By.cssSelector(".main-header")).getText());
		
		
	}

}
