package test;

import junit.Inter1;
import junit.Inter2;
import junit.test2;
import junit.test3;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

/*给测试用例分类，达到仅执行某一部分用例的效果*/
@RunWith(Categories.class)
@ExcludeCategory(Inter1.class)
@SuiteClasses({ test2.class, test3.class })
public class Categories_Test {
}
/*
 * @IncludeCategory(SlowTests.class)
 * 
 * @SuiteClasses( { A.class, B.class }) // Note that Categories is a kind of
 * Suite public class SlowTestSuite { // Will run A.b and B.c, but not A.a }
 */