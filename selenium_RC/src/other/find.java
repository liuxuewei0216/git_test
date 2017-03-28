package other;

import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.internal.seleniumemulation.SelectWindow;

import static org.junit.Assert.*;

import java.util.regex.Pattern;

import junit.framework.TestCase;

public class find extends TestCase{
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*googlechrome C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe", "http://10.24.1.98:8088/");
		selenium.start();
	}

	@Test
	public void test123()  {
		try{
		selenium.open("/apm-web/login.wxml");
		selenium.type("id=userid", "01177");
		selenium.type("id=passwd", "888888");
		selenium.click("id=lg");
		selenium.waitForPageToLoad("30000");
				selenium.click("link=监控指标管理");
		Thread.sleep(5000);
		selenium.click("//a[contains(text(),'聚合指标配置')]");
		Thread.sleep(5000);	
//		selenium.getAllWindowTitles();	

//		selenium.selectWindow("应用服务监控和分析平台");
//        assertTrue("它是不存在的",selenium.isTextPresent("用户态与内核态CPU"));	
        
		selenium.click("//tr[@id='datagrid-row-r1-2-0']/td/div");
		selenium.click("//div[@id='aggMetric_toolbar']/div/div/a[2]/span/span");
		selenium.click("//a[@id='addscen']/span/span");
		selenium.getAlert();
		selenium.getConfirmation();
//		selenium.getText("/html/body/div[11]/div[2]");
		Thread.sleep(50000);	

//      如果"操作成功"这个元素存在，则成功，如果不存在，则报错“出错了”
//		selenium.isTextPresent("期望值");验证“期望值”这几个字是否在页面中存在
		//selenium.isTextPresent("期望值");
		//selenium.getBodyText(); 
		}
		catch (Exception e){
			System.out.println(e.getMessage());	
		};
//		修改保存
//		selenium.click("//div[@id='aggMetric_toolbar']/div/div/a/span/span");
//		selenium.click("//a[@id='addscen']/span/span");
//		新增保存

//		selenium.click("//a[contains(text(),'聚合指标配置')]");
//		selenium.click("//div[@id='aggMetric_toolbar']/div/div/a[4]/span/span");
//		selenium.type("id=agg_mtname", "cpu_system_user");
//		selenium.click("//form[@id='searchAlertForm']/fieldset/a/span/span");
//		selenium.click("//div[@id='aggMetric_toolbar']/div/div/a[4]/span/span");
//		selenium.click("//div[@id='aggMetric_toolbar']/div/div/a[4]/span/span");
//		selenium.type("id=agg_mtname", "cpu");
//		selenium.click("//form[@id='searchAlertForm']/fieldset/a/span/span");
//		selenium.click("//div[@id='aggMetric_toolbar']/div/div/a[4]/span/span");
//		selenium.click("//div[@id='aggMetric_toolbar']/div/div/a[4]/span/span");
//		selenium.type("id=agg_mtname", "CPU");
//		selenium.click("//form[@id='searchAlertForm']/fieldset/a/span/span");
//		selenium.click("//div[@id='aggMetric_toolbar']/div/div/a[4]/span/span");
//		selenium.click("//div[@id='aggMetric_toolbar']/div/div/a[4]/span/span");
//		selenium.type("id=agg_mtname", "cpuddd");
//		selenium.click("//form[@id='searchAlertForm']/fieldset/a/span/span");
//		selenium.click("//div[@id='aggMetric_toolbar']/div/div/a[4]/span/span");
//		selenium.click("//div[@id='aggMetric_toolbar']/div/div/a[4]/span/span");		
//		selenium.type("id=agg_mttitl", "用户态与内核态CPU");
//		selenium.click("//form[@id='searchAlertForm']/fieldset/a/span/span");
//		selenium.click("//div[@id='aggMetric_toolbar']/div/div/a[4]/span/span");
//		selenium.click("//div[@id='aggMetric_toolbar']/div/div/a[4]/span/span");
//		selenium.type("id=agg_mtname", "cpu_system_user");
//		selenium.type("id=agg_mttitl", "用户态与内核态CPU");
//		selenium.click("//form[@id='searchAlertForm']/fieldset/a/span/span");
//		selenium.click("//div[@id='aggMetric_toolbar']/div/div/a[4]/span/span");
//		selenium.click("//div[@id='aggMetric_toolbar']/div/div/a[4]/span/span");
//		selenium.type("id=agg_mtname", "cpu_system_user");
//		selenium.type("id=agg_mttitl", "磁盘使用汇总");
//		selenium.click("//form[@id='searchAlertForm']/fieldset/a/span/span");


	}
	

	//@After
	//public void tearDown() throws Exception {
	//	selenium.stop();
	//}
}
