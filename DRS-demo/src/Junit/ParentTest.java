package Junit;

import java.util.HashMap;
import java.util.Map;

import cn.sunline.edsp.component.rpc.common.constants.RPCParamType;
import cn.sunline.edsp.microcore.Bootstrap;
import cn.sunline.edsp.midware.drs.api.server.DRSFactoryManager;
import cn.sunline.edsp.midware.drs.api.server.IDRSClient;
import cn.sunline.edsp.midware.drs.api.server.IDRSFactory;

public class ParentTest {
	private ParentTest() {
	}

	private static ParentTest intance = null;
	static IDRSFactory factory;
	static IDRSClient client;

	public static ParentTest getInstance() {
		if (intance == null) {
			intance = new ParentTest();
			// 初始化factory对象
			Bootstrap.start();
			IDRSFactory factory = DRSFactoryManager.getInstance().getFactory();
			Map<String, String> params = new HashMap<String, String>();
			params.put(RPCParamType.call_timeout.getName(), "10000");
			factory.init("zookeeper://10.24.1.84:2181", "drs", "CS", "1.0",
					params);
			client = factory.getDRSClient();
		}
		return intance;
	}
}