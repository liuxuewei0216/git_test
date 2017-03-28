package com.test;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class test_daochu {
	private Selenium selenium;
	

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*googlechrome C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe", "http://10.24.1.27/");
		selenium.start();
	}

	@Test
	public void testDd() throws Exception {
		selenium.open("/index.php?m=user&f=login");
		selenium.type("id=account", "liuxw");
		selenium.type("name=password", "1q2w3e4r5t@");
		selenium.click("id=submit");
		selenium.waitForPageToLoad("30000");
		selenium.click("id=menuproduct");
		selenium.waitForPageToLoad("30000");
		selenium.open("/index.php?m=bug&f=browse");
		selenium.waitForPageToLoad("30000");		
//		selenium.click("//div/div/div/button");
		selenium.click("id=currentItem");
		selenium.click("//div[@id='defaultMenu']/ul/li[9]/a");
		selenium.waitForPageToLoad("30000");
		selenium.click("id=submenutestcase");
		selenium.waitForPageToLoad("30000");
		selenium.click("xpath=(//button[@type='button'])[2]");
		selenium.click("link=导出数据");
		selenium.selectFrame("modalIframe");
		selenium.type("id=fileName", "用例");
		selenium.click("//button");
		selenium.waitForPageToLoad("30000");

	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
