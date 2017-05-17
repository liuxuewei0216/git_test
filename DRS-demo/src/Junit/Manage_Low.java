package Junit;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import cn.sunline.edsp.midware.drs.api.impl.common.ClientDRSConstant;
import cn.sunline.edsp.midware.drs.common.model.DCN;

/*此部分用例已经完成集成测试，请严格按照要求执行本测试类，否则会出错或影响后面的方法
 * 注意：
 * 1、本类中含有beforeclass，必须整个测试类一起执行
 * 2、引入了FixMethodOrder，测试方法之间有影响，所有的测试方法必须按照顺序执行*/
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Manage_Low {
	static String dcn1 = "dcn1";
	String dcn2 = "dcn2";

	@BeforeClass
	public static void init() {
		ParentTest.getInstance();
	}

	/* 新增一个DCN */
	@Test
	public void createDCN() {

		Assert.assertEquals("success",
				ParentTest.client.createDCN(ClientDRSConstant.DCN_A, dcn1));
		List<DCN> dcns = ParentTest.client.getADCN();
		for (DCN Dcn : dcns) {
			Assert.assertEquals(dcn1, Dcn.getDcnID());
			Assert.assertEquals(0, Dcn.getMappingCounts());
			Assert.assertEquals(ClientDRSConstant.DCN_A, Dcn.getType());
		}
	}

	@Ignore
	/* 获取全部DCN */
	@Test
	public void getDCN() {
		List<DCN> dcns = ParentTest.client.getDCN();
		for (DCN dcn : dcns) {
			Assert.assertEquals(dcn1, dcn.getDcnID());
			Assert.assertEquals(0, dcn.getMappingCounts());
			Assert.assertEquals(ClientDRSConstant.DCN_A, dcn.getType());
		}
	}

	/* 修改已有DCN号 */
	@Test
	public void updateDCN() {
		Assert.assertEquals("success", ParentTest.client.updateDCN(dcn1, dcn2));
		List<DCN> dcns = ParentTest.client.getADCN();
		for (DCN Dcn : dcns) {
			Assert.assertEquals(dcn2, Dcn.getDcnID());
			Assert.assertEquals(0, Dcn.getMappingCounts());
			Assert.assertEquals(ClientDRSConstant.DCN_A, Dcn.getType());
		}
	}

	/* 删除已有DCN */

	@Test
	public void z_deleteDCN() {
		Assert.assertEquals("success", ParentTest.client.deleteDCN(dcn2));
		/*
		 * List<DCN> dcns = client.getCDCN(); Assert.assertNull(dcns);
		 */

	}

	/* 更改dcn状态，由于不好判断结果并且会影响其他用例执行，暂将其忽略 */
	@Ignore
	@Test
	public void ychangestatus() {
		ParentTest.client.changeStatus(dcn1, "unavailable");
		System.out.println("*******************"
				+ ParentTest.client.registryDCN(
						ClientDRSConstant.CUSTOMER_ECIF, "id2", dcn1));

	}

}
