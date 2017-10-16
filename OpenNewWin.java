package com.li.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenNewWin {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
    WebDriver driver;
    System.setProperty("webdriver.firefox.bin","F:\\daily\\browser\\firebox\\installpath30\\firefox.exe");
    driver = new FirefoxDriver();
    driver.get("http://baidu.com");
    System.out.println("there are " +driver.getWindowHandles().size() +" windows");
    
    //�ж�ҳ��Ԫ���Ƿ�������
    
     //�ȴ�ĳ���ض�Ԫ�س���
    WebDriverWait wait = new  WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kw")));
    driver.findElement(By.id("kw")).sendKeys("aaa");
    driver.findElement(By.id("su")).click();
    
     //�ȴ�ҳ�泹�׼�����
    /*
     *  ������readyState�ļ���״̬:
0-UNINITIALIZED��XML ���󱻲�������û���κ��ļ������ء� 
1-LOADING�����س�������У����ļ���δ��ʼ������ 
2-LOADED�����ֵ��ļ��Ѿ������ҽ��н�����������ģ����δ��Ч�� 
3-INTERACTIVE�������Ѽ��صĲ����ļ���Ч���ڴ�����£�����ģ������Ч��ֻ���ġ� 
4-COMPLETE���ļ�����ȫ���أ�������سɹ���
���ǽ��õ�complete���״̬�� ������webdriver ��javascriptִ������ִ��"document.readyState" , ֪��������complete״̬
     */
    
    /*
     * void waitForLoad(WebDriver driver) {
    ExpectedCondition<Boolean> pageLoad= new
        ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
            }
        };
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(pageLoad);
}        
     */
    
   
    
    //js���´���
    JavascriptExecutor executor = (JavascriptExecutor) driver;
    executor.executeScript("window.open();");
    System.out.println("executor js 'window.open()'");
    System.out.println("there are" +driver.getWindowHandles().size() +"windows");
    //driver.close();
    
   /*ʹ�ü��� ctrl+n ���´���
    driver.get("http://baidu.com");
    System.out.println("there are " +driver.getWindowHandles().size() +" windows");
    Actions action = new Actions(driver);
    action.sendKeys(Keys.CONTROL+"n").perform();
    System.out.println("there are " +driver.getWindowHandles().size() +" windows");
    */
	}

}
