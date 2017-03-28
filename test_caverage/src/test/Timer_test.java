package test;

import java.util.Timer;

import junit.test1;

/*使用timer让测试用例反复执行，如下，从第一秒开始执行，每五秒执行一次*/
public class Timer_test {
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new test1(), 1000, 5000);
	} 
}
