package Junit;

import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.sunline.edsp.midware.drs.api.impl.common.ClientDRSConstant;

/*此部分用例已经完成集成测试，请严格按照要求执行本测试类，否则会出错或影响后面的方法
 * 注意：
 * 1、本类中含有beforeclass方法，必须整个测试类一起执行
 */
public class QueryTest {
	static String id1 = "id1";
	static String[] accounts1 = { "id3", "id4" };
	static String id2 = "id2";
	static String[] accounts2 = { "id5", "id6" };
	static String dcn = "dcn1";

	@BeforeClass
	public static void init() {
		ParentTest.getInstance();

		ParentTest.client.createDCN(ClientDRSConstant.DCN_C, dcn);
		ParentTest.client
				.registryDCN(ClientDRSConstant.CUSTOMER_ECIF, id1, dcn);
	}

	@AfterClass
	public static void after() {
		ParentTest.client.destroyDCN(ClientDRSConstant.CUSTOMER_ECIF, id1);
		ParentTest.client.batchDestroyDCNByECIF(accounts1);
		ParentTest.client.deleteDCN(dcn);
	}

	/* 查询一个客户映射的DCN号 */
	@Test
	public void queryDCN() {
		String results = ParentTest.client.queryDCN(
				ClientDRSConstant.CUSTOMER_ECIF, id1);
		Assert.assertEquals(dcn, results);
	}

	/* 批量查询一组客户映射的DCN号 */
	@Test
	public void batchqueryDCN() {
		ParentTest.client.batchRegistryDCN(ClientDRSConstant.CUSTOMER_ECIF,
				accounts1, dcn);
		Map<String, String> results = ParentTest.client.batchQueryDCN(
				ClientDRSConstant.CUSTOMER_ECIF, accounts1);
		for (String s1 : accounts1) {
			Assert.assertEquals(results.get(s1), dcn);
			/*
			 * System.out.println("+++++++" + results.size()); Iterator<String>
			 * keys = results.keySet().iterator(); while (keys.hasNext()) {
			 * String key = keys.next(); System.out.println(key + ":" +
			 * results.get(key));
			 */
		}
	}

	/* 按客户号/身份证号/手机号/银行账户号/银行卡号查询一个客户映射的DCN号 */
	@Test
	public void queryDCNByECIF() {
		String results = ParentTest.client.queryDCNByECIF(id1);
		Assert.assertEquals(dcn, results);
	}

	/* 按客户号/身份证号/手机号/银行账户号/银行卡号批量查询一组客户映射的DCN号 */
	@Test
	public void batchqueryDCNByECIF() {
		Map<String, String> results = ParentTest.client
				.batchQueryDCNByECIF(accounts1);
		for (String s1 : accounts1) {
			Assert.assertEquals(results.get(s1), dcn);
		}
	}
}
