package junit;

import org.junit.Test;

public class Cal {
	private static int result; // 静态变量，用于存储运行结果

	public void add(int n) {
		result = result + n;
	}

	public int timeout() {
		int i = 1;
		for (i = 1; i <= 100; i++) {
			result = result + i;
		}
		return result;
	}

	public void timeout2() {
		int n;
		for (n = 1; n <= 100; n++) {
			result = result + n;
		}
	}

	public void sum() {
		int n = 0;
		while (n < 100) {
			n++;
			result = result + n;

		}
	}

	public void clear() { // 将结果清零
		result = 0;
	}

	public int getResult() {
		return result;
	}

	public int sumij(int n, int m) {
		int sumij = n + m;
		return sumij;
	}
}
