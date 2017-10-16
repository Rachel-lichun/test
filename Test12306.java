package com.li.selenium;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Test12306 {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.firefox.bin",
				"F:\\daily\\browser\\firebox\\installpath30\\firefox.exe");
		driver = new FirefoxDriver();
		driver.get("http://www.12306.cn/");
		// 窗口最大化
		driver.manage().window().maximize();
		// 点击 购票
		driver.findElement(By.className("k2")).click();
		// 获取所有的打开窗口的句柄
		Set<String> allWindowsId = driver.getWindowHandles();
		for (String windowsId : allWindowsId) {
			if (driver.switchTo().window(windowsId).getTitle().contains("客运服务")) {
				driver.switchTo().window(windowsId);//锁定购票页面
				break;

			}

		}
		// 等待页面加载
		// 1.显式等待
		WebDriverWait wait = new WebDriverWait(driver, 20);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fromStationText")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.id("fromStationText")));
	
		driver.findElement(By.id("fromStationText")).clear();  
		driver.findElement(By.id("fromStationText")).sendKeys("北京");  
        ((HasInputDevices) driver).getKeyboard().sendKeys(Keys.ARROW_DOWN);  
        //注意这里不能用Keys.ENTER  
        ((HasInputDevices) driver).getKeyboard().sendKeys(Keys.RETURN);  
          
        Thread.sleep(1000);  
        driver.findElement(By.id("toStationText")).clear();  
        driver.findElement(By.id("toStationText")).sendKeys("沈阳");  
        ((HasInputDevices) driver).getKeyboard().sendKeys(Keys.RETURN);  
		

		// <input id="train_date" class="inp-txt" > 日期控件：readonly="readonly". 没法调用WebElement的sendKeys()
		// 方案一：使用JS remove readonly attribute，然后sendKeys

		// remove readonly attribute
		JavascriptExecutor removeAttribute = (JavascriptExecutor) driver;
		removeAttribute
				.executeScript("var setDate=document.getElementById(\"train_date\");setDate.removeAttribute('readonly');");
		// sendKeys
		driver.findElement(By.id("train_date")).clear();
		driver.findElement(By.id("train_date")).sendKeys("2017-07-02");
		driver.findElement(By.id("a_search_ticket")).click();
		
		

	


	}

}
