package com.li.selenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.assertEquals;

public class CheckElement {

	/**
	 * @param 检查元素文本，属性值，css属性值
	 */
	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.firefox.bin",
				"E:\\daily\\browser\\firebox\\installpath30\\firefox.exe");
		driver = new FirefoxDriver();
		
		driver.get("http://baidu.com");
		driver.manage().window().maximize();
//		一.检查元素文本
		// 第一步：获得元素
		WebElement element = driver.findElement(By.id("setf"));
	   // 第二步：得到元素文本
		String text = element.getText();// getText()返回的innerText属性
		// 第三步：验证文本
		/*
		 * assertEquals数原型1：assertEquals([String message],expected,actual) 参数说明：
	     * message是个可选的消息，假如提供，将会在发生错误时报告这个消息。 expected是期望值，通常都是用户指定的内容。
		 * actual是被测试的代码返回的实际值。
		 */
		System.out.println("before");
		assertEquals("fail", "把百度设为主页", text);
		System.out.println("after");
		
		
//		二.检查元素的属性值（创建测试类验证元素属性是否正确）
		/*
		 * 通过title识别处理切换窗口
		 * 用JS打开一个新窗口，当前窗口是百度页面，需要切换到新窗口，输入新的网址
		 * 本次通过handle和title结合来切换窗口
		 */
		// 打开一个新窗口
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.open();");
		//获取所有窗口的句柄
		Set<String> allId=driver.getWindowHandles();
		//切换窗口目前接触到有3种方法
		//方法1：通过title识别处理切换窗口
		for (String id : allId) {
			if (driver.switchTo().window(id).getTitle().equals("新标签页")) {
				driver.switchTo().window(id);
				System.out.println(driver.getTitle());
			}
			
		}
		//方法2： 通过网页内容切换窗口
		
//		for (String id : allId) {
//			if (driver.getPageSource().contains("")) {
//				driver.switchTo().window(id);
//			}
//		}
		
		//方法3：通过窗口的name属性
		//switchTo().window() ,需要知道窗口的name属性。在此，此方法不适合
//		driver.switchTo().window("name");
		
		
		driver.get("http://www.ziroom.com");
		System.out.println("driver.getTitle():" + driver.getTitle());
		driver.manage().window().maximize();
		driver.findElement(By.id("searchTxt")).click();
		WebElement styleElement = driver.findElement(By.id("searchType"));
		System.out.println(styleElement.getAttribute("class"));
		System.out.println(styleElement.getAttribute("style"));
		}

}
