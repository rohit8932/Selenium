package com.pluralsight;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectElement {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"/src/main/resources/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.get("file:///home/rohit/eclipse-workspace/WebDriverDemo/src/main/webapp/SelectItemTest.html");
//		WebElement selectElement = driver.findElement(By.id("select1"));
//		Select select = new Select(selectElement);
////		select.selectByVisibleText("No");
//		select.selectByValue("maybe");
		
		driver.get("https://demoqa.com/automation-practice-form");
		
		WebElement state = driver.findElement(By.id("state"));
		state.click();
		state.findElement(By.id("react-select-3-option-3")).click();
		
		WebElement city = driver.findElement(By.id("city"));
		city.click();
		city.findElement(By.id("react-select-4-option-1")).click();
	}

}
