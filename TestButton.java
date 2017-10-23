package com.li.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.assertTrue;

public class TestButton {

	/**
	 * @param args
	 */
		
	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.firefox.bin",
				"E:\\daily\\browser\\firebox\\installpath30\\firefox.exe");
		driver = new FirefoxDriver();
		driver.get("E:\\test\\html\\button.html");
		WebElement man = driver.findElement(By.id("man"));
		//检查是否已选择，若未选，则选中
		if (!man.isSelected()) {
			man.click();
		}
		//验证是否选中
		assertTrue(man.isSelected());
		
		//复杂的选择方法
		//得到所有按钮
	List<WebElement>sex = driver.findElements(By.id("sex"));
	//遍历所有按钮，查看是否被选中，如果没有选中，则点击选中
	for (WebElement all : sex) {
		if (all.getAttribute("id").equals("man")) {
			if (!all.isSelected()) {
				all.click();
			}
			
		}
		
	}
	
	}

}
