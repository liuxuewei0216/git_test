package Junit;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import cn.sunline.edsp.midware.drs.api.impl.common.ClientDRSConstant;

/*此部分用例已经完成集成测试，请严格按照要求执行本测试类，否则会出错或影响后面的方法
 */
public class Regist_Excep {
	static String id1 = "id1";
	static String[] accounts1 = { "id1", "id4" };
	static String dcn = "dcn1";

	static {
		ParentTest.getInstance();

	}

	/* 注册一个已经存在的客户信息 */
	@Test
	public void regDCN_1() {
		try {
			ParentTest.client.createDCNByADCN(dcn);
			ParentTest.client.registryDCN(ClientDRSConstant.CUSTOMER_ECIF, id1);
			ParentTest.client.registryDCN(ClientDRSConstant.CUSTOMER_ECIF, id1);
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String msg = sw.toString();
			String exp = "Ecif:" + id1 + "已注册在DCN上，不能重复注册";
			Assert.assertNotEquals(-1, msg.indexOf(exp));
			ParentTest.client.deleteDCN(dcn);
			ParentTest.client.destroyDCNByECIF(id1);

		}
	}

	/* 手动注册，注册时指定的DCN不存在 */
	@Test
	public void regDCN_2() {
		try {
			ParentTest.client.registryDCN(ClientDRSConstant.CUSTOMER_ECIF, id1,
					dcn);
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String msg = sw.toString();
			String exp = "DCN[" + dcn + "]不存在或不可用，请检查";
			Assert.assertNotEquals(-1, msg.indexOf(exp));
		}
	}

	/* 自动注册，注册时数据中不存在任何DCN */
	@Test
	public void regDCN_3() {
		try {
			ParentTest.client.registryDCN(ClientDRSConstant.CUSTOMER_ECIF, id1);
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String msg = sw.toString();
			String exp = "数据库中不存在任何dcn节点信息。请先注册dcn信息，再注册用户信息";
			Assert.assertNotEquals(-1, msg.indexOf(exp));
		}
	}

	/* 批量自动注册一组客户的DCN映射关系，部分客户数据已经存在 */
	@Test
	public void batRegDCN_1() {
		ParentTest.client.createDCNByADCN(dcn);
		ParentTest.client
				.registryDCN(ClientDRSConstant.CUSTOMER_ECIF, id1, dcn);
		Map<String, String> result = ParentTest.client.batchRegistryDCN(
				ClientDRSConstant.CUSTOMER_ECIF, accounts1);
		Assert.assertNull(result.get(id1));
		ParentTest.client.deleteDCN(dcn);
		ParentTest.client.batchDestroyDCNByECIF(accounts1);
	}

	/* 批量手動注册一组客户的DCN映射关系，指定的dcn不存在 */
	@Test
	public void batRegDCN_2() {
		Map<String, String> result = ParentTest.client.batchRegistryDCN(
				ClientDRSConstant.CUSTOMER_ECIF, accounts1, dcn);
		for (String s1 : accounts1) {
			Assert.assertNull(result.get(s1));
		}
	}
}
