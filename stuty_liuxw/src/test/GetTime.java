package test;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetTime {
	public static void main(String[] args) {
		// 获取当前时间戳
		Long timeStamp = System.currentTimeMillis();
		System.out.println(timeStamp);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 时间戳转换成时间
		String sd = sdf.format(new Date(Long.parseLong(String
				.valueOf(timeStamp))));
		System.out.println(sd);
	}
}