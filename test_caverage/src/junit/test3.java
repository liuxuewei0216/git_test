package junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.experimental.categories.Category;

/*testx测试方法都属于Inter1，testxi属于Inter2接口*/
public class test3 {
	@Category(Inter1.class)
	@Test
	public void testx() {
		int i = 1;
		assertEquals(1, i);
	}

	@Category(Inter2.class)
	@Test
	public void testxi() {
		int i = 1;
		assertEquals(2, i);
	}
}
