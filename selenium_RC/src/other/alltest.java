package other;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.test.none_password;
import com.test.none_username;
//执行多个单元测试
@RunWith(Suite.class)
@SuiteClasses({
 none_password.class,
 none_username.class
 
  })
public class alltest {

}