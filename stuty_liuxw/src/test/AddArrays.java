package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//数组相加的办法
public class AddArrays {
	public static void main(String args[]) {
		String a[] = { "A", "E", "I" };
		String b[] = { "O", "U" };
		// 把数组a转为一个list
		List list = new ArrayList(Arrays.asList(a));
		// 把数组a和b转换过后的list相加
		list.addAll(Arrays.asList(b));
		// 把相加过后的list转化为数组
		Object[] c = list.toArray();
		// 从最终的效果来看，打印list和打印数组的效果是一样的
		System.out.println(list);
		System.out.println(Arrays.toString(c));
	}
}
