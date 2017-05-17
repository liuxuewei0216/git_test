package Junit;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.Assert;
import org.junit.Test;

import cn.sunline.edsp.midware.drs.api.impl.common.ClientDRSConstant;
import cn.sunline.edsp.midware.drs.common.model.DCN;

/* 管理DCN的相关异常测试用例   */

public class Manage_Excep {
	String dcn1 = "dcn1";
	String dcn2 = "dcn2";

	static {
		ParentTest.getInstance();
	}

	/* 删除不存在的dcn */
	@Test
	public void del() {
		try {
			ParentTest.client.deleteDCN(dcn1);
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String msg = sw.toString();
			String exp = "您指定的DCN[" + dcn1 + "]不存在";
			Assert.assertNotEquals(-1, msg.indexOf(exp));
		}

	}

	/* 新增一个已经存在的DCN */
	@Test
	public void create_1() {
		try {
			ParentTest.client.createDCN(ClientDRSConstant.DCN_A, dcn1);
			ParentTest.client.createDCN(ClientDRSConstant.DCN_A, dcn1);
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String msg = sw.toString();
			String exp = "您指定的DCN[" + dcn1 + "]已存在";
			Assert.assertNotEquals(-1, msg.indexOf(exp));
			ParentTest.client.deleteDCN(dcn1);
		}
	}

	/* 新增DCN的参数为空 */
	@Test
	public void create_2() {
		try {
			ParentTest.client.createDCN(ClientDRSConstant.DCN_A, "");
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String msg = sw.toString();
			String exp = "createDCN方法参数不能为空！";
			Assert.assertNotEquals(-1, msg.indexOf(exp));
		}
	}

	/* 被修改的DCN号不存在 */
	@Test
	public void up_1() {
		try {
			ParentTest.client.updateDCN(dcn1, dcn2);
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String msg = sw.toString();
			String exp = "您指定的DCN[" + dcn1 + "]不存在，不能修改";
			Assert.assertNotEquals(-1, msg.indexOf(exp));
		}
	}

	/* 修改之后的DCN号已经存在 */
	@Test
	public void up_2() {
		try {
			ParentTest.client.createDCN(ClientDRSConstant.DCN_A, dcn1);
			ParentTest.client.createDCN(ClientDRSConstant.DCN_A, dcn2);
			ParentTest.client.updateDCN(dcn1, dcn2);
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String msg = sw.toString();
			String exp = "您指定的DCN[" + dcn2 + "]已存在，不能修改";
			Assert.assertNotEquals(-1, msg.indexOf(exp));
			ParentTest.client.deleteDCN(dcn1);
			ParentTest.client.deleteDCN(dcn2);
		}
	}

	/* 更改不存在的dcn状态 */
	@Test
	public void chStatus() {
		try {
			ParentTest.client.changeStatus(dcn1, "unavailable");
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String msg = sw.toString();
			String exp = "dcnID[" + dcn1 + "] not exist!";
			Assert.assertNotEquals(-1, msg.indexOf(exp));
		}
	}

	/* 数据库中没有任何DCN数据时，分配DCN */
	@Test
	public void allocDCN() {
		try {
			DCN dcns = ParentTest.client
					.allocDCNByType(ClientDRSConstant.DCN_A);
			if (dcns != null) {
				System.out.println(dcns.getDcnID());
				System.out.println(dcns.toString());
				System.out.println(dcns);
			}
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String msg = sw.toString();
			String exp = "mysql数据库中不存在任何dcn节点，请检查";
			Assert.assertNotEquals(-1, msg.indexOf(exp));
		}
	}
}
