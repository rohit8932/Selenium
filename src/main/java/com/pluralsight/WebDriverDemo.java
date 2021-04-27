package com.pluralsight;

import java.net.URL;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverDemo {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"/src/main/resources/chromedriver");
//		WebDriver driver = new ChromeDriver();
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
		
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts();
		driver.get("https://www.amazon.in");
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("Laptop");
		search.submit();
		WebElement imageElement = driver.findElements(By.cssSelector("div[class='a-section aok-relative s-image-fixed-height']")).get(0);
		WebElement imageLink = imageElement.findElements(By.tagName("img")).get(0);
		imageLink.click();
		
//		explicit wait
		String xpath = "//div[@id='buyBoxAccordion']/div[contains(.,'Without Exchange')]/*/*/*/i";
		WebElement element = new WebDriverWait(driver, 10, 2000).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		
//		fluent wait
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		
		wait.until(ExpectedConditions.alertIsPresent());
		
		WebElement radioButton = driver.findElement(By.xpath(xpath));
		radioButton.click();
		

	}

}
