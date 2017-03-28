package test;

import static org.junit.Assert.assertEquals;

import java.util.TimerTask;

import junit.Cal;

import org.junit.Before;
import org.junit.Test;

/*忽略测试某个测试方法，在前面加@Ignore
 每个测试之前都要执行的操作用@Before，每一个测试之后都要执行的操作用@After表示
 在每个测试类开始前执行被标注为 @BeforeClass，类开始以后执行为 @AfterClass ，并且该方法必须是 Public 和 Static 的。
 可以给测试用例设置超时时间，在@test后加timeout=100，即是100ms以后超时*/
public class CalTest extends TimerTask{
	private static Cal cal = new Cal();

	@Before
	public void setUp() throws Exception {
		cal.clear();
	}
	@Test
	public void testAdd() {
		cal.add(5);
		cal.add(5);
		assertEquals(10, cal.getResult());
	}

	@Test()
	public void TestTimeout() {
		assertEquals(5050, cal.timeout());
	}

	@Test()
	public void TestTimeout2() {
		cal.timeout2();
		assertEquals(5050, cal.getResult());
	}

	@Test()
	public void TestSum() {
		cal.sum();
		assertEquals(5050, cal.getResult());
	}
	@Test()
	public void Testaddadd(){
		assertEquals(3, cal.sumij(2, 1));
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
