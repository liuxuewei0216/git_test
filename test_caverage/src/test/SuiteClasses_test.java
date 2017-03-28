package test;

import junit.test2;
import junit.test3;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/*批量执行测试用例*/
@RunWith(Suite.class)
@SuiteClasses({ test2.class, test3.class })
public class SuiteClasses_test {
}
