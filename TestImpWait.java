package com.li.selenium;

import static org.junit.Assert.assertTrue;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestImpWait {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * 隐式等待 使用隐式等待执行测试，若webdriver 没有在DOM中找到元素，将继续等待，超出设定时间后则抛出找不到元素的异常
		 * 一旦设置隐式等待，将存在整个webdriver对象实例的生命周期中。
		 * 隐式等待会让一个正常响应的应用的测试变慢，它将会在寻找每个元素时都进行等待，就增加了整个测试执行的时间 应避免使用或减少使用隐式等待
		 */
		WebDriver driver;
		System.setProperty("webdriver.firefox.bin",
				"E:\\daily\\browser\\firebox\\installpath30\\firefox.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.taobao.com/");
		// 设置隐式等待，等待页面加载
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// WebElement login = driver.findElement(By.name("登录"));
		WebElement login = driver.findElement(By.linkText("登录"));
		login.click();
		// 切换窗口
		Set<String> allWindows = driver.getWindowHandles();
		for (String windowId : allWindows) {
			if (driver.switchTo().window(windowId).getTitle()
					.contains("淘宝网 - 淘！我喜欢 ")) {
				driver.switchTo().window(windowId);
			}

		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.linkText("密码登录")).click();
		WebElement username = driver.findElement(By.className("ph-label"));
		System.out.println(username.getText());
		assertTrue(username.getText().contains("会员名/邮箱/手机号"));

	}

}
