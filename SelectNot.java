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
		 * 下拉框处理，非select标签
		 * <div id="searchList" class="s menu list">
		 *  <p id="searchTxt"data-val="2"> 合租 <b></b> </p>
		 *  <div id="searchType" class="c menu_c"style="display: none;">
		 *  <span data-val="2">合租 </span> 
		 *  <span data-val="1">整租 </span> </div> </div>
		 
		 */
		//1，先让下拉框显示出来。2，定位要选中的元素
		
		driver.findElement(By.id("searchTxt")).click();
		driver.findElement(By.xpath(".//*[@id='searchType']/span[2]")).click();

	}

}
