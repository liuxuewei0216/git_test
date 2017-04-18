package main.server;

import cn.sunline.edsp.component.base.common.URL;
import cn.sunline.edsp.component.base.utils.LogUtils;
import cn.sunline.edsp.component.rpc.common.config.DefaultMqConfig;
import cn.sunline.edsp.component.rpc.common.config.ProtocolConfig;
import cn.sunline.edsp.component.rpc.common.config.RegistryConfig;
import cn.sunline.edsp.component.rpc.server.Exporter;
import cn.sunline.edsp.component.rpc.server.RPCHandler;
import cn.sunline.edsp.component.rpc.server.config.ServiceConfig;
import com.hfbank.mq.support.config.DefaultJdbcConfig;
import org.slf4j.Logger;

import java.io.IOException;
import java.util.*;

public class MqExporterDemo {

    static {

//        System.setProperty("log4j.configurationFile","log4jxx.xml");

    }
    private static final String protocolURL = "mq://10.22.90.121:8087?password=keifer&username=keifer";
    private static final List<ServiceConfig> serviceConfigs = new ArrayList<ServiceConfig>();
    private static final String registryURL = "zookeeper://10.18.50.29:2181";

    private static final String serviceId = "liuxuewei";
    private static final String group = "CS";
    private static final String version = "1.0";
    private static final Map<String, String> params = new HashMap<String, String>();
    private static final Logger logger = LogUtils.getBootLogger();

    public static void main(String[] args) throws Exception{
        DefaultMqConfig.initConfig(getJdbcConfig());


        URL url = URL.valueOf(protocolURL);
        final ProtocolConfig protocol = new ProtocolConfig(url);
        RegistryConfig registry = new RegistryConfig(URL.valueOf(registryURL));
        params.put("username", "keifer");
        params.put("password", "keifer");

        ServiceConfig serviceConfig1 = new ServiceConfig(serviceId, group, version, params);
        serviceConfigs.add(serviceConfig1);


        Exporter.export(protocol, registry, serviceConfigs, new RPCHandler() {
            public Object handle(Object request) {
                System.out.println("MQ数据消费");
                return request;
            }
        });
        // Wait until the server is stopped
        while (true) {
            try {
                System.out.println("输入stop 停止服务");
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


    private static DefaultJdbcConfig getJdbcConfig(){
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
