package junit;

import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		char ch='a';
		while (ch!='\n'){
			System.out.println(ch);
			ch= (char)System.in.read() ;  // 接收键盘输入


		}
	}

}
