package other;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class testtest {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*googlechrome C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe", "http://10.24.1.98:8088/");
		selenium.start();
	}

	@Test
	public void testTesttest() throws Exception {
		selenium.windowFocus();
		selenium.setMouseSpeed("200000");
		selenium.setTimeout("10000000000");
		selenium.open("/apm-web/login.wxml");
		selenium.type("id=userid", "01177");
		selenium.type("id=passwd", "888888");
		selenium.click("id=lg");
		selenium.waitForPageToLoad("10000");
		
		selenium.click("xpath=(//a[contains(text(),'更多>>')])[5]");
		// selenium.waitForPageToLoad("10000");
		selenium.click("xpath=//a[contains(text(),'TOP服务')]");
	}

	// @After
	// public void tearDown() throws Exception {
	//	selenium.stop();
	// }
}
