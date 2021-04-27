package com.pluralsight;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"/src/main/resources/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.demoqa.com/frames");
		
		driver.switchTo().frame("frame1");
		System.out.println(driver.findElement(By.id("sampleHeading")).getText());
		
		driver.switchTo().defaultContent();
		System.out.println(driver.findElement(By.cssSelector(".main-header")).getText());
		
		driver.switchTo().frame(1);
		System.out.println(driver.findElement(By.id("sampleHeading")).getText());
		
	}

}
