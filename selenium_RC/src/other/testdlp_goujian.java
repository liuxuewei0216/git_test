package other;

import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.regex.Pattern;

import junit.framework.TestCase;

public class testdlp_goujian extends TestCase{
	private Selenium selenium;

	@Before
    public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*googlechrome C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe", "http://10.24.1.65:8099/");
		selenium.start();
	}
	
	@Test
	public void testTesttest()  {
		try{
		selenium.setMouseSpeed("200000");
		selenium.setTimeout("10000000000");
		selenium.windowMaximize();		
		selenium.open("/dlp/login.wxml");
		selenium.type("id=userid", "admin");
		selenium.type("id=passwd", "admin");
		selenium.click("id=lg");
		Thread.sleep(5000);//等待十秒
		selenium.click("xpath=/html/body/div[2]/div/table/tbody/tr[1]/td[3]/div[2]/ul/li[1]/a");
		Thread.sleep(5000);//等待十秒
		selenium.click("xpath=/html/body/div[1]/div[2]/div/div/div[2]/div[1]/a");
		Thread.sleep(5000);//等待十秒
//		System.out.println(selenium.getText("xpath=/html/body/div[3]/div/div/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div/ul/li[1]/div"));
		selenium.click("xpath=/html/body/div[3]/div/div/div[2]/div[1]/div/div[1]/table/tbody/tr/td[2]/input[1]");//开始时间框
		Thread.sleep(5000);//等待十秒
		selenium.click("xpath=/html/body/div/div[3]/table/tbody/tr[4]/td[5]");//现在
		selenium.click("xpath=/html/body/div/div[3]/table/tbody/tr[4]/td[5]");//现在
//		selenium.click("xpath=/html/body/div/div[3]/table/tbody/tr[2]/td[3]");//本月1号
//		selenium.click("xpath=/html/body/div/div[6]/input[3]");//确定
		Thread.sleep(5000);//等待十秒
		selenium.click("xpath=/html/body/div[3]/div/div/div[2]/div[1]/div/div[1]/table/tbody/tr/td[2]/input[2]");//结束时间框
		Thread.sleep(5000);//等待十秒
//		selenium.click("xpath=/html/body/div/div[3]/table/tbody/tr[4]/td[5]");//现在
		selenium.click("xpath=/html/body/div/div[3]/table/tbody/tr[2]/td[3]");//本月1号
		selenium.click("xpath=/html/body/div/div[3]/table/tbody/tr[2]/td[3]");//本月1号
//		selenium.click("xpath=/html/body/div/div[6]/input[3]");//确定
		Thread.sleep(5000);//等待十秒
		selenium.click("xpath=/html/body/div[3]/div/div/div[2]/div[1]/div/div[1]/table/tbody/tr/td[2]/a/span/span");//查询框
		System.out.println(selenium.getText("xpath=/html/body/div[3]/div/div/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div/ul/li[1]/div"));
		}
		catch (Exception e){
			System.out.println(e.getMessage());	

		}
		
	}
}
		

//	@After
//	public void tearDown() throws Exception {
//	selenium.stop();
//	}


