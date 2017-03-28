package other;

import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.regex.Pattern;

import junit.framework.TestCase;

public class testdlp_yunwei extends TestCase{
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*googlechrome C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe", "http://10.24.1.65:8099/");
		selenium.start();
	}

	@Test
	public void testTestdlp_yunwei()  {
		try{
			selenium.open("/dlp/login.wxml");
			selenium.type("id=userid", "admin");
			selenium.type("id=passwd", "admin");
			selenium.click("id=lg");
			selenium.click("//ul[@id='appops_tree']/li[2]/div/span");
			selenium.click("//ul[@id='appops_tree']/li[2]/ul/li/div/span[3]");
			selenium.selectFrame("relative=top");//使用此方法跳出frame元素，否则找不到下面的元素
			Thread.sleep(5000);
			selenium.click("//tr[@id='datagrid-row-r1-2-0']/td[2]/div");
			Thread.sleep(5000);
			selenium.click("//a[@id='toRunPage']/span/span");
			Thread.sleep(5000);
			selenium.click("//ul[@id='opsTree']/li/ul/li/ul/li[1]/div/span[5]");
			Thread.sleep(5000);
			selenium.click("//div[@id='opsSelect']/div[2]/a[2]/span/span");
			Thread.sleep(5000);
			selenium.getAllWindowTitles();
			System.out.println(
					selenium.getAllWindowTitles()
					);//找到WindowTitles
		//selenium.waitForPopUp("selenium_blank35502", "5000");//等待弹出窗口加载，这个方法不好使
		selenium.selectWindow("应用运维操作执行页面");//选择弹出窗口，里面填windowTitles，可通过get方法获得
		selenium.click("//*[@id=\"runAllTask_btn\"]");
		selenium.click("//body[@id='cc']/div[6]/div[2]/div[4]/a/span/span");
		
		//构建
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
		};
	}

//	@After
//	public void tearDown() throws Exception {
//		selenium.stop();
//	}
}
