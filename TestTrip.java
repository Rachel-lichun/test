package com.li.selenium;

import java.util.Set;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestTrip {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver;

		// firefoxû�а�װ��Ĭ��Ŀ¼�£���Ҫ�����ֶ������������
		System.setProperty("webdriver.firefox.bin","F:\\daily\\browser\\firebox\\installpath30\\firefox.exe");
		driver = new FirefoxDriver();
		// ������󻯣���ֹ�������ڵ������޷�ʶ�𣬲��ܽ����Զ�������
		driver.manage().window().maximize();
		driver.get("http://www.ctrip.com/");
		// �û���¼����
		driver.findElement(By.xpath(".//*[@id='c_ph_login']")).click();
		driver.findElement(By.xpath(".//*[@id='txtUserName']")).sendKeys("18201038718");
		driver.findElement(By.xpath(".//*[@id='txtPwd']")).sendKeys("LL870461912");
		driver.findElement(By.xpath(".//*[@id='btnSubmit']")).click();
		//��֤�û���¼�ɹ�
		String text = driver.findElement(By.id("c_ph_logout")).getText();
		System.out.println(text);
		Assert.assertEquals(text, "�˳�");
		Thread.sleep(3000); // �ڵ�¼ҳ�棬�����¼�����ת��ҳ����ʱ���û�еȴ�ʱ�䣬��ʾ��ҳ�治������д��ȴ������ҳ����ʾ����
		
		//�x����У�����
		
//		driver.findElement(By.xpath("//a[text()='�Ϻ�']")).click(); //ѡ�����-�Ϻ�
		driver.findElement(By.xpath(".//*[@id='HD_CityName']")).sendKeys("�Ϻ�");
//		WebElement from = driver.findElement(By.xpath(".//*[@id='HD_CityName']"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].value=\"�Ϻ�\"", from);
		driver.findElement(By.id("HD_CheckIn")).clear();
		driver.findElement(By.id("HD_CheckIn")).sendKeys("2017-7-8");
		driver.findElement(By.id("HD_CheckOut")).clear();
		driver.findElement(By.id("HD_CheckOut")).sendKeys("2017-7-9");
		//ѡ��Ƶ꼶��
		Select select = new Select(driver.findElement(By.id("searchHotelLevelSelect")));
		select.selectByIndex(0);
		// 1
//		Select select = new Select(driver.findElement(By.id("searchHotelLevelSelect")));
//		for(WebElement e: select.getOptions())
//			e.click();
		
		//select.selectByIndex(3);
	     // select.selectByValue("3");
//		select.selectByVisibleText("");

		driver.findElement(By.id("HD_Btn")).click();
		//ѡ�۸�
	 //  driver.findElement(By.id("price-v150v300")).click();
	   Thread.sleep(5000);
	   //�رյ����Ĵ���
	   driver.findElement(By.id("appd_wrap_close")).click();
	   //�鿴����
	   driver.findElement(By.xpath(".//*[@id='4399431']/ul/li[3]/div[3]/p[2]/a")).click();
	   Thread.sleep(5000);
	    
	 
	
		String parentWindowId = driver.getWindowHandle();
        System.out.println("driver.getTitle(): " + driver.getTitle());
        Set<String> allWindowsId = driver.getWindowHandles();
        
        // ��ȡ���еĴ򿪴��ڵľ��
        for (String windowId : allWindowsId) {
            if (driver.switchTo().window(windowId).getTitle().contains("Ԥ���۸�")) {
                driver.switchTo().window(windowId);
                break;
            }
        }
        
        System.out.println("driver.getTitle(): " + driver.getTitle());
 	   driver.findElement(By.xpath(".//*[@id='btn_book_now']")).click();
 	   driver.findElement(By.xpath(".//*[@id='J_RoomListTbl']/tbody/tr[3]/td[9]/div/a/div[1]")).click();
        driver.close();
        // �ٴ��л���ԭ���ĸ�����
        driver.switchTo().window(parentWindowId);
        System.out.println("parentWindowId: " + driver.getTitle());
	   //logout
       driver.findElement(By.id("c_ph_logout")).click();
       //��֤�û��˳��ɹ�
       String text3 = driver.findElement(By.id("c_ph_register")).getText();
       System.out.println(text3);
       Assert.assertEquals(text3, "ע��");
		
		//driver.quit();  // �ر������

	}

}
