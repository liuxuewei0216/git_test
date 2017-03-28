package com.test;

import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.regex.Pattern;

import junit.framework.TestCase;

public class none_password{
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
		selenium.windowMaximize();		
		selenium.open("/apm-web/login.wxml");
		selenium.type("id=userid", "01177");
		// selenium.type("id=passwd", "");
		selenium.click("id=lg");
		selenium.getText("xpath=//html/body/div[1]/div[2]/div[2]");
		// 获取登陆失败提示窗口的文字

	}

	@After
	public void tearDown() throws Exception {
	selenium.stop();
	}
}
