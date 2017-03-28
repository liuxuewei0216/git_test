package other;

import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.regex.Pattern;

import junit.framework.TestCase;

public class testdlpselectframe extends TestCase{
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*googlechrome C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe", "http://10.24.1.65:8099/");
		selenium.start();
	}

	@Test
	public void testTestdlpselectframe() throws Exception {
		selenium.open("/dlp/login.wxml");
		selenium.type("id=userid", "admin");
		selenium.type("id=passwd", "admin");
		selenium.click("id=lg");
		Thread.sleep(5000);
		selenium.click("//ul[@id='appops_tree']/li[2]/div/span");
		selenium.click("//ul[@id='appops_tree']/li[2]/ul/li/div/span[3]");
		//selenium.selectFrame();����ԭʼ�Ĵ��룬û��ִ�гɹ���ʹ��������䣬�ټ���ִ�м���
		selenium.selectFrame("relative=top");
		//����Ԫ�أ�����ҳ�涥��
		selenium.click("css=div.datagrid-cell.datagrid-cell-c1-script");
		selenium.click("//a[@id='toRunPage']/span/span");
	}

	//@After
	//public void tearDown() throws Exception {
	//	selenium.stop();
	//}
}
