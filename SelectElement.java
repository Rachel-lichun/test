package com.li.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.firefox.bin",
				"F:\\daily\\browser\\firebox\\installpath30\\firefox.exe");
		driver = new FirefoxDriver();
		driver.get("http://www.ctrip.com/");
		driver.manage().window().maximize();

		// ������ select code
		/*
		 * <select id="searchHotelLevelSelect" name="Star"> <option
		 * value="0"selected="selected">����</option> <option
		 * value="5">���Ǽ�/����</option> <option value="4">���Ǽ�/�ߵ�</option> <option
		 * value="3">���Ǽ�/����</option> <option value="2">���Ǽ�����/����</option>
		 * </select>
		 */

		// select ����������
		/*
		 * 1.����������в���ʱ����Ҫ��λ�����������
		 * 2.new һ��Selcet����Ȼ��������в�����
		 * 3.ͨ������select�����װ�õķ���������ѡ��3�ַ�����
		 */

		WebElement element = driver.findElement(By.id("searchHotelLevelSelect"));
		Select select = new Select(element);
		//select.selectByIndex(1);
		select.selectByVisibleText("���Ǽ�");
		

	}

}
