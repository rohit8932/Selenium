package com.pluralsight;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonTest {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"/src/main/resources/chromedriver");
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("file:///home/rohit/eclipse-workspace/WebDriverDemo/src/main/webapp/RadioButtonTest.html");
		
		List<WebElement> radioButtons= driver.findElements(By.name("color"));
		radioButtons.get(1).click();
		
		for(WebElement radioButton : radioButtons) {
			System.out.println(radioButton.getAttribute("value"));
			System.out.println(radioButton.isSelected());
		}
		
		
		
	}

}
