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
    
    //判断页面元素是否加载完成
    
     //等待某个特定元素出现
    WebDriverWait wait = new  WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kw")));
    driver.findElement(By.id("kw")).sendKeys("aaa");
    driver.findElement(By.id("su")).click();
    
     //等待页面彻底加载完
    /*
     *  以下是readyState的几个状态:
0-UNINITIALIZED：XML 对象被产生，但没有任何文件被加载。 
1-LOADING：加载程序进行中，但文件尚未开始解析。 
2-LOADED：部分的文件已经加载且进行解析，但对象模型尚未生效。 
3-INTERACTIVE：仅对已加载的部分文件有效，在此情况下，对象模型是有效但只读的。 
4-COMPLETE：文件已完全加载，代表加载成功。
我们将用到complete这个状态， 并调用webdriver 的javascript执行器来执行"document.readyState" , 知道它返回complete状态
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
    
   
    
    //js打开新窗口
    JavascriptExecutor executor = (JavascriptExecutor) driver;
    executor.executeScript("window.open();");
    System.out.println("executor js 'window.open()'");
    System.out.println("there are" +driver.getWindowHandles().size() +"windows");
    //driver.close();
    
   /*使用键盘 ctrl+n 打开新窗口
    driver.get("http://baidu.com");
    System.out.println("there are " +driver.getWindowHandles().size() +" windows");
    Actions action = new Actions(driver);
    action.sendKeys(Keys.CONTROL+"n").perform();
    System.out.println("there are " +driver.getWindowHandles().size() +" windows");
    */
	}

}
