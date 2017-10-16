package com.li.selenium;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestSwitch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.firefox.bin",
				"F:\\daily\\browser\\firebox\\installpath30\\firefox.exe");
		driver = new FirefoxDriver();
		// 打开携程官网
		driver.get("http://www.ctrip.com/");
		driver.manage().window().maximize();
		// 截图
		Snapshot((TakesScreenshot) driver, "baidu.png");
		// 选择城市北京
		driver.findElement(By.id("HD_CityName")).sendKeys("北京");

		// 下拉框选择星级酒店
		WebElement startElement = driver.findElement(By
				.id("searchHotelLevelSelect"));
		Select select = new Select(startElement);
		select.selectByIndex(3);

		// 关闭弹出的广告窗口
		driver.findElement(By.id("appd_wrap_close")).click();

		// 点击搜索按钮
		driver.findElement(By.id("HD_Btn")).click();

		// 等待时间
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 点击查看详情，打开一个新窗口
		driver.findElement(By.linkText("查看详情")).click();

		// 获取当前窗口的handle，即是详情页面A
		String parentWindowId = driver.getWindowHandle();
		System.out.println("driver.getTitle()：" + driver.getTitle());

		// 获取所有打开窗口的id
		Set<String> allSetWindowsId = driver.getWindowHandles();

		// 切换窗口B
		for (String windowsId : allSetWindowsId) {
			if (driver.switchTo().window(windowsId).getTitle().contains("预定价格")) {
				driver.switchTo().window(windowsId);
				break;
			}
			System.out.println("driver.getTitle():" + driver.getTitle());

			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// 切换回原窗口A
			driver.switchTo().window(parentWindowId);

		}

	}

	public static void Snapshot(TakesScreenshot drivername, String filename) {
		// 定义截图保存路径
		String currentPath = "E:";
		System.out.println(currentPath);
		// 调用截图方法，创建截图文件
		File srcFile = drivername.getScreenshotAs(OutputType.FILE);
		try {
			// 复制到指定目录
			System.out.println("save snapshot path is:" + currentPath + "/"
					+ filename);
			FileUtils
					.copyFile(srcFile, new File(currentPath + "\\" + filename));
		} catch (IOException e) {
			// 失败打印错误信息
			System.out.println("cannot save screenshot");
			e.printStackTrace();
		} finally {
			System.out.println("screen shot finished");
		}
	}

}
