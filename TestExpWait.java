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
		 * ��ʽ�ȴ�
		 * ֻ��Ҫ����Ҫִ��ͬ���ĵط�����Ӱ��ű��������ط�
		 * WebdriverWait��ExpectedCondition��ִ����ʽ�ȴ�
		 * ExpectedCondition ���ṩһϵ��Ԥ����õ��������ȴ���
		 * Ԥ��������                                                              ������
                               Ԫ�ؿɼ��ɵ��                                                    elementToBeClickable(By locator)
                               Ԫ�ر�ѡ��                                                            elementToBeSelected(WebElement element)
                               ����һ��Ԫ��                                                         presenceOfElementLocated(By locator)
                               Ԫ���г���ָ���m�ı�                                          textToBePresentInElement(By locator, String text)
                               Ԫ�ذmֵ                                                                 textToBePresentInElementValue(By locator, String text)
                               ����                                                                         titleContains(String title)
		 * 
		 */
		WebDriver driver;
		System.setProperty("webdriver.firefox.bin",
				"E:\\daily\\browser\\firebox\\installpath30\\firefox.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.taobao.com/");
		WebElement login = driver.findElement(By.linkText("��¼"));
		login.click();
		//�л�����
		Set<String> allWindows = driver.getWindowHandles();
		for (String windowsId : allWindows) {
			if (driver.switchTo().window(windowsId).getTitle().contains("�Ա��� - �ԣ���ϲ��")) {
				driver.switchTo().window(windowsId);
				
			}
			
		}
		//���õȴ�10s
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//�ȴ�ֱ����Ҫ�ĵ����ݳ���,��ʱ�����־ͱ���
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("�����¼")));
		driver.findElement(By.linkText("�����¼")).click();
		
	}

}
