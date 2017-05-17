package Junit;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import cn.sunline.edsp.midware.drs.api.impl.common.ClientDRSConstant;

/*此部分用例已经完成集成测试，请严格按照要求执行本测试类，否则会出错或影响后面的方法
 * 注意：
 * 1、本类中含有beforeclass方法，必须整个测试类一起执行
 */
public class Query_Excep {
	static String id1 = "id1";
	static String id2 = "id2";
	static String[] accounts1 = { "id3", "id4" };
	static String[] accounts2 = { "id2", "id5" };
	static String dcn = "dcn1";

	static {
		ParentTest.getInstance();

	}

	/* 查询一个不存在的客户映射的DCN号 */
	@Test
	public void queryDCN() {
		try {
			ParentTest.client.queryDCN(ClientDRSConstant.CUSTOMER_ECIF, id1);
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String msg = sw.toString();
			String exp = "客户信息[Ecif:" + id1 + "]不存在";
			Assert.assertNotEquals(-1, msg.indexOf(exp));
		}
	}

	/* 查询一个客户号为空 */
	@Test
	public void queryDCN_2() {
		try {
			ParentTest.client.queryDCN(ClientDRSConstant.CUSTOMER_ECIF, "");
		} catch (Exception e) {
			// e.printStackTrace();
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String msg = sw.toString();
			String exp = "queryDCN方法参数不能为空！";
			Assert.assertNotEquals(-1, msg.indexOf(exp));
		}
	}

	/* 查询一个客户类型为空 */
	@Test
	public void queryDCN_3() {
		try {
			ParentTest.client.queryDCN("", "id1");
		} catch (Exception e) {
			// e.printStackTrace();
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String msg = sw.toString();
			String exp = "queryDCN方法参数不能为空！";
			Assert.assertNotEquals(-1, msg.indexOf(exp));
		}
	}

	/* 批量查询一组不存在的客户映射的DCN号 */
	@Test
	public void batchqueryDCN() {
		try {
			Map<String, String> results = ParentTest.client.batchQueryDCN(
					ClientDRSConstant.CUSTOMER_ECIF, accounts1);
			for (String s1 : accounts1) {
				Assert.assertNull(results.get(s1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/* 批量查询一组部分客户不存在的,id5不存在 */
	@Test
	public void batchqueryDCN_2() {
		try {
			ParentTest.client.createDCNByADCN(dcn);
			ParentTest.client.registryDCNByECIF(id2);
			Map<String, String> results = ParentTest.client.batchQueryDCN(
					ClientDRSConstant.CUSTOMER_ECIF, accounts2);
			Assert.assertNull(results.get("id5"));
			ParentTest.client.destroyDCNByECIF(id2);
			ParentTest.client.deleteDCN(dcn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
