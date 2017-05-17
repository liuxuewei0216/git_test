package Junit;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import cn.sunline.edsp.midware.drs.api.impl.common.ClientDRSConstant;

/*此部分用例已经完成集成测试，请严格按照要求执行本测试类，否则会出错或影响后面的方法
 */
public class Change_Excep {
	static String id1 = "id1";
	static String id2 = "id2";
	static String[] accounts1 = { "id3", "id4" };
	static String[] accounts2 = { "id5", "id6" };
	static String dcn = "dcn1";
	static String newdcn = "dcn2";

	static {
		ParentTest.getInstance();

	}

	/* 将一个客户的DCN映射关系从原DCN迁移至新DCN,新的dcn不存在 */
	@Test
	public void changeDCN() {
		try {
			ParentTest.client.changeDCN(ClientDRSConstant.CUSTOMER_ECIF, id1,
					dcn);
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String msg = sw.toString();
			String exp = "DCN[" + dcn + "]不存在";
			Assert.assertNotEquals(-1, msg.indexOf(exp));
		}

	}

	/* 将一个客户的DCN映射关系从原DCN迁移至新DCN,客户信息不存在 */
	@Test
	public void changeDCN_2() {
		try {
			ParentTest.client.createDCNByADCN(dcn);
			ParentTest.client.changeDCN(ClientDRSConstant.CUSTOMER_ECIF, id1,
					dcn);
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String msg = sw.toString();
			String exp = "[" + id1 + "]客户信息不存在，不能修改";
			Assert.assertNotEquals(-1, msg.indexOf(exp));
			ParentTest.client.deleteDCN(dcn);
		}

	}

	/* 批量将一组客户的DCN映射关系从原DCN迁移至新DCN */
	@Test
	public void batchChangeDCN() {
		Map<String, String> result1 = ParentTest.client.batchChangeDCNByECIF(
				accounts1, newdcn);
		for (String s1 : accounts1) {
			Assert.assertEquals(result1.get(s1), "fail");
		}
	}
}
