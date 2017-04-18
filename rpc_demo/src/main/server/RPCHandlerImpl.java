package main.server;

import cn.sunline.edsp.component.base.utils.LogUtils;
import cn.sunline.edsp.component.rpc.common.RPCContext;
import cn.sunline.edsp.component.rpc.server.RPCHandler;

import org.slf4j.Logger;

public class RPCHandlerImpl implements RPCHandler {
	private static final Logger busiLog = LogUtils.getBusiLogger();

	@Override
	public Object handle(Object request) {
		busiLog.debug("header="
				+ RPCContext.getContext().getRequest().getHeader() + "\n"
				+ "request=" + request);
		// try {
		// Thread.sleep(15000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		System.err.println("请求：" + request);
		// throw new NullPointerException();
		return request.toString().toUpperCase() + 8081;
	}

}
