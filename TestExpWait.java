package com.li.selenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestExpWait {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * 显式等待
		 * 只需要在需要执行同步的地方而不影响脚本的其他地方
		 * WebdriverWait和ExpectedCondition来执行显式等待
		 * ExpectedCondition 类提供一系列预定义好的条件来等待。
		 * 预定义条件                                                              方法名
                               元素可见可点击                                                    elementToBeClickable(By locator)
                               元素被选中                                                            elementToBeSelected(WebElement element)
                               存在一个元素                                                         presenceOfElementLocated(By locator)
                               元素中出现指定癿文本                                          textToBePresentInElement(By locator, String text)
                               元素癿值                                                                 textToBePresentInElementValue(By locator, String text)
                               标题                                                                         titleContains(String title)
		 * 
		 */
		WebDriver driver;
		System.setProperty("webdriver.firefox.bin",
				"E:\\daily\\browser\\firebox\\installpath30\\firefox.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.taobao.com/");
		WebElement login = driver.findElement(By.linkText("登录"));
		login.click();
		//切换窗口
		Set<String> allWindows = driver.getWindowHandles();
		for (String windowsId : allWindows) {
			if (driver.switchTo().window(windowsId).getTitle().contains("淘宝网 - 淘！我喜欢")) {
				driver.switchTo().window(windowsId);
				
			}
			
		}
		//设置等待10s
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//等待直到需要的的内容出现,超时不出现就报错
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("密码登录")));
		driver.findElement(By.linkText("密码登录")).click();
		
	}

}
