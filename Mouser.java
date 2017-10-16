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
		 * ���<input>�����3�ַ���
		 */

		// 1��clear һ����ɾ��
		driver.findElement(By.id("kw")).sendKeys("aaa");
		Thread.sleep(5000);
		driver.findElement(By.id("kw")).clear();
		Thread.sleep(5000);

		// 2.��һ���
		WebElement inputElement = driver.findElement(By.id("kw"));
		inputElement.sendKeys("bbbb");
		Thread.sleep(5000);
		String inputValue = inputElement.getAttribute("value");
		for (int i = 0; i < inputValue.length(); i++) {
			inputElement.sendKeys(Keys.BACK_SPACE);

		}

		Thread.sleep(5000);

		// 3.CTRL+ Aȫѡ, Ȼ����backspaceɾ��

		WebElement inputElements = driver.findElement(By.id("kw"));
		inputElements.sendKeys("cccc");
		Thread.sleep(5000);
		inputElements.sendKeys(Keys.CONTROL + "a");
		//
		Thread.sleep(5000);
		inputElements.sendKeys(Keys.BACK_SPACE);

		/*
		 * ģ������������¼�
		 */

		// 1���ҵ�Ԫ��
		WebElement taElement = driver.findElement(By.linkText("����"));

		Actions action = new Actions(driver);
		// 2.������ƶ���Ԫ����
		// .build():��ҪĿ�ľ��ǽ���һ�����action��׼��ִ�У��������µ�actionϵ�п��Լ��뵽��һ��build()��ȥ��
		Action mouserOverlogin = action.moveToElement(taElement).build();
		mouserOverlogin.perform();

		action.moveToElement(driver.findElement(By.linkText("��¼"))).click()
				.build().perform();

		// �����еȴ�ʱ�䣬�����¼����Ͷ�λ�����֮��û�еȴ�ʱ�䣬�޷���λԪ�ء�
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 3.��λ��¼�û��������
		WebElement element = driver.findElement(By
				.id("TANGRAM__PSP_10__userName"));

		
		// ��������ϣ������û��� ��
		/*
		 * action.moveToElement(element): ����ƶ��� ����λ�������
		 * ***.click()���������������򴦣�ģ������������ ***.keyDown(element, Keys.SHIFT)
		 * ģ����̰�סshitf�� ***.sendKeys(element, "ccaa") ģ����̣���element����� send ֵ
		 * ***.keyUp(element, Keys.SHIFT) ģ����̣��ͷ�shitf�� ***.build().perform()
		 * ִ����������ģ�����
		 */
		//4.ͨ����������ϲ����������������ֵ
		action.moveToElement(element).click().keyDown(element, Keys.SHIFT)
				.sendKeys(element, "ccaa").keyUp(element, Keys.SHIFT).perform();
	}

}
