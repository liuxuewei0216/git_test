package test;

//通过继承Thread类型实现多线程的方法
public class ThreadDemo extends Thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadDemo thread = new ThreadDemo();
		thread.start();
		thread.start();
		thread.start();

	}

	@Override
	public void run() {
		System.out.println("dddd");
	}
}
