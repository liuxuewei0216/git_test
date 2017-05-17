package Junit;

import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import cn.sunline.edsp.midware.drs.api.impl.common.ClientDRSConstant;
import cn.sunline.edsp.midware.drs.common.model.DCN;

/*此部分用例已经完成集成测试，请严格按照要求执行本测试类，否则会出错或影响后面的方法
 * 注意：
 * 1、本类中含有beforeclass，必须整个测试类一起执行
 * 2、引入了FixMethodOrder，测试方法之间有影响，所有的测试方法必须按照顺序执行*/
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DestroyTest {
	static String id1 = "id1";
	static String id2 = "id2";
	static String[] accounts1 = { "id3", "id4" };
	static String[] accounts2 = { "id5", "id6" };
	static String dcn = "dcn1";

	@BeforeClass
	public static void init() {
		ParentTest.getInstance();
		ParentTest.client.createDCN(ClientDRSConstant.DCN_C, dcn);
		ParentTest.client.registryDCN(ClientDRSConstant.CUSTOMER_ECIF, id1);
		ParentTest.client.registryDCN(ClientDRSConstant.CUSTOMER_ECIF, id2);
		ParentTest.client.batchRegistryDCN(ClientDRSConstant.CUSTOMER_ECIF, accounts1);
		ParentTest.client.batchRegistryDCN(ClientDRSConstant.CUSTOMER_ECIF, accounts2);
	}

	@AfterClass
	public static void after() {
		ParentTest.client.deleteDCN(dcn);
	}

	/* 注销一个客户的DCN映射关系 */
	@Test
	public void destroyDCN() {
		String results = ParentTest.client
				.destroyDCN(ClientDRSConstant.CUSTOMER_ECIF, id1);
		System.out.println("************" + results);
		Assert.assertEquals("success", results);
	}

	/* 批量注销一组客户的DCN映射关系 */
	@Test
	public void batchdestroyDCN() {
		// Assert.assertEquals(true, client.batchDestroyDCN(
		// ClientDRSConstant.CUSTOMER_ECIF, accounts1));
		Map<String, String> result1 = ParentTest.client.batchDestroyDCN(
				ClientDRSConstant.CUSTOMER_ECIF, accounts1);
		for (String s1 : accounts1) {
			Assert.assertEquals(result1.get(s1), "success");
		}
		List<DCN> dcns = ParentTest.client.getCDCN();
		for (DCN Dcn : dcns) {
			Assert.assertEquals(4, Dcn.getMappingCounts());
		}
	}

	/* 按客户号/身份证号/手机号/银行账户号/银行卡号注销一个客户的DCN映射关系 */
	@Test
	public void destroyDCNByECIF() {
		String historydcn = ParentTest.client.queryDCNByECIF(id2);
		String results = ParentTest.client.destroyDCNByECIF(id2);
		System.out.println("########" + historydcn);
		System.out.println("************" + results);
		Assert.assertEquals("success", results);
	}

	/* 按客户号/身份证号/手机号/银行账户号/银行卡号批量注销一组客户的DCN映射关系 */
	@Test
	public void batchqueryDCNByECIF() {
		Map<String, String> result1 = ParentTest.client.batchDestroyDCN(
				ClientDRSConstant.CUSTOMER_ECIF, accounts2);
		for (String s1 : accounts2) {
			Assert.assertEquals(result1.get(s1), "success");
		}
		List<DCN> dcns = ParentTest.client.getCDCN();
		for (DCN Dcn : dcns) {
			Assert.assertEquals(2, Dcn.getMappingCounts());
		}
	}
}
