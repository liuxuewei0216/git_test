package main.client;

import cn.sunline.edsp.component.base.common.URL;
import cn.sunline.edsp.component.base.utils.LogUtils;
import cn.sunline.edsp.component.rpc.common.config.DefaultMqConfig;
import cn.sunline.edsp.component.rpc.common.config.RegistryConfig;
import cn.sunline.edsp.component.rpc.config.ReferenceConfig;
import cn.sunline.edsp.component.rpc.invoker.AccessId;
import cn.sunline.edsp.component.rpc.invoker.RPCInvoker;

import com.hfbank.mq.support.config.DefaultJdbcConfig;

import org.slf4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Invoker Test
 * 
 * @author lry
 */
public class InvokerDemo_1 {
	private static final Logger busiLog = LogUtils.getBusiLogger();

	// 注册中心url
	// private static final String registryURL = "zookeeper://10.24.1.84:2181";
	private static final String registryURL = "zookeeper://10.18.50.24:2181";

	private static final String DATA = "requestData";

	public static void main(String[] args) {
		/** 事先初始化需要消费的服务的信息 **/
		List<ReferenceConfig> referenceConfigs = new ArrayList<>();

		String serviceId = "liuxuewei"; // 服务id


		String group = "CS"; // 服务分组

		String version = "1.0"; // 服务版本

		Map<String, String> params = new HashMap<String, String>();
		params.put("call_timeout", "10000"); // 服务参数
		params.put("loadbalance", "roundrobin");
		params.put("haStrategy", "failover");
		params.put("retry", "4");

		 referenceConfigs.add(new ReferenceConfig(serviceId, group, version,
		 params));
		/*** 初始化注册中心连接信息 */
		RegistryConfig registryConfig = new RegistryConfig(
				URL.valueOf(registryURL));

		/*** 初始化调用实例类 */
		RPCInvoker invoker = new RPCInvoker(registryConfig, referenceConfigs);
		try {
			for (int i = 0; i < 100; i++) {
				 AccessId accessId = new AccessId(serviceId, group, version);
				//提供需要调用的服务三要素

				Object responeData = null;
				try {
					responeData = invoker.invoker(accessId, DATA);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.err.println("响应报文为：" + responeData);
				Thread.sleep(1000);

			}

		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	/** mq协议的情况下会有部分需要初始化 **/
	private static void Mqprepare() {
		DefaultMqConfig.initConfig(getJdbcConfig());
	}

	private static DefaultJdbcConfig getJdbcConfig() {
		DefaultJdbcConfig config = new DefaultJdbcConfig();
		config.setInitialSize(30);
		config.setMaxActive(50);
		config.setMinIdle(5);
		config.setJdbcDriver("com.mysql.jdbc.Driver");
		config.setJdbcPassword("123456");
		config.setJdbcUsername("root");
		config.setJdbcUrl("jdbc:mysql://10.24.1.83:3306/mq?useUnicode=true&characterEncoding=UTF-8&relaxAutoCommit=true&zeroDateTimeBehavior=convertToNull&&allowMultiQueries=true");
		config.setLockJdbcUrl("jdbc:mysql://10.24.1.83:3306/lock_CDieZvb76fGKlW3a?useUnicode=true&characterEncoding=UTF-8&relaxAutoCommit=true&zeroDateTimeBehavior=convertToNull&&allowMultiQueries=true");

		return config;
	}

}
