package com.test;

import com.thoughtworks.selenium.*;

import org.junit.*;

import static org.junit.Assert.*;

import java.util.regex.Pattern;

import junit.framework.TestCase;

public class wrong_password extends TestCase{
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*googlechrome C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe", "http://10.24.1.98:8088/");
		selenium.start();
	}

	@Test
	public void testTesttest() throws Exception {
		selenium.setMouseSpeed("200000");
		selenium.setTimeout("10000000000");
		selenium.open("/apm-web/login.wxml");
		selenium.type("id=userid", "01177");
		selenium.type("id=passwd", "88888");
		selenium.click("id=lg");
		selenium.getBodyText();
		selenium.click("xpath=(//a[contains(@href, 'javascript:void(0)')])[2]");
		selenium.type("id=userid", "01117");
		selenium.type("id=passwd", "88888");
		selenium.click("id=lg");
		selenium.getBodyText();
		selenium.click("xpath=(//a[contains(@href, 'javascript:void(0)')])[2]");
		selenium.type("id=userid", "01117");
		selenium.type("id=passwd", "");	
		selenium.click("id=lg");
		selenium.getBodyText();
		selenium.click("xpath=(//a[contains(@href, 'javascript:void(0)')])[2]");
		selenium.type("id=userid", "");
		selenium.type("id=passwd", "01117");	
		selenium.click("id=lg");
		selenium.getBodyText();
		selenium.getAllButtons();
		
		
		// selenium.getAllWindowTitles();
		
		// selenium.getAllWindowTitles();
		//assertEquals("dd",selenium.getBodyText());
		//selenium.isTextPresent("");
		//assertEquals("用 户 名", selenium.getAllWindowTitles());
		//assertTrue(selenium.isTextPresent("输入密码有误"));
		// assertFalse(selenium.isTextPresent("输入密码有误"));
		
	}

	// @After
	// public void tearDown() throws Exception {
	//	selenium.stop();
	// }
}
