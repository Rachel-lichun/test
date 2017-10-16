package com.li.selenium;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindElements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.firefox.bin",
				"E:\\daily\\browser\\firebox\\installpath30\\firefox.exe");
		driver = new FirefoxDriver();
		driver.get("http://baidu.com");
		driver.manage().window().maximize();
		// findElements
		List<WebElement> links = driver.findElements(By.cssSelector(".mnav"));
		// ��֤��������
		assertEquals(6, links.size());
		// ��ӡ
		for (int i = 0; i < links.size(); i++) {
			System.out.println(links.get(i).getAttribute("href"));

		}
		// ��λ����������ѡ��id��name��class���Խ��ж�λ
		// 1.linktext����
		WebElement newsLink = driver.findElement(By.linkText("����"));
		assertEquals("http://news.baidu.com/", newsLink.getAttribute("href"));
		System.out.println(newsLink.getAttribute("href"));
		// 2.partialLinkText()
		WebElement newsLink2 = driver.findElement(By.partialLinkText("��"));
		assertEquals("http://map.baidu.com/", newsLink2.getAttribute("href"));
		System.out.println(newsLink2.getAttribute("href"));
		// 3.css
		driver.findElement(By.id("u1")).findElement(By.className("lb")).click();
		// input[id=TANGRAM__PSP_10__userName :input��id��������λԪ��
		driver.findElement(
				By.cssSelector("input[id=TANGRAM__PSP_10__userName]"))
				.sendKeys("aaa");
	/*
	 *CSSѡ�����ṩ��һ����������ֵƥ�䶨λԪ�صķ�������Ϊ������Щҳ���Ͼ��ж�̬ �仯������Ԫ���Ƿǳ����á�
	 *���磬�� �仯������Ԫ���Ƿǳ����á����磬�� ASP.NETӦ���У�Ԫ�� id �Ƕ�̬���ɵġ����� ���������ʹ�ò���ƥ���﷨ ��
	 
	 * �﷨                   ����                                                                       ����
       ^=        Input[id^= ' ctrl']            ��xxx��ʼ��eg����ĳԪ�ص�id��ctrl-12���Ϳɶ�λ����Ԫ�ء�ƥ�䵽id��ͷ��ctrl
       $=        Input[id$=' -username']        ��xxx��β��eg����ĳԪ�ص�id��1-username������ƥ�䵽id��β��-username
       *=        Input[id*='username']          ����xxx.  eg:��ĳԪ�ص�id��2-username-8������ƥ�䵽username���Ӷ���λ��Ԫ�ء�
	
	 */
		
		
		//4.xpath ���·����λԪ��
		/*
		 * a:��<input>Ԫ�ش���DOM�е�һ���� driver.findElement(By.xpath("//input"));
		 * b:���ǵڶ���<input> ��driver.findElement(By.xpath("//input[2]"));
		 * c:xpath�������ֵ��λ��driver.findElement(By.xpath("//input[@id='username']"));driver.findElement(By.xpath("img[@alt=''previous]"));
		 *         ��Ҫ������ԣ�   driver.findElement(By.xpath("//input[@type='submit'][@value='login']"));
		 *                     ��driver.findElement(By.xpath("//input[@type='submit' and @value='login']"));
		 *                     ��driver.findElement(By.xpath("//input[@type='submit' or @value='login']"));
		 * d:xpath�����������λ��driver.findElement(By.xpath("img[@alt]"));
		 * 
		 * 
		 * 
		 * 
		 * selenium testing tools cookbook.pdf
		 
		 
		 
		 */
		
	
	}
	

}
