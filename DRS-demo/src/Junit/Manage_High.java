package Junit;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import cn.sunline.edsp.midware.drs.api.impl.common.ClientDRSConstant;
import cn.sunline.edsp.midware.drs.common.model.DCN;

/*此部分用例已经完成集成测试，请严格按照要求执行本测试类，否则会出错或影响后面的方法
 * 注意：
 * 1、F本类中含有beforeclass，必须整个测试类一起执行
 * 2、引入了FixMethodOrder，测试方法之间有影响，所有的测试方法必须按照顺序执行*/
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Manage_High {
	static String dcn1 = "dcn1";

	@BeforeClass
	public static void init() {
		ParentTest.getInstance();

	}

	/* 按对公数据区/对私数据区/管理数据区新增一个DCN */
	@Test
	public void a_createADCN() {
		Assert.assertEquals("success", ParentTest.client.createDCNByADCN(dcn1));
		List<DCN> dcns = ParentTest.client.getADCN();
		for (DCN Dcn : dcns) {
			Assert.assertEquals(Dcn.getDcnID(), dcn1);
			Assert.assertEquals(Dcn.getMappingCounts(), 0);
			Assert.assertEquals(Dcn.getType(), ClientDRSConstant.DCN_A);
		}
	}

	/* 按类型获取全部DCN */
	@Test
	public void b_getDCNByType() {
		List<DCN> dcns = ParentTest.client
				.getDCNByType(ClientDRSConstant.DCN_A);
		Assert.assertEquals(true, !dcns.isEmpty());
		for (DCN dcn : dcns) {
			if (dcn != null) {
				Assert.assertEquals(dcn.getDcnID(), dcn1);
				Assert.assertEquals(dcn.getMappingCounts(), 0);
				Assert.assertEquals(dcn.getType(), ClientDRSConstant.DCN_A);
			}
		}
	}

	/* 按对公数据区/对私数据区/管理数据区获取全部DCN */
	@Test
	public void c_getADCN() {
		List<DCN> dcns = ParentTest.client.getADCN();
		for (DCN dcn : dcns) {
			if (dcn != null) {
				Assert.assertEquals(dcn.getDcnID(), dcn1);
				Assert.assertEquals(dcn.getMappingCounts(), 0);
				Assert.assertEquals(dcn.getType(), ClientDRSConstant.DCN_A);
			}
		}
	}

	/* 按类型分配一个可用DCN */
	@Test
	public void d_allocDCN() {
		DCN dcns = ParentTest.client.allocDCNByType(ClientDRSConstant.DCN_A);
		if (dcns != null) {
			Assert.assertEquals(dcns.getDcnID(), dcn1);
			Assert.assertEquals(dcns.getMappingCounts(), 0);
			Assert.assertEquals(dcns.getType(), ClientDRSConstant.DCN_A);
		}
	}

	/* 按对公数据区/对私数据区/管理数据区分配一个可用DCN */
	@Test
	public void e_allocADCN() {
		DCN dcns = ParentTest.client.allocADCN();
		if (dcns != null) {
			Assert.assertEquals(dcns.getDcnID(), dcn1);
			Assert.assertEquals(dcns.getMappingCounts(), 0);
			Assert.assertEquals(dcns.getType(), ClientDRSConstant.DCN_A);
		}
	}

	/* 删除已有DCN */

	@Test
	public void f_deleteDCN() {
		Assert.assertEquals("success", ParentTest.client.deleteDCN(dcn1));
		/*
		 * List<DCN> dcns = client.getCDCN(); Assert.assertNull(dcns);
		 */

	}

}
