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
				selenium.click("link=���ָ�����");
		Thread.sleep(5000);
		selenium.click("//a[contains(text(),'�ۺ�ָ������')]");
		Thread.sleep(5000);	
//		selenium.getAllWindowTitles();	

//		selenium.selectWindow("Ӧ�÷����غͷ���ƽ̨");
//        assertTrue("���ǲ����ڵ�",selenium.isTextPresent("�û�̬���ں�̬CPU"));	
        
		selenium.click("//tr[@id='datagrid-row-r1-2-0']/td/div");
		selenium.click("//div[@id='aggMetric_toolbar']/div/div/a[2]/span/span");
		selenium.click("//a[@id='addscen']/span/span");
		selenium.getAlert();
		selenium.getConfirmation();
//		selenium.getText("/html/body/div[11]/div[2]");
		Thread.sleep(50000);	

//      ���"�����ɹ�"���Ԫ�ش��ڣ���ɹ�����������ڣ��򱨴������ˡ�
//		selenium.isTextPresent("����ֵ");��֤������ֵ���⼸�����Ƿ���ҳ���д���
		//selenium.isTextPresent("����ֵ");
		//selenium.getBodyText(); 
		}
		catch (Exception e){
			System.out.println(e.getMessage());	
		};
//		�޸ı���
//		selenium.click("//div[@id='aggMetric_toolbar']/div/div/a/span/span");
//		selenium.click("//a[@id='addscen']/span/span");
//		��������

//		selenium.click("//a[contains(text(),'�ۺ�ָ������')]");
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
//		selenium.type("id=agg_mttitl", "�û�̬���ں�̬CPU");
//		selenium.click("//form[@id='searchAlertForm']/fieldset/a/span/span");
//		selenium.click("//div[@id='aggMetric_toolbar']/div/div/a[4]/span/span");
//		selenium.click("//div[@id='aggMetric_toolbar']/div/div/a[4]/span/span");
//		selenium.type("id=agg_mtname", "cpu_system_user");
//		selenium.type("id=agg_mttitl", "�û�̬���ں�̬CPU");
//		selenium.click("//form[@id='searchAlertForm']/fieldset/a/span/span");
//		selenium.click("//div[@id='aggMetric_toolbar']/div/div/a[4]/span/span");
//		selenium.click("//div[@id='aggMetric_toolbar']/div/div/a[4]/span/span");
//		selenium.type("id=agg_mtname", "cpu_system_user");
//		selenium.type("id=agg_mttitl", "����ʹ�û���");
//		selenium.click("//form[@id='searchAlertForm']/fieldset/a/span/span");


	}
	

	//@After
	//public void tearDown() throws Exception {
	//	selenium.stop();
	//}
}
