package com.pluralsight;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RobotAndActionsClass {
	public static void main(String[] args) throws AWTException {
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"/src/main/resources/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		
		Actions action = new Actions(driver);

		WebElement search = driver.findElement(By.name("q"));
	    action.keyDown(Keys.SHIFT).sendKeys(search,"qwerty").keyUp(Keys.SHIFT).sendKeys("qwerty")
	    .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
	    
	    String currentHandle = driver.getWindowHandle();
	    
	    Robot r = new Robot();
	    r.keyPress(KeyEvent.VK_CONTROL);
	    r.keyPress(KeyEvent.VK_T);

	    r.keyRelease(KeyEvent.VK_CONTROL);
	    r.keyRelease(KeyEvent.VK_T);
	    
	    Set<String> handles = driver.getWindowHandles();
	    
	    for(String handle : handles) {
	    	if(!handle.equalsIgnoreCase(currentHandle)) {
	    		driver.switchTo().window(handle);
	    		break;
	    	}
	    }
	    
	    
	    driver.get("https://www.google.com");

	    search = driver.findElement(By.name("q"));
	    action.keyDown(Keys.SHIFT).sendKeys(search,"rohit").keyUp(Keys.SHIFT).sendKeys("Rohit")
	    .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
	 
	    
		
	}

}
