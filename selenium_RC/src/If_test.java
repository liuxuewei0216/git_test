

import java.sql.Date;
import java.util.Timer;

import com.test.test_cendao;

/*ʹ��timer�ò�������ִ�����Σ�֮����ִ��*/
public class If_test {
	public static void main(String[] args) {
		Timer timer = new Timer();
		for (int i = 1; i < 10; i++)
			if (i <= 5) {
				timer.schedule(new test_cendao(), new Date(2));
			} else {
				System.out.println("�Ѿ�����������");
			}
	}
}
