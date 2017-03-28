package com.test;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class dd {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		
//		selenium = new DefaultSelenium("localhost", 4444, "*googlechrome C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe", "https://www.baidu.com/");
	selenium = new DefaultSelenium("localhost", 4444, "*googlechrome C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe", "chrome://apps/");
		selenium.start();
	}

	@Test
	public void testDd() throws Exception {
		selenium.open("");
		selenium.click("link=将MySQL数据导入到redis的简单方法");
		selenium.click("link=\"liuzhou88888@126.com\"");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
