package test;

import static org.junit.Assert.*;
import junit.IfElseDemo;

import org.junit.Test;

public class IfElseDemoTest {
	IfElseDemo ifElseDemo =new IfElseDemo();
	@Test
	public void testMain() {
//		ifElseDemo.main(86);
		
		assertEquals("a", ifElseDemo.main(96));
		
	}

}
