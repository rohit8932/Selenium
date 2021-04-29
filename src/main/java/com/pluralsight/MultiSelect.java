package com.pluralsight;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelect {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"/src/main/resources/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/select-menu");
		WebElement olderMultiSelect = driver.findElement(By.id("cars"));
		Select select = new Select(olderMultiSelect);
		System.out.println(select.isMultiple());
		select.selectByValue("volvo");
		select.selectByIndex(1);
		select.selectByVisibleText("Audi");
		Thread.sleep(1000);
		List<WebElement> options = select.getOptions();
		for(WebElement element : options) {
			System.out.print(element.getText() + " ");
		}
		select.deselectAll();
		
		WebElement newMultiSelect = driver.findElement(By.xpath("(//*[@class=' css-yk16xz-control'])[3]"));
		newMultiSelect.click();
//		here we cannot use newMultiSelect because dropdown option is not under this
		WebElement dropDownOption = driver.findElement(By.id("react-select-4-option-3"));
		dropDownOption.click();
		
		
	}

}
