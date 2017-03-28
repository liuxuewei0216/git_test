package com.test;

import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.regex.Pattern;

import junit.framework.TestCase;

public class none_username{
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
		// selenium.type("id=userid", "");
		selenium.type("id=passwd", "1111");
		selenium.click("id=lg");
	}

	// @After
	// public void tearDown() throws Exception {
	//	selenium.stop();
	// }
}
