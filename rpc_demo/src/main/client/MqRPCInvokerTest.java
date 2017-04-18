package main.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.server.RPCHandlerImpl;

import org.junit.Assert;
import org.junit.Test;

import cn.sunline.edsp.component.base.common.URL;
import cn.sunline.edsp.component.rpc.common.config.DefaultMqConfig;
import cn.sunline.edsp.component.rpc.common.config.ProtocolConfig;
import cn.sunline.edsp.component.rpc.common.config.RegistryConfig;
import cn.sunline.edsp.component.rpc.config.ReferenceConfig;
import cn.sunline.edsp.component.rpc.invoker.AccessId;
import cn.sunline.edsp.component.rpc.invoker.InvokerException;
import cn.sunline.edsp.component.rpc.invoker.RPCInvoker;
import cn.sunline.edsp.component.rpc.server.Exporter;
import cn.sunline.edsp.component.rpc.server.config.ServiceConfig;



import com.hfbank.mq.support.config.DefaultJdbcConfig;

public class MqRPCInvokerTest {

	private static String serviceId = "liuxuewei"; // 服务id

	private static String group = "CS"; // 服务分组

	private static String version = "1.0"; // 服务版本

	private static final String registryURL = "zookeeper://10.18.50.29:2181";
	private static final String protocolURL = "mq://10.24.1.66:61616?password=admin&username=admin";

	private static final Map<String, String> params = new HashMap<>();

	// private static final String protocolURL =
	// "tcp://0.0.0.0:10000?maxChannel=20000&minThread=20&maxThread=400&threadPool=fixed&rmFilters=AccessActiveLimitFilter";
	// private static final ProtocolConfig protocol = new
	// ProtocolConfig(URL.valueOf(protocolURL));
	private static final RegistryConfig registryConfig = new RegistryConfig(URL.valueOf(registryURL));

	public MqRPCInvokerTest() {
		DefaultMqConfig.initConfig(getJdbcConfig());
		params.put("username", "admin");
		params.put("password", "admin");
	}

	/**
	 * 测试构造器
	 */
	@Test
	public void RPCInvokerConstructorTest() {
		List<ReferenceConfig> referenceConfigs = new ArrayList<>();
		referenceConfigs.add(new ReferenceConfig(serviceId, group, version, params));
		RPCInvoker invoker = new RPCInvoker(registryConfig, referenceConfigs);
		Assert.assertNotNull(invoker);
	}

	/**
	 * serviceId,version,group都正确
	 * 
	 * @throws Throwable
	 */
	@Test
	public void invoker1Test() throws Throwable {
		String serviceId1 = serviceId;
		ProtocolConfig protocol = new ProtocolConfig(URL.valueOf(protocolURL));
		List<ServiceConfig> services = new ArrayList<ServiceConfig>();
		services.add(new ServiceConfig(serviceId1, group, version, params));
		Exporter.export(protocol, registryConfig, services, new RPCHandlerImpl());

		List<ReferenceConfig> referenceConfigs = new ArrayList<>();
		Map<String, String> params2 = new HashMap<String, String>();
		referenceConfigs.add(new ReferenceConfig(serviceId1, group, version, params2));
		RPCInvoker invoker = new RPCInvoker(registryConfig, referenceConfigs);
		AccessId accessId = new AccessId(serviceId1, group, version);
		Object result = invoker.invoker(accessId, "test1");

	}

	/**
	 * serviceId错误
	 * 
	 * @throws Throwable
	 */
	@Test(expected = InvokerException.class)
	public void invoker2Test() throws Throwable {
		String serviceId2 = serviceId + 21;
		ProtocolConfig protocol = new ProtocolConfig(URL.valueOf(protocolURL));
		List<ServiceConfig> services = new ArrayList<ServiceConfig>();
		services.add(new ServiceConfig(serviceId2, group, version, params));
		Exporter.export(protocol, registryConfig, services, new RPCHandlerImpl());

		List<ReferenceConfig> referenceConfigs = new ArrayList<>();
		Map<String, String> params2 = new HashMap<String, String>();
		referenceConfigs.add(new ReferenceConfig(serviceId2, group, version, params2));
		RPCInvoker invoker = new RPCInvoker(registryConfig, referenceConfigs);
		AccessId accessId = new AccessId("error", group, version);
		Object result = invoker.invoker(accessId, "test2");

	}

