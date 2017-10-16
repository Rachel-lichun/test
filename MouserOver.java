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
		
		//��һ�����ҵ�Ԫ��
		WebElement element = driver.findElement(By.linkText("�ҵľ���"));
		
		// �ڶ�����Actions WebDriver ��װ��һ��ģ�������̵�һ���ࣻ������new һ��Actions����
		Actions bulider = new Actions(driver);
		
		// ��������������ƶ������ҵľ��������Ԫ�����棬��ģ����¼�������һ������������û���ͷš�
		Action mouserOverLogin = bulider.moveToElement(element).build();
		
		// ���Ĳ�������perform�����ͷ�֮ǰ�����Ĳ�����
		mouserOverLogin.perform();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.linkText("��������")).click();

	}

}
