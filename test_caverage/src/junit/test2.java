package junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.experimental.categories.Category;

/*所有测试方法都属于Inter1和Inter2两个接口*/
@Category({ Inter1.class, Inter2.class })
public class test2 {

	@Test
	public void testxiao() {
		int i = 1;
		assertEquals(1, i);
	}

	@Test
	public void testxiaow() {
		int i = 1;
		assertEquals(1, i);
	}
}
