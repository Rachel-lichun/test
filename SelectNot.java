package com.li.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelectNot {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		WebDriver driver;
		System.setProperty("webdriver.firefox.bin",
				"F:\\daily\\browser\\firebox\\installpath30\\firefox.exe");
		driver = new FirefoxDriver();
		driver.get("http://www.ziroom.com/");
		
		/*
		 * ����������select��ǩ
		 * <div id="searchList" class="s menu list">
		 *  <p id="searchTxt"data-val="2"> ���� <b></b> </p>
		 *  <div id="searchType" class="c menu_c"style="display: none;">
		 *  <span data-val="2">���� </span> 
		 *  <span data-val="1">���� </span> </div> </div>
		 
		 */
		//1��������������ʾ������2����λҪѡ�е�Ԫ��
		
		driver.findElement(By.id("searchTxt")).click();
		driver.findElement(By.xpath(".//*[@id='searchType']/span[2]")).click();

	}

}
