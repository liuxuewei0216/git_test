package test;

public class TestThrad extends Thread {

	public TestThrad() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		while (true)
			System.err.println("****");

	}

	// 开启十个线程，同时跑run里面的内容
	public static void main(String[] args) {
		new TestThrad().start();
		new TestThrad().start();
		new TestThrad().start();
		new TestThrad().start();
		new TestThrad().start();
		new TestThrad().start();
		new TestThrad().start();
		new TestThrad().start();
		new TestThrad().start();
		new TestThrad().start();
	}

}
