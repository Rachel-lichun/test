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

		// 下拉框 select code
		/*
		 * <select id="searchHotelLevelSelect" name="Star"> <option
		 * value="0"selected="selected">不限</option> <option
		 * value="5">五星级/豪华</option> <option value="4">四星级/高档</option> <option
		 * value="3">三星级/舒适</option> <option value="2">二星级以下/经济</option>
		 * </select>
		 */

		// select 下拉框处理步骤
		/*
		 * 1.对下拉框进行操作时首先要定位到这个下拉框，
		 * 2.new 一个Selcet对象，然后对它进行操作。
		 * 3.通过调用select对象封装好的方法来进行选择（3种方法）
		 */

		WebElement element = driver.findElement(By.id("searchHotelLevelSelect"));
		Select select = new Select(element);
		//select.selectByIndex(1);
		select.selectByVisibleText("三星级");
		

	}

}
