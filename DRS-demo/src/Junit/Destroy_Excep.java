package Junit;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import cn.sunline.edsp.midware.drs.api.impl.common.ClientDRSConstant;

/*此部分用例已经完成集成测试，请严格按照要求执行本测试类，否则会出错或影响后面的方法
 */

public class Destroy_Excep {
	static String id1 = "id1";
	static String id2 = "id2";
	static String[] accounts1 = { "id3", "id4" };
	static String[] accounts2 = { "id5", "id6" };
	static String dcn = "dcn1";

	static {
		ParentTest.getInstance();
	}

	/* 注销一个不存在的客户 */
	@Test
	public void des_1() {
		try {
			ParentTest.client.destroyDCN(ClientDRSConstant.CUSTOMER_ECIF, id1);
		} catch (Exception e) {
			// e.printStackTrace();
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String msg = sw.toString();
			String exp = "您指定的客户信息[Ecif:" + id1 + "]不存在";
			Assert.assertNotEquals(-1, msg.indexOf(exp));
		}
	}

	/* 注销的客户为空 */
	@Test
	public void des_2() {
		try {
			ParentTest.client.destroyDCN(ClientDRSConstant.CUSTOMER_ECIF, "");
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String msg = sw.toString();
			String exp = "destroyDCN方法参数不能为空！";
			Assert.assertNotEquals(-1, msg.indexOf(exp));
		}
	}

	/* 批量注销一组客户的DCN映射关系 */
	@Test
	public void batchdestroyDCN() {
		Map<String, String> result1 = ParentTest.client.batchDestroyDCN(
				ClientDRSConstant.CUSTOMER_ECIF, accounts1);
		for (String s1 : accounts1) {
			Assert.assertEquals("fail", result1.get(s1));
		}
	}
}
