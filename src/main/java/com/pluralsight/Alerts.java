package com.pluralsight;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alerts {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"/src/main/resources/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.demoqa.com/alerts");

		System.out.println("==Normal alert having only OK==");
		driver.findElement(By.id("alertButton")).click();
		WebDriverWait wait = new WebDriverWait(driver, 20, 5000);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(alert.getText());
		alert.dismiss();
		
		System.out.println("==Aler will come after 5 second==");
		driver.findElement(By.id("timerAlertButton")).click();
		alert = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(alert.getText());
		alert.accept();
		
		System.out.println("==Cancel/OK==");
		driver.findElement(By.id("confirmButton")).click();
		driver.switchTo().alert().dismiss();
		System.out.println(wait.until(ExpectedConditions.presenceOfElementLocated(By.id("confirmResult"))).getText());
		
		System.out.println("==Prompt==");
		driver.findElement(By.id("promtButton")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		alert = driver.switchTo().alert();
		alert.sendKeys("Rohit Rajak");
		alert.accept();
		System.out.println(driver.findElement(By.id("promptResult")).getText());
		
		
		
	}

}
