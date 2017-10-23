package com.li.selenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.assertEquals;

public class CheckElement {

	/**
	 * @param ���Ԫ���ı�������ֵ��css����ֵ
	 */
	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.firefox.bin",
				"E:\\daily\\browser\\firebox\\installpath30\\firefox.exe");
		driver = new FirefoxDriver();
		
		driver.get("http://baidu.com");
		driver.manage().window().maximize();
//		һ.���Ԫ���ı�
		// ��һ�������Ԫ��
		WebElement element = driver.findElement(By.id("setf"));
	   // �ڶ������õ�Ԫ���ı�
		String text = element.getText();// getText()���ص�innerText����
		// ����������֤�ı�
		/*
		 * assertEquals��ԭ��1��assertEquals([String message],expected,actual) ����˵����
	     * message�Ǹ���ѡ����Ϣ�������ṩ�������ڷ�������ʱ���������Ϣ�� expected������ֵ��ͨ�������û�ָ�������ݡ�
		 * actual�Ǳ����ԵĴ��뷵�ص�ʵ��ֵ��
		 */
		System.out.println("before");
		assertEquals("fail", "�Ѱٶ���Ϊ��ҳ", text);
		System.out.println("after");
		
		
//		��.���Ԫ�ص�����ֵ��������������֤Ԫ�������Ƿ���ȷ��
		/*
		 * ͨ��titleʶ�����л�����
		 * ��JS��һ���´��ڣ���ǰ�����ǰٶ�ҳ�棬��Ҫ�л����´��ڣ������µ���ַ
		 * ����ͨ��handle��title������л�����
		 */
		// ��һ���´���
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.open();");
		//��ȡ���д��ڵľ��
		Set<String> allId=driver.getWindowHandles();
		//�л�����Ŀǰ�Ӵ�����3�ַ���
		//����1��ͨ��titleʶ�����л�����
		for (String id : allId) {
			if (driver.switchTo().window(id).getTitle().equals("�±�ǩҳ")) {
				driver.switchTo().window(id);
				System.out.println(driver.getTitle());
			}
			
		}
		//����2�� ͨ����ҳ�����л�����
		
//		for (String id : allId) {
//			if (driver.getPageSource().contains("")) {
//				driver.switchTo().window(id);
//			}
//		}
		
		//����3��ͨ�����ڵ�name����
		//switchTo().window() ,��Ҫ֪�����ڵ�name���ԡ��ڴˣ��˷������ʺ�
//		driver.switchTo().window("name");
		
		
		driver.get("http://www.ziroom.com");
		System.out.println("driver.getTitle():" + driver.getTitle());
		driver.manage().window().maximize();
		driver.findElement(By.id("searchTxt")).click();
		WebElement styleElement = driver.findElement(By.id("searchType"));
		System.out.println(styleElement.getAttribute("class"));
		System.out.println(styleElement.getAttribute("style"));
		}

}
