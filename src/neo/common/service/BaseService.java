package neo.common.service;

import javax.annotation.Resource;

import neo.core.common.CommonBaseService;

public class BaseService extends CommonBaseService {
	@Resource(name = "servMgr")
	private ServiceManager servMgr;

	public ServiceManager getServMgr() {
		return servMgr;
	}
}
