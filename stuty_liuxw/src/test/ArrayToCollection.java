package test;

import java.util.*;
import java.io.*;

public class ArrayToCollection {
	public static void main(String args[]) throws IOException {
		int n = 10; // 5 个元素
		// 定义一个含有五个元素的数组
		String[] name = new String[n];
		for (int i = 0; i < n; i++) {
			// String.valueOf(i)是 把i转化为string类型
			// name[1] = "fdasdffaf";
			name[i] = String.valueOf(i + 1);

		}
		List<String> list = Arrays.asList(name);
		System.out.println();
		for (String li : list) {
			String str = li;
			System.out.print(str + " ");
		}
	}
}
