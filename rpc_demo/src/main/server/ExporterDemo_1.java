package main.server;

import cn.sunline.edsp.component.base.common.URL;
import cn.sunline.edsp.component.base.utils.LogUtils;
import cn.sunline.edsp.component.rpc.common.config.ProtocolConfig;
import cn.sunline.edsp.component.rpc.common.config.RegistryConfig;
import cn.sunline.edsp.component.rpc.common.constants.RPCParamType;
import cn.sunline.edsp.component.rpc.server.Exporter;
import cn.sunline.edsp.component.rpc.server.config.ServiceConfig;

import org.slf4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExporterDemo_1 {
	private static final Logger busiLog = LogUtils.getBusiLogger();
	// 协议配置信息url
	private static final String protocolURL = "tcp://0.0.0.0:8081?maxChannel=200000&minThread=20&maxThread=400&threadPool=fixed&rmFilters=AccessActiveLimitFilter&serializer=json";
	// 注册中心配置信息url
	// private static final String registryURL = "zookeeper://10.24.1.84:2181";
	private static final String registryURL = "zookeeper://10.18.50.24:2181";

	public static void main(String[] args) {
		/** 协议配置 **/
		final ProtocolConfig protocol = new ProtocolConfig(
				URL.valueOf(protocolURL));
		/** 注册中心配置 **/
		RegistryConfig registry = new RegistryConfig(URL.valueOf(registryURL));
		/** 添加需要暴露的服务，以及服务相关的配置参数 **/
		List<ServiceConfig> services = new ArrayList<ServiceConfig>();

		String serviceId = "liuxuewei"; // 服务id

		String group = "CS"; // 服务分组

		String version = "1.0"; // 服务版本

		Map<String, String> params = new HashMap<>(); // 服务参数
		params.put("registry_timeout", "60000");
		params.put("serviceTest", "test");
		params.put("loadbalance", "roundrobin");
		params.put("haStrategy", "failover");
		params.put("retry", "5");
		params.put(RPCParamType.channelpool_min.getName(), "5");
		params.put(RPCParamType.channelpool_max.getName(), "10");
		params.put(RPCParamType.call_timeout.getName(), "10000");


		services.add(new ServiceConfig(serviceId, group, version, params));
		/** 服务暴露 **/
		Exporter.export(protocol, registry, services, new RPCHandlerImpl());

		/** 卡住主线程线程 **/
		while (true) {
			try {
				busiLog.info("输入stop 停止服务");
				byte[] in_bytes = new byte[10];
				System.in.read(in_bytes);
				String in = new String(in_bytes);
				if ("stop".equals(in.trim())) {
					Exporter.unexport();
					System.exit(0);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