	/**
	 * group错误
	 * 
	 * @throws Throwable
	 */
	@Test(expected = InvokerException.class)
	public void invoker3Test() throws Throwable {
		String serviceId3 = serviceId + 31;
		ProtocolConfig protocol = new ProtocolConfig(URL.valueOf(protocolURL));
		List<ServiceConfig> services = new ArrayList<ServiceConfig>();
		services.add(new ServiceConfig(serviceId3, group, version, params));
		Exporter.export(protocol, registryConfig, services, new RPCHandlerImpl());

		List<ReferenceConfig> referenceConfigs = new ArrayList<>();
		Map<String, String> params2 = new HashMap<String, String>();
		referenceConfigs.add(new ReferenceConfig(serviceId3, group, version, params2));
		RPCInvoker invoker = new RPCInvoker(registryConfig, referenceConfigs);
		AccessId accessId = new AccessId(serviceId3, "error", version);
		Object result = invoker.invoker(accessId, "test3");

	}

	/**
	 * version错误
	 * 
	 * @throws Throwable
	 */
	@Test(expected = InvokerException.class)
	public void invoker4Test() throws Throwable {
		String serviceId4 = serviceId + 41;
		ProtocolConfig protocol = new ProtocolConfig(URL.valueOf(protocolURL));
		List<ServiceConfig> services = new ArrayList<ServiceConfig>();

		services.add(new ServiceConfig(serviceId4, group, version, params));
		Exporter.export(protocol, registryConfig, services, new RPCHandlerImpl());

		List<ReferenceConfig> referenceConfigs = new ArrayList<>();
		Map<String, String> params2 = new HashMap<String, String>();
		referenceConfigs.add(new ReferenceConfig(serviceId4, group, version, params2));
		RPCInvoker invoker = new RPCInvoker(registryConfig, referenceConfigs);
		AccessId accessId = new AccessId(serviceId4, group, "error");
		Object result = invoker.invoker(accessId, "test4");

	}

	/**
	 * group为*
	 * 
	 * @throws Throwable
	 */
	@Test
	public void invoker5Test() throws Throwable {
		String serviceId5 = serviceId + 51;
		ProtocolConfig protocol = new ProtocolConfig(URL.valueOf(protocolURL));
		List<ServiceConfig> services = new ArrayList<ServiceConfig>();

		services.add(new ServiceConfig(serviceId5, group, version, params));
		Exporter.export(protocol, registryConfig, services, new RPCHandlerImpl());

		List<ReferenceConfig> referenceConfigs = new ArrayList<>();
		Map<String, String> params2 = new HashMap<String, String>();
		referenceConfigs.add(new ReferenceConfig(serviceId5, group, version, params2));
		RPCInvoker invoker = new RPCInvoker(registryConfig, referenceConfigs);
		AccessId accessId = new AccessId(serviceId5, "*", version);
		Object result = invoker.invoker(accessId, "test5");

	}

	/**
	 * version为*
	 * 
	 * @throws Throwable
	 */
	@Test
	public void invoker6Test() throws Throwable {
		String serviceId6 = serviceId + 61;
		ProtocolConfig protocol = new ProtocolConfig(URL.valueOf(protocolURL));
		List<ServiceConfig> services = new ArrayList<ServiceConfig>();

		params.put("registry_timeout", "60000");
		services.add(new ServiceConfig(serviceId6, group, version, params));
		Exporter.export(protocol, registryConfig, services, new RPCHandlerImpl());

		List<ReferenceConfig> referenceConfigs = new ArrayList<>();
		Map<String, String> params2 = new HashMap<String, String>();
		params.put("call_timeout", "10000"); // 服务参数
		referenceConfigs.add(new ReferenceConfig(serviceId6, group, version, params2));
		RPCInvoker invoker = new RPCInvoker(registryConfig, referenceConfigs);
		AccessId accessId = new AccessId(serviceId6, group, "*");
		Object result = invoker.invoker(accessId, "test6");

	}

	/**
	 * version为*,group为*
	 * 
	 * @throws Throwable
	 */
	@Test
	public void invoker7Test() throws Throwable {
		String serviceId7 = serviceId + 71;
		ProtocolConfig protocol = new ProtocolConfig(URL.valueOf(protocolURL));
		List<ServiceConfig> services = new ArrayList<ServiceConfig>();

		services.add(new ServiceConfig(serviceId7, group, version, params));
		Exporter.export(protocol, registryConfig, services, new RPCHandlerImpl());

		List<ReferenceConfig> referenceConfigs = new ArrayList<>();
		Map<String, String> params2 = new HashMap<String, String>();
		params.put("call_timeout", "10000"); // 服务参数
		referenceConfigs.add(new ReferenceConfig(serviceId7, group, version, params2));
		RPCInvoker invoker = new RPCInvoker(registryConfig, referenceConfigs);
		AccessId accessId = new AccessId(serviceId7, "*", "*");
		Object result = invoker.invoker(accessId, "test7");

	}

