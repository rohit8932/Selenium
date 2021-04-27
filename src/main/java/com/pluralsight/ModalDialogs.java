package com.pluralsight;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ModalDialogs {
	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"/src/main/resources/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/modal-dialogs");
		
		driver.findElement(By.id("showSmallModal")).click();
		
		WebElement smallModal = driver.switchTo().activeElement();
		smallModal.findElement(By.id("closeSmallModal")).click();
		
		driver.findElement(By.id("showLargeModal")).click();
		WebElement largeModal = driver.switchTo().activeElement();
		largeModal.findElement(By.id("closeLargeModal")).click();
		
		

		
	    
	}

}
