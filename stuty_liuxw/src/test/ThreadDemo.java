package test;

//通过继承Thread类型实现多线程的方法
public class ThreadDemo extends Thread {
	static int result = 0;

	public static void main(String[] args) throws InterruptedException {
		// 初始化实例，并执行run方法，start就是执行run方法
		ThreadDemo thread = new ThreadDemo();
		thread.start();
//		join方法的意思是等待线程结束
		thread.join();
		// 下面的代码可以达到和上面两行同样的效果，如果不是run方法，则直接写方法名即可
		new ThreadDemo().run1();
		thread.join();
		System.out.println(result);
	}

	public void run1() {
		for (int i = 0; i < 10000; i++) {
			result = result + i;
		}
	}

	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			result = result + i;
		}
	}
}
