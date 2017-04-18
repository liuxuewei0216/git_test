package main.server;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import cn.sunline.edsp.component.base.common.URL;
import cn.sunline.edsp.component.base.core.ExtensionLoader;
import cn.sunline.edsp.component.registry.Registry;
import cn.sunline.edsp.component.registry.RegistryFactory;
import cn.sunline.edsp.component.rpc.common.config.RegistryConfig;
import cn.sunline.edsp.component.rpc.common.constants.RPCParamType;

public class RegistryMessage {
	private static final String registryURL = "zookeeper://10.18.50.29:2181";

	public static void main(String[] args) {
		RegistryConfig registryConfig = new RegistryConfig(URL.valueOf(registryURL));
		RegistryFactory factory = ExtensionLoader.getExtensionLoader(RegistryFactory.class)
				.getExtension(registryConfig.getProtocol());
		Registry registry = factory.getRegistry(registryConfig.getUrl());
		Map<String, String> parameters = new HashMap<>();
		parameters.put(RPCParamType.haStrategy.name(), "failover");
		parameters.put(RPCParamType.loadbalance.name(), "leastactive");
		parameters.put("retry", "3");
		parameters.put(RPCParamType.configurator_category.getName(), RPCParamType.configurator_category.getValue());
		parameters.put("group","CS");
		parameters.put("version","1.0");
		URL url = new URL(RPCParamType.configurator_category.getValue(), "0.0.0.0", 0, "liuxuewei", parameters);
		registry.register(url);
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
