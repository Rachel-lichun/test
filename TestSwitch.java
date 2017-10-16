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
		// ��Я�̹���
		driver.get("http://www.ctrip.com/");
		driver.manage().window().maximize();
		// ��ͼ
		Snapshot((TakesScreenshot) driver, "baidu.png");
		// ѡ����б���
		driver.findElement(By.id("HD_CityName")).sendKeys("����");

		// ������ѡ���Ǽ��Ƶ�
		WebElement startElement = driver.findElement(By
				.id("searchHotelLevelSelect"));
		Select select = new Select(startElement);
		select.selectByIndex(3);

		// �رյ����Ĺ�洰��
		driver.findElement(By.id("appd_wrap_close")).click();

		// ���������ť
		driver.findElement(By.id("HD_Btn")).click();

		// �ȴ�ʱ��
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// ����鿴���飬��һ���´���
		driver.findElement(By.linkText("�鿴����")).click();

		// ��ȡ��ǰ���ڵ�handle����������ҳ��A
		String parentWindowId = driver.getWindowHandle();
		System.out.println("driver.getTitle()��" + driver.getTitle());

		// ��ȡ���д򿪴��ڵ�id
		Set<String> allSetWindowsId = driver.getWindowHandles();

		// �л�����B
		for (String windowsId : allSetWindowsId) {
			if (driver.switchTo().window(windowsId).getTitle().contains("Ԥ���۸�")) {
				driver.switchTo().window(windowsId);
				break;
			}
			System.out.println("driver.getTitle():" + driver.getTitle());

			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// �л���ԭ����A
			driver.switchTo().window(parentWindowId);

		}

	}

	public static void Snapshot(TakesScreenshot drivername, String filename) {
		// �����ͼ����·��
		String currentPath = "E:";
		System.out.println(currentPath);
		// ���ý�ͼ������������ͼ�ļ�
		File srcFile = drivername.getScreenshotAs(OutputType.FILE);
		try {
			// ���Ƶ�ָ��Ŀ¼
			System.out.println("save snapshot path is:" + currentPath + "/"
					+ filename);
			FileUtils
					.copyFile(srcFile, new File(currentPath + "\\" + filename));
		} catch (IOException e) {
			// ʧ�ܴ�ӡ������Ϣ
			System.out.println("cannot save screenshot");
			e.printStackTrace();
		} finally {
			System.out.println("screen shot finished");
		}
	}

}
