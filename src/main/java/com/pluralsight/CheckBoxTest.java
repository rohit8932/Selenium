package com.pluralsight;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxTest {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"/src/main/resources/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///home/rohit/eclipse-workspace/WebDriverDemo/src/main/webapp/CheckboxTest.html");
		
		WebElement lettuceCheckbox = driver.findElement(By.id("lettuceCheckbox"));
		lettuceCheckbox.click();
		
		
		
	}

}
