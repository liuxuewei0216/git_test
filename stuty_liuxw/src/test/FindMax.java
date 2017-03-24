package test;

import java.util.*;
//给字符串排序，默认是0-9，a-z
public class FindMax {
   public static void main(String[] args) {
      List list = Arrays.asList("one Two three Four five six one three Four 123 456 02".split(" "));
		Collections.sort(list);
//		Collections.reverse(list);
		Iterator<String>  i = list.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
//      System.out.println(list);
		}
      System.out.println("最大值: " + Collections.max(list));
      System.out.println("最小值: " + Collections.min(list));
   }
}
