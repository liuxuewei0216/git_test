package com.test;

import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.regex.Pattern;

import junit.framework.TestCase;

public class rightlogin extends TestCase{
	private Selenium selenium;

//	@Before
//	public void setUp() throws Exception {
//		selenium = new DefaultSelenium("localhost", 4444, "*googlechrome C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe", "http://10.24.1.98:8088/");
//		selenium.start();
//	}
	
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*googlechrome C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe", "http://10.24.1.98:8088/");
		selenium.start();
	}

	@Test
	public void right() throws Exception {
		selenium.setMouseSpeed("200000");
		selenium.setTimeout("10000000000");
		selenium.windowMaximize();		
		selenium.open("/apm-web/login.wxml");
		selenium.type("id=userid", "01177");
		selenium.type("id=passwd", "888888");
		selenium.click("id=lg");
		selenium.windowFocus();
	}

	// @After
	// public void tearDown() throws Exception {
	//	selenium.stop();
	// }
}
