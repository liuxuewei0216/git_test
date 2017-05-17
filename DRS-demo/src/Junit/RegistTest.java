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
public class RegistTest {
	static String id1 = "id1";
	static String id2 = "id2";
	static String id3 = "id7";
	static String id4 = "id8";
	static String[] accounts1 = { "id3", "id4" };
	static String[] accounts2 = { "id5", "id6" };
	static String[] accounts3 = { "id9", "id10" };
	static String[] accounts4 = { "id11", "id12" };
	static String dcn = "dcn1";

	@BeforeClass
	public static void init() {
		ParentTest.getInstance();

		ParentTest.client.createDCN(ClientDRSConstant.DCN_C, dcn);
	}

	@AfterClass
	public static void after() {
		ParentTest.client.destroyDCN(ClientDRSConstant.CUSTOMER_ECIF, id1);
		ParentTest.client.destroyDCN(ClientDRSConstant.CUSTOMER_ECIF, id2);
		ParentTest.client.destroyDCN(ClientDRSConstant.CUSTOMER_ECIF, id3);
		ParentTest.client.destroyDCN(ClientDRSConstant.CUSTOMER_ECIF, id4);
		ParentTest.client.batchDestroyDCNByECIF(accounts1);
		ParentTest.client.batchDestroyDCNByECIF(accounts2);
		ParentTest.client.batchDestroyDCNByECIF(accounts3);
		ParentTest.client.batchDestroyDCNByECIF(accounts4);
		ParentTest.client.deleteDCN(dcn);
	}

	/* 自动注册一个客户的DCN映射关系 */
	@Test
	public void registryDCN() {
		Assert.assertEquals(ParentTest.client.registryDCN(
				ClientDRSConstant.CUSTOMER_ECIF, id1), dcn);
	}

	/* 手动注册一个客户的DCN映射关系 */
	@Test
	public void registryDCN2() {
		Assert.assertEquals("success", ParentTest.client.registryDCN(
				ClientDRSConstant.CUSTOMER_ECIF, id2, dcn));
		Assert.assertEquals(dcn, ParentTest.client.queryDCNByECIF(id2));
	}

	/* 批量自动注册一组客户的DCN映射关系 */
	@Test
	public void batchRegistryDCN() {
		Map<String, String> results = ParentTest.client.batchRegistryDCN(
				ClientDRSConstant.CUSTOMER_ECIF, accounts1);
		for (String s1 : accounts1) {
			Assert.assertEquals(results.get(s1), dcn);
		}

	}

	/* 批量手動注册一组客户的DCN映射关系 */
	@Test
	public void batchRegistryDCN2() {
		Map<String, String> result1 = ParentTest.client.batchRegistryDCN(
				ClientDRSConstant.CUSTOMER_ECIF, accounts2, dcn);
		for (String s1 : accounts2) {
			Assert.assertEquals(result1.get(s1), dcn);
		}
		// Assert.assertEquals(true, client.batchRegistryDCN(
		// ClientDRSConstant.CUSTOMER_ECIF, accounts2, dcn));
		Map<String, String> result2 = ParentTest.client
				.batchQueryDCNByECIF(accounts2);
		for (String s1 : accounts2) {
			Assert.assertEquals(result2.get(s1), dcn);
		}
	}

	/* 按客户号/身份证号/手机号/银行账户号/银行卡号自动注册一个客户的DCN映射关系 */
	@Test
	public void RegistryDCNByECIF() {
		String results = ParentTest.client.registryDCNByECIF(id3);
		System.out.print("**********" + results);
		Assert.assertEquals(dcn, results);

	}

	/* 按客户号/身份证号/手机号/银行账户号/银行卡号手动注册一个客户的DCN映射关系 */
	@Test
	public void registryDCN2ByECIF() {
		Assert.assertEquals("success",
				ParentTest.client.registryDCNByECIF(id4, dcn));
		Assert.assertEquals(dcn, ParentTest.client.queryDCNByECIF(id4));

	}

	/* 按客户号/身份证号/手机号/银行账户号/银行卡号批量自动注册一组客户的DCN映射关系 */
	@Test
	public void batchRegistryDCNByECIF() {
		Map<String, String> results = ParentTest.client
				.batchRegistryDCNByECIF(accounts3);
		for (String s1 : accounts3) {
			Assert.assertEquals(dcn, results.get(s1));
		}

	}

	/* 按客户号/身份证号/手机号/银行账户号/银行卡号批量手动注册一组客户的DCN映射关系 */
	@Test
	public void batchRegistryDCN2ByECIF() {
		Map<String, String> result1 = ParentTest.client.batchRegistryDCNByECIF(
				accounts4, dcn);
		for (String s1 : accounts4) {
			Assert.assertEquals(result1.get(s1), dcn);
		}
		Map<String, String> result2 = ParentTest.client
				.batchQueryDCNByECIF(accounts4);
		for (String s2 : accounts4) {
			Assert.assertEquals(result2.get(s2), dcn);
		}
	}
}
