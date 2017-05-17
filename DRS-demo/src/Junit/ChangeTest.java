package Junit;

import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import cn.sunline.edsp.midware.drs.api.impl.common.ClientDRSConstant;

/*此部分用例已经完成集成测试，请严格按照要求执行本测试类，否则会出错或影响后面的方法
 * 注意：
 * 1、本类中含有beforeclass方法，必须整个测试类一起执行
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ChangeTest {
	static String id1 = "id1";
	static String id2 = "id2";
	static String[] accounts1 = { "id3", "id4" };
	static String[] accounts2 = { "id5", "id6" };
	static String dcn = "dcn1";
	static String newdcn = "dcn2";

	@BeforeClass
	public static void init() {
		// 初始化
		ParentTest.getInstance();

		ParentTest.client.createDCN(ClientDRSConstant.DCN_C, dcn);
		ParentTest.client.createDCN(ClientDRSConstant.DCN_C, newdcn);
		ParentTest.client
				.registryDCN(ClientDRSConstant.CUSTOMER_ECIF, id1, dcn);
		ParentTest.client
				.registryDCN(ClientDRSConstant.CUSTOMER_ECIF, id2, dcn);
		ParentTest.client.batchRegistryDCN(ClientDRSConstant.CUSTOMER_ECIF,
				accounts1, dcn);
		ParentTest.client.batchRegistryDCN(ClientDRSConstant.CUSTOMER_ECIF,
				accounts2, dcn);
	}

	@AfterClass
	public static void after() {
		ParentTest.client.destroyDCN(ClientDRSConstant.CUSTOMER_ECIF, id1);
		ParentTest.client.destroyDCN(ClientDRSConstant.CUSTOMER_ECIF, id2);
		ParentTest.client.batchDestroyDCNByECIF(accounts1);
		ParentTest.client.batchDestroyDCNByECIF(accounts2);
		System.out.println("*****************"
				+ ParentTest.client.deleteDCN(dcn));
		ParentTest.client.deleteDCN(newdcn);
	}

	/* 将一个客户的DCN映射关系从原DCN迁移至新DCN */
	@Test
	public void changeDCN() {
		String results = ParentTest.client.changeDCN(
				ClientDRSConstant.CUSTOMER_ECIF, id1, newdcn);
		Assert.assertEquals("success", results);
		String nowdcn = ParentTest.client.queryDCNByECIF(id1);
		Assert.assertEquals(nowdcn, newdcn);
	}

	/* 批量将一组客户的DCN映射关系从原DCN迁移至新DCN */
	@Test
	public void batchChangeDCN() {
		Map<String, String> result1 = ParentTest.client.batchChangeDCNByECIF(
				accounts1, newdcn);
		for (String s1 : accounts1) {
			Assert.assertEquals(result1.get(s1), "success");
		}
		Map<String, String> result2 = ParentTest.client
				.batchQueryDCNByECIF(accounts1);
		for (String s2 : accounts1) {
			Assert.assertEquals(result2.get(s2), newdcn);
		}
	}

	/* 按客户号/身份证号/手机号/银行账户号/银行卡号将一个客户的DCN映射关系从原DCN迁移至新DCN */
	@Test
	public void changeDCNByECIF() {
		String results = ParentTest.client.changeDCNByECIF(id2, newdcn);
		Assert.assertEquals("success", results);
		String nowdcn = ParentTest.client.queryDCNByECIF(id2);
		Assert.assertEquals(nowdcn, newdcn);
	}

	/* 按客户号/身份证号/手机号/银行账户号/银行卡号批量将一组客户的DCN映射关系从原DCN迁移至新DCN */
	@Test
	public void batchqueryDCNByECIF() {
		Map<String, String> result1 = ParentTest.client.batchChangeDCNByECIF(
				accounts2, newdcn);
		for (String s1 : accounts2) {
			Assert.assertEquals(result1.get(s1), "success");
		}
		Map<String, String> result2 = ParentTest.client
				.batchQueryDCNByECIF(accounts2);
		for (String s2 : accounts2) {
			Assert.assertEquals(result2.get(s2), newdcn);
		}
	}
}
