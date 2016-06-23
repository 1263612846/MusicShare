package neo.common.action;

import java.util.Map;

import javax.annotation.Resource;

import neo.common.service.ServiceManager;
import neo.core.Constants;
import neo.core.common.CommonBaseAction;

public class BaseAction extends CommonBaseAction {

	/* ServiceManager */
	@Resource(name = "servMgr")
	private ServiceManager servMgr;

	public ServiceManager getServMgr() {
		return servMgr;
	}

	/*
	 * public void setServMgr(ServiceManager servMgr) { this.servMgr = servMgr;
	 * }
	 */

	/* 获取登录用户ID */
	public Long getLoginUserId() {
		Map user = getLoginUser();
		if (user != null) {
			// return new Long(((BigDecimal) user.get("userid")).longValue());
			return new Long(((Integer) user.get("userid")).longValue());
		}
		return null;
	}

	/* 获取登录用户名 */
	public String getLoginUserName() {
		Map user = getLoginUser();
		if (user != null) {
			return (String) user.get("username");
		}
		return null;
	}

	/* 获取登录用户对象 */
	public Map getLoginUser() {
		return (Map) getSession().get(Constants.LOGIN_USER);
	}

}