	/**
	 * version为*,group为错误
	 * 
	 * @throws Throwable
	 */
	@Test(expected = InvokerException.class)
	public void invoker8Test() throws Throwable {
		String serviceId8 = serviceId + 81;
		ProtocolConfig protocol = new ProtocolConfig(URL.valueOf(protocolURL));
		List<ServiceConfig> services = new ArrayList<ServiceConfig>();

		services.add(new ServiceConfig(serviceId8, group, version, params));
		Exporter.export(protocol, registryConfig, services, new RPCHandlerImpl());

		List<ReferenceConfig> referenceConfigs = new ArrayList<>();
		Map<String, String> params2 = new HashMap<String, String>();
		referenceConfigs.add(new ReferenceConfig(serviceId8, group, version, params2));
		RPCInvoker invoker = new RPCInvoker(registryConfig, referenceConfigs);
		AccessId accessId = new AccessId(serviceId8, "error", "*");
		Object result = invoker.invoker(accessId, "test8");
	}

	/**
	 * version为*,group为错误
	 * 
	 * @throws Throwable
	 */
	// @Test(expected = InvokerException.class)
	// public void invoker9Test() throws Throwable {
	// String serviceId9 = serviceId + 9;
	// String protocolURL = "tcp://0.0.0.0:10009";
	// ProtocolConfig protocol = new ProtocolConfig(URL.valueOf(protocolURL));
	// List<ServiceConfig> services = new ArrayList<ServiceConfig>();
	//
	// services.add(new ServiceConfig(serviceId9, group, version, params));
	// Exporter.export(protocol, registryConfig, services, new
	// RPCHandlerImpl());
	//
	// List<ReferenceConfig> referenceConfigs = new ArrayList<>();
	// Map<String, String> params2 = new HashMap<String, String>();
	// referenceConfigs.add(new ReferenceConfig(serviceId9, group, version,
	// params2));
	// RPCInvoker invoker = new RPCInvoker(registryConfig, referenceConfigs);
	// AccessId accessId = new AccessId(serviceId9, group, "error");
	// Object result = invoker.invoker(accessId, "test");
	//
	//
	// }
	/**
	 * version为错误*,group为*
	 * 
	 * @throws Throwable
	 */
	@Test(expected = InvokerException.class)
	public void invoker10Test() throws Throwable {
		String serviceId10 = serviceId + 101;
		ProtocolConfig protocol = new ProtocolConfig(URL.valueOf(protocolURL));
		List<ServiceConfig> services = new ArrayList<ServiceConfig>();

		services.add(new ServiceConfig(serviceId10, group, version, params));
		Exporter.export(protocol, registryConfig, services, new RPCHandlerImpl());

		List<ReferenceConfig> referenceConfigs = new ArrayList<>();
		Map<String, String> params2 = new HashMap<String, String>();
		referenceConfigs.add(new ReferenceConfig(serviceId10, group, version, params2));
		RPCInvoker invoker = new RPCInvoker(registryConfig, referenceConfigs);
		AccessId accessId = new AccessId(serviceId10, "*", "error");
		Object result = invoker.invoker(accessId, "test9");

	}

	/**
	 * version为错误,group为错误
	 * 
	 * @throws Throwable
	 */
	@Test(expected = InvokerException.class)
	public void invoker11Test() throws Throwable {
		String serviceId11 = serviceId + 111;
		ProtocolConfig protocol = new ProtocolConfig(URL.valueOf(protocolURL));
		List<ServiceConfig> services = new ArrayList<ServiceConfig>();

		services.add(new ServiceConfig(serviceId11, group, version, params));
		Exporter.export(protocol, registryConfig, services, new RPCHandlerImpl());

		List<ReferenceConfig> referenceConfigs = new ArrayList<>();
		Map<String, String> params2 = new HashMap<String, String>();
		referenceConfigs.add(new ReferenceConfig(serviceId11, group, version, params2));
		RPCInvoker invoker = new RPCInvoker(registryConfig, referenceConfigs);
		AccessId accessId = new AccessId(serviceId11, "error", "error");
		Object result = invoker.invoker(accessId, "test11");

	}

	private static DefaultJdbcConfig getJdbcConfig() {
		DefaultJdbcConfig config = new DefaultJdbcConfig();
		config.setInitialSize(30);
		config.setMaxActive(50);
		config.setMinIdle(5);
		config.setJdbcDriver("com.mysql.jdbc.Driver");
		config.setJdbcPassword("123456");
		config.setJdbcUsername("root");
		config.setJdbcUrl(
				"jdbc:mysql://10.24.1.83:3306/mq?useUnicode=true&characterEncoding=UTF-8&relaxAutoCommit=true&zeroDateTimeBehavior=convertToNull&&allowMultiQueries=true");
		config.setLockJdbcUrl(
				"jdbc:mysql://10.24.1.83:3306/lock_CDieZvb76fGKlW3a?useUnicode=true&characterEncoding=UTF-8&relaxAutoCommit=true&zeroDateTimeBehavior=convertToNull&&allowMultiQueries=true");

		return config;
	}

}
