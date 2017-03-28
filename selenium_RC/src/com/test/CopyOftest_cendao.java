package com.test;
import java.util.TimerTask;

import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class CopyOftest_cendao extends TimerTask{
		private Selenium selenium;
		@Before
		public void setUp() throws Exception {
			selenium = new DefaultSelenium("localhost", 4444, "*googlechrome C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe", "http://10.24.1.27");
			selenium.start();
			selenium.open("/index.php?m=user&f=login");
		}

		@Test
		public void run(){			
//			System.out.println("开始。。。。");
//			selenium = new DefaultSelenium("localhost", 4444, "*googlechrome C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe", "http://10.24.1.27");
//			selenium.start();
			System.out.println("开始1。。。。");
//			selenium.open("/index.php?m=user&f=login");
			//判斷用戶是否已經登錄
			if ("用户登录 - 禅道".equals(selenium.getTitle())){
			selenium.type("id=account", "liuxw");
			selenium.type("name=password", "1q2w3e4r5t@");
			selenium.click("id=submit");
			selenium.waitForPageToLoad("30000");
			}
			selenium.click("id=menuproduct");
			selenium.waitForPageToLoad("30000");
			selenium.click("id=menuqa");
			selenium.waitForPageToLoad("30000");
			selenium.click("//a[contains(text(),'刘雪微')]");
			System.out.println(selenium.getTitle());
//			selenium.stop();
		}
		@Test
		public void run1(){			
//			System.out.println("开始。。。。");
//			selenium = new DefaultSelenium("localhost", 4444, "*googlechrome C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe", "http://10.24.1.27");
//			selenium.start();
			System.out.println("开始2。。。。");
			//判斷用戶是否已經登錄
			if ("用户登录 - 禅道".equals(selenium.getTitle())){
			selenium.type("id=account", "liuxw");
			selenium.type("name=password", "1q2w3e4r5t@");
			selenium.click("id=submit");
			selenium.waitForPageToLoad("30000");
			}
			selenium.click("id=menuproduct");
			selenium.waitForPageToLoad("30000");
			selenium.click("id=menuqa");
			selenium.waitForPageToLoad("30000");
			selenium.click("//a[contains(text(),'刘雪微')]");
			System.out.println(selenium.getTitle());
//			selenium.stop();
		}

/*		@After
		public void tearDown() throws Exception {
			selenium.stop();

	}*/

}
