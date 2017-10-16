package com.li.selenium;

import java.util.Set;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestTrip {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver;

		// firefox没有安装在默认目录下，需要代码手动启动浏览器。
		System.setProperty("webdriver.firefox.bin","F:\\daily\\browser\\firebox\\installpath30\\firefox.exe");
		driver = new FirefoxDriver();
		// 窗口最大化，防止窗口有遮挡处，无法识别，不能进行自动化操作
		driver.manage().window().maximize();
		driver.get("http://www.ctrip.com/");
		// 用户登录操作
		driver.findElement(By.xpath(".//*[@id='c_ph_login']")).click();
		driver.findElement(By.xpath(".//*[@id='txtUserName']")).sendKeys("18201038718");
		driver.findElement(By.xpath(".//*[@id='txtPwd']")).sendKeys("LL870461912");
		driver.findElement(By.xpath(".//*[@id='btnSubmit']")).click();
		//验证用户登录成功
		String text = driver.findElement(By.id("c_ph_logout")).getText();
		System.out.println(text);
		Assert.assertEquals(text, "退出");
		Thread.sleep(3000); // 在登录页面，点击登录后会跳转网页，此时如果没有等待时间，显示的页面不完整，写入等待代码后，页面显示正常
		
		//選擇城市，日期
		
//		driver.findElement(By.xpath("//a[text()='上海']")).click(); //选择城市-上海
		driver.findElement(By.xpath(".//*[@id='HD_CityName']")).sendKeys("上海");
//		WebElement from = driver.findElement(By.xpath(".//*[@id='HD_CityName']"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].value=\"上海\"", from);
		driver.findElement(By.id("HD_CheckIn")).clear();
		driver.findElement(By.id("HD_CheckIn")).sendKeys("2017-7-8");
		driver.findElement(By.id("HD_CheckOut")).clear();
		driver.findElement(By.id("HD_CheckOut")).sendKeys("2017-7-9");
		//选择酒店级别
		Select select = new Select(driver.findElement(By.id("searchHotelLevelSelect")));
		select.selectByIndex(0);
		// 1
//		Select select = new Select(driver.findElement(By.id("searchHotelLevelSelect")));
//		for(WebElement e: select.getOptions())
//			e.click();
		
		//select.selectByIndex(3);
	     // select.selectByValue("3");
//		select.selectByVisibleText("");

		driver.findElement(By.id("HD_Btn")).click();
		//选价格
	 //  driver.findElement(By.id("price-v150v300")).click();
	   Thread.sleep(5000);
	   //关闭弹出的窗口
	   driver.findElement(By.id("appd_wrap_close")).click();
	   //查看详情
	   driver.findElement(By.xpath(".//*[@id='4399431']/ul/li[3]/div[3]/p[2]/a")).click();
	   Thread.sleep(5000);
	    
	 
	
		String parentWindowId = driver.getWindowHandle();
        System.out.println("driver.getTitle(): " + driver.getTitle());
        Set<String> allWindowsId = driver.getWindowHandles();
        
        // 获取所有的打开窗口的句柄
        for (String windowId : allWindowsId) {
            if (driver.switchTo().window(windowId).getTitle().contains("预定价格")) {
                driver.switchTo().window(windowId);
                break;
            }
        }
        
        System.out.println("driver.getTitle(): " + driver.getTitle());
 	   driver.findElement(By.xpath(".//*[@id='btn_book_now']")).click();
 	   driver.findElement(By.xpath(".//*[@id='J_RoomListTbl']/tbody/tr[3]/td[9]/div/a/div[1]")).click();
        driver.close();
        // 再次切换回原来的父窗口
        driver.switchTo().window(parentWindowId);
        System.out.println("parentWindowId: " + driver.getTitle());
	   //logout
       driver.findElement(By.id("c_ph_logout")).click();
       //验证用户退出成功
       String text3 = driver.findElement(By.id("c_ph_register")).getText();
       System.out.println(text3);
       Assert.assertEquals(text3, "注册");
		
		//driver.quit();  // 关闭浏览器

	}

}
