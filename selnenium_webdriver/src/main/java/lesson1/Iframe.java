package lesson1;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Iframe {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.firefox.bin",
				"D:\\Program Files\\Mozilla Firefox\\firefox.exe");
		driver = new FirefoxDriver();
		baseUrl = "http://lxw198902165221.blog.163.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testIframe() throws Exception {
		driver.findElement(By.xpath("//a[contains(text(),'写日志')]")).click();
		driver.findElement(By.cssSelector("input.ztag")).clear();
		driver.findElement(By.cssSelector("input.ztag")).sendKeys("标题1");
		WebElement frame = driver
				.findElement(By.xpath("/x:html/x:body"));
		driver.switchTo().frame(frame);

		// driver.findElement(By.cssSelector("input.zebx ztag")).clear();
		// driver.findElement(By.cssSelector("input.zebx ztag")).sendKeys("标题1");
		driver.findElement(By.name("key-093402170-a")).click();
		driver.findElement(By.name("id-68706429-a")).click();
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
