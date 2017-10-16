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
		// 验证链接数量
		assertEquals(6, links.size());
		// 打印
		for (int i = 0; i < links.size(); i++) {
			System.out.println(links.get(i).getAttribute("href"));

		}
		// 定位方法：优先选择id，name，class属性进行定位
		// 1.linktext（）
		WebElement newsLink = driver.findElement(By.linkText("新闻"));
		assertEquals("http://news.baidu.com/", newsLink.getAttribute("href"));
		System.out.println(newsLink.getAttribute("href"));
		// 2.partialLinkText()
		WebElement newsLink2 = driver.findElement(By.partialLinkText("地"));
		assertEquals("http://map.baidu.com/", newsLink2.getAttribute("href"));
		System.out.println(newsLink2.getAttribute("href"));
		// 3.css
		driver.findElement(By.id("u1")).findElement(By.className("lb")).click();
		// input[id=TANGRAM__PSP_10__userName :input中id属性来定位元素
		driver.findElement(
				By.cssSelector("input[id=TANGRAM__PSP_10__userName]"))
				.sendKeys("aaa");
	/*
	 *CSS选择器提供了一个部分属性值匹配定位元素的方法。这为测试那些页面上具有动态 变化的属性元素是非常有用。
	 *例如，在 变化的属性元素是非常有用。例如，在 ASP.NET应用中，元素 id 是动态生成的。下面 介绍了如何使用部分匹配语法 ：
	 
	 * 语法                   例子                                                                       描述
       ^=        Input[id^= ' ctrl']            以xxx开始。eg：若某元素的id是ctrl-12，就可定位到该元素。匹配到id的头部ctrl
       $=        Input[id$=' -username']        以xxx结尾。eg：若某元素的id是1-username，将会匹配到id的尾部-username
       *=        Input[id*='username']          包含xxx.  eg:若某元素的id是2-username-8，将会匹配到username，从而定位到元素。
	
	 */
		
		
		//4.xpath 相对路径定位元素
		/*
		 * a:若<input>元素处于DOM中第一个： driver.findElement(By.xpath("//input"));
		 * b:若是第二个<input> ：driver.findElement(By.xpath("//input[2]"));
		 * c:xpath结合属性值定位：driver.findElement(By.xpath("//input[@id='username']"));driver.findElement(By.xpath("img[@alt=''previous]"));
		 *         需要多个属性：   driver.findElement(By.xpath("//input[@type='submit'][@value='login']"));
		 *                     或driver.findElement(By.xpath("//input[@type='submit' and @value='login']"));
		 *                     或driver.findElement(By.xpath("//input[@type='submit' or @value='login']"));
		 * d:xpath结合属性名定位：driver.findElement(By.xpath("img[@alt]"));
		 * 
		 * 
		 * 
		 * 
		 * selenium testing tools cookbook.pdf
		 
		 
		 
		 */
		
	
	}
	

}
