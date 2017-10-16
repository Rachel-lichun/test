package com.li.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Mouser {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.firefox.bin",
				"F:\\daily\\browser\\firebox\\installpath30\\firefox.exe");
		driver = new FirefoxDriver();
		driver.get("http://www.baidu.com/");
		/*
		 * 清除<input>输入框。3种方法
		 */

		// 1，clear 一次性删除
		driver.findElement(By.id("kw")).sendKeys("aaa");
		Thread.sleep(5000);
		driver.findElement(By.id("kw")).clear();
		Thread.sleep(5000);

		// 2.逐一清除
		WebElement inputElement = driver.findElement(By.id("kw"));
		inputElement.sendKeys("bbbb");
		Thread.sleep(5000);
		String inputValue = inputElement.getAttribute("value");
		for (int i = 0; i < inputValue.length(); i++) {
			inputElement.sendKeys(Keys.BACK_SPACE);

		}

		Thread.sleep(5000);

		// 3.CTRL+ A全选, 然后用backspace删除

		WebElement inputElements = driver.findElement(By.id("kw"));
		inputElements.sendKeys("cccc");
		Thread.sleep(5000);
		inputElements.sendKeys(Keys.CONTROL + "a");
		//
		Thread.sleep(5000);
		inputElements.sendKeys(Keys.BACK_SPACE);

		/*
		 * 模拟鼠标键盘组合事件
		 */

		// 1，找到元素
		WebElement taElement = driver.findElement(By.linkText("设置"));

		Actions action = new Actions(driver);
		// 2.将鼠标移动到元素上
		// .build():主要目的就是建立一个组合action以准备执行，并且让新的action系列可以加入到下一个build()中去。
		Action mouserOverlogin = action.moveToElement(taElement).build();
		mouserOverlogin.perform();

		action.moveToElement(driver.findElement(By.linkText("登录"))).click()
				.build().perform();

		// 必须有等待时间，如果登录代码和定位输入框之间没有等待时间，无法定位元素。
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 3.定位登录用户名输入框
		WebElement element = driver.findElement(By
				.id("TANGRAM__PSP_10__userName"));

		
		// 鼠标键盘组合，输入用户名 。
		/*
		 * action.moveToElement(element): 鼠标移动到 被定位的输入框
		 * ***.click()。（鼠标已在输入框处）模拟鼠标左键单击 ***.keyDown(element, Keys.SHIFT)
		 * 模拟键盘按住shitf键 ***.sendKeys(element, "ccaa") 模拟键盘，向element输入框 send 值
		 * ***.keyUp(element, Keys.SHIFT) 模拟键盘，释放shitf键 ***.build().perform()
		 * 执行上述所有模拟操作
		 */
		//4.通过鼠标键盘组合操作，向输入框输入值
		action.moveToElement(element).click().keyDown(element, Keys.SHIFT)
				.sendKeys(element, "ccaa").keyUp(element, Keys.SHIFT).perform();
	}

}
