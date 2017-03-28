package other;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class ddddd {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*googlechrome C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe", "http://10.24.1.98:8088/");
		selenium.start();
	}

	@Test
	public void testDdddd() throws Exception {
		selenium.setMouseSpeed("5000");
		selenium.setTimeout("100000000000");
		selenium.open("/apm-web/login.wxml");
		selenium.type("id=userid", "01177");
		selenium.type("id=passwd", "888888");
		selenium.click("id=lg");
		selenium.waitForPageToLoad("30000");
		selenium.click("//ul[@id='bizNorms_tree']/li/div/span");
		selenium.click("//ul[@id='bizNorms_tree']/li/ul/li/div/span[2]");
		selenium.click("//ul[@id='bizNorms_tree']/li/ul/li/ul/li/div/span[4]");
		Thread.sleep(10000);
		//等待十秒
		//selenium.waitForPageToLoad("8000");
		//这个方法不好用，会报错timeOut
		selenium.click("//input[@id='img_starti']");
		selenium.click("//td[@onclick='day_Click(2016,3,16);']");
		selenium.click("//input[@id='img_endtti']");
		selenium.click("//tr[3]/td[3]");
		selenium.click("//input[@id='dpOkInput']");
		selenium.click("//form[@id='searchMetricImgForm']/a/span/span");
		//selenium.getElementPositionLeft("xpath=/html/body/div[4]/div/div/div[2]/div/div/div/div/div[2]/div[2]/div[2]/table/tbody/tr/td");
		//assertEquals("1000",selenium.getElementHeight("xpath=/html/body/div[4]/div/div/div[2]/div/div/div/div/div[2]/div[2]/div[2]/table/tbody/tr/td"));
		selenium.getExpression("xpath=/html/body/div[4]/div/div/div[2]/div/div/div/div/div[2]/div[2]/div[2]/table/tbody/tr/td");
	}
	    

	// @After
	// public void tearDown() throws Exception {
	// 	selenium.stop();
	//}
}
