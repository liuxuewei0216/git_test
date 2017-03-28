import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.test.rightlogin;
import com.test.wrong_password;
import com.test.wrong_username;
import com.test.zhuxiao;
@RunWith(Suite.class)
@SuiteClasses({
	wrong_password.class,
	wrong_username.class,
	rightlogin.class,
	zhuxiao.class
  })
public class AllTest {

}
