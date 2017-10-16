package com.li.selenium;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Test12306 {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.firefox.bin",
				"F:\\daily\\browser\\firebox\\installpath30\\firefox.exe");
		driver = new FirefoxDriver();
		driver.get("http://www.12306.cn/");
		// �������
		driver.manage().window().maximize();
		// ��� ��Ʊ
		driver.findElement(By.className("k2")).click();
		// ��ȡ���еĴ򿪴��ڵľ��
		Set<String> allWindowsId = driver.getWindowHandles();
		for (String windowsId : allWindowsId) {
			if (driver.switchTo().window(windowsId).getTitle().contains("���˷���")) {
				driver.switchTo().window(windowsId);//������Ʊҳ��
				break;

			}

		}
		// �ȴ�ҳ�����
		// 1.��ʽ�ȴ�
		WebDriverWait wait = new WebDriverWait(driver, 20);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fromStationText")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.id("fromStationText")));
	
		driver.findElement(By.id("fromStationText")).clear();  
		driver.findElement(By.id("fromStationText")).sendKeys("����");  
        ((HasInputDevices) driver).getKeyboard().sendKeys(Keys.ARROW_DOWN);  
        //ע�����ﲻ����Keys.ENTER  
        ((HasInputDevices) driver).getKeyboard().sendKeys(Keys.RETURN);  
          
        Thread.sleep(1000);  
        driver.findElement(By.id("toStationText")).clear();  
        driver.findElement(By.id("toStationText")).sendKeys("����");  
        ((HasInputDevices) driver).getKeyboard().sendKeys(Keys.RETURN);  
		

		// <input id="train_date" class="inp-txt" > ���ڿؼ���readonly="readonly". û������WebElement��sendKeys()
		// ����һ��ʹ��JS remove readonly attribute��Ȼ��sendKeys

		// remove readonly attribute
		JavascriptExecutor removeAttribute = (JavascriptExecutor) driver;
		removeAttribute
				.executeScript("var setDate=document.getElementById(\"train_date\");setDate.removeAttribute('readonly');");
		// sendKeys
		driver.findElement(By.id("train_date")).clear();
		driver.findElement(By.id("train_date")).sendKeys("2017-07-02");
		driver.findElement(By.id("a_search_ticket")).click();
		
		

	


	}

}
