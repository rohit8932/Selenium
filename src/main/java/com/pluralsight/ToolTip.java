package com.pluralsight;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToolTip {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"/src/main/resources/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.demoqa.com/tool-tips/");
		
		Actions action = new Actions(driver);
		WebElement button = driver.findElement(By.id("toolTipButton"));
		action.moveToElement(button).perform();
		Thread.sleep(2000);
		WebElement toolTip = driver.findElement(By.xpath("//*[@id='buttonToolTip']//div[2]"));
		System.out.println(toolTip.getText());
		
		
		
		
		
		
		
		
	}

}
