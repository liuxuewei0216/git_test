package com.test;
import static org.junit.Assert.*;

import java.util.TimerTask;

import org.junit.Test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class test_cendao extends TimerTask{
		private Selenium selenium;
/*		@Test
		public void testDd() throws Exception {
			selenium.open("/zentao/index.php?m=user&f=login&referer=L3plbnRhby9pbmRleC5waHA.bT1teSZmPWluZGV4");
			selenium.type("id=account", "liuxw");
			selenium.type("name=password", "1q2w3e4r5t@");
			selenium.click("id=submit");
			selenium.waitForPageToLoad("30000");
			selenium.click("id=menuproduct");
			selenium.waitForPageToLoad("30000");
			selenium.click("id=menuqa");
			selenium.waitForPageToLoad("30000");
			selenium.click("id=submenutestcase");
			selenium.waitForPageToLoad("30000");
			selenium.click("css=div.pager.form-inline > a > i.icon-play");
			selenium.waitForPageToLoad("30000");
			selenium.click("//table[@id='caseList']/tfoot/tr/td/div[2]/div/a[3]/i");
			selenium.waitForPageToLoad("30000");
		}*/

		@Test
		public void run(){
			System.out.println("������������������");
//			assertEquals("我的地盘 - 禅道", selenium.getTitle());		
			selenium = new DefaultSelenium("localhost", 4444, "*googlechrome C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe", "http://10.24.1.27");
			selenium.start();
			selenium.open("/index.php?m=user&f=login");
			assertEquals("用户登录 - 禅道", selenium.getTitle());	
			selenium.type("id=account", "liuxw");
			selenium.type("name=password", "1q2w3e4r5t@");
			selenium.click("id=submit");
			selenium.waitForPageToLoad("30000");
			assertEquals("我的地盘 - 禅道", selenium.getTitle());			
			System.out.println(selenium.getTitle());
			selenium.click("id=menuproduct");
			selenium.waitForPageToLoad("30000");
			selenium.click("id=menuqa");
			selenium.waitForPageToLoad("30000");
			selenium.click("//a[contains(text(),'刘雪微')]");
			System.out.println(selenium.getTitle());
			//正确
//			assertEquals("分布式基础设施V1.0 ::Bug - 禅道", selenium.getTitle());
			//a[contains(text(),'刘雪微')]
//			selenium.stop();
		}



/*		@After
		public void tearDown() throws Exception {
			selenium.stop();

	}*/

}
