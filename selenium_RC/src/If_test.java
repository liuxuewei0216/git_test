

import java.sql.Date;
import java.util.Timer;

import com.test.test_cendao;

/*使用timer让测试用例执行三次，之后不再执行*/
public class If_test {
	public static void main(String[] args) {
		Timer timer = new Timer();
		for (int i = 1; i < 10; i++)
			if (i <= 5) {
				timer.schedule(new test_cendao(), new Date(2));
			} else {
				System.out.println("已经跑完了三次");
			}
	}
}
