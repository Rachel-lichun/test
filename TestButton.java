package com.li.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.assertTrue;

public class TestButton {

	/**
	 * @param args
	 */
		
	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.firefox.bin",
				"E:\\daily\\browser\\firebox\\installpath30\\firefox.exe");
		driver = new FirefoxDriver();
		driver.get("E:\\test\\html\\button.html");
		WebElement man = driver.findElement(By.id("man"));
		//����Ƿ���ѡ����δѡ����ѡ��
		if (!man.isSelected()) {
			man.click();
		}
		//��֤�Ƿ�ѡ��
		assertTrue(man.isSelected());
		
		//���ӵ�ѡ�񷽷�
		//�õ����а�ť
	List<WebElement>sex = driver.findElements(By.id("sex"));
	//�������а�ť���鿴�Ƿ�ѡ�У����û��ѡ�У�����ѡ��
	for (WebElement all : sex) {
		if (all.getAttribute("id").equals("man")) {
			if (!all.isSelected()) {
				all.click();
			}
			
		}
		
	}
	
	}

}
