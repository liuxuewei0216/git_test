package junit;

import static org.junit.Assert.assertEquals;

import java.util.TimerTask;

import org.junit.Test;

/*可用于使用定时器的测试类，继承了定时任务的类*/
public class test1 extends TimerTask {
	@Test
	public void run() {
		int i = 1;
		assertEquals(1, i);
	}
}
