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
		 * ��ʽ�ȴ� ʹ����ʽ�ȴ�ִ�в��ԣ���webdriver û����DOM���ҵ�Ԫ�أ��������ȴ��������趨ʱ������׳��Ҳ���Ԫ�ص��쳣
		 * һ��������ʽ�ȴ�������������webdriver����ʵ�������������С�
		 * ��ʽ�ȴ�����һ��������Ӧ��Ӧ�õĲ��Ա�������������Ѱ��ÿ��Ԫ��ʱ�����еȴ�������������������ִ�е�ʱ�� Ӧ����ʹ�û����ʹ����ʽ�ȴ�
		 */
		WebDriver driver;
		System.setProperty("webdriver.firefox.bin",
				"E:\\daily\\browser\\firebox\\installpath30\\firefox.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.taobao.com/");
		// ������ʽ�ȴ����ȴ�ҳ�����
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// WebElement login = driver.findElement(By.name("��¼"));
		WebElement login = driver.findElement(By.linkText("��¼"));
		login.click();
		// �л�����
		Set<String> allWindows = driver.getWindowHandles();
		for (String windowId : allWindows) {
			if (driver.switchTo().window(windowId).getTitle()
					.contains("�Ա��� - �ԣ���ϲ�� ")) {
				driver.switchTo().window(windowId);
			}

		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.linkText("�����¼")).click();
		WebElement username = driver.findElement(By.className("ph-label"));
		System.out.println(username.getText());
		assertTrue(username.getText().contains("��Ա��/����/�ֻ���"));

	}

}
