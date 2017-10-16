package com.li.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MouserOver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.firefox.bin",
				"F:\\daily\\browser\\firebox\\installpath30\\firefox.exe");
		
		driver = new FirefoxDriver();
		driver.get("https://www.jd.com/");
		
		//第一步，找到元素
		WebElement element = driver.findElement(By.linkText("我的京东"));
		
		// 第二步：Actions WebDriver 封装的一个模拟鼠标键盘的一个类；这里先new 一个Actions对象
		Actions bulider = new Actions(driver);
		
		// 第三步：将鼠标移动到【我的京东】这个元素上面，将模拟的事件构建成一个操作，但并没有释放。
		Action mouserOverLogin = bulider.moveToElement(element).build();
		
		// 第四步：调用perform方法释放之前构建的操作。
		mouserOverLogin.perform();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.linkText("待处理订单")).click();

	}

}
