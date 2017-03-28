package lesson1;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Test12306 {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.firefox.bin",
				"D:\\Program Files\\Mozilla Firefox\\firefox.exe");
		driver = new FirefoxDriver();
		baseUrl = "https://www.baidu.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void test12306() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.id("kw")).click();
		driver.findElement(By.id("kw")).clear();
		driver.findElement(By.id("kw")).sendKeys("xpath");
		driver.findElement(By.xpath("//input[@id='su']")).click();
		driver.findElement(By.xpath("//div[@id='1']/h3/a/em")).click();

		// driver.findElement(By.xpath("//div[@id='intro']/x:p[4]/x:a")).click();
		// driver.findElement(By.linkText("开始学习 XPath")).click();
		// driver.findElement(By.xpath("//a[contains(text(),'开始学习 XPath')]")).click();
		// driver.findElement(By.xpath("//div[@id='intro']/p[4]/a")).click();


		driver.findElement(By.id("fromStationText")).clear();
		driver.findElement(By.id("fromStationText")).sendKeys("hailun");
		driver.findElement(By.id("citem_0")).click();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
