package neo.core.common;

import java.util.Date;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import neo.core.Constants;
import neo.core.util.QueryUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

/**
 * Action 基类
 */
public class CommonBaseAction implements Action {
	/* 日志 */
	protected final Log log = LogFactory.getLog(getClass());

	/* 默认返回SUCCESS */
	public String execute() throws Exception { return SUCCESS; }	
	
	/* 通用操作结果返回页 */
	public static final String EXECUTE_RESULT = Constants.EXECUTE_RESULT;
	private ExecuteResult executeResult;
	private ExecuteResult buildExecuteResult() {
		if (executeResult == null) {
			executeResult = new ExecuteResult();
			getSession().put(EXECUTE_RESULT, executeResult);
		}
		return executeResult;
	}
	public void setResult(String result) { buildExecuteResult().setResult(result); }
	public void addMessage(String message) { buildExecuteResult().addMessage(message);}
	public void addRedirURL(String desc, String url) { buildExecuteResult().addRedirURL(desc, url); }
	public ExecuteResult getExecuteResult() { return (ExecuteResult) getSession().get(EXECUTE_RESULT); }
	
	/* 获取基本环境 */
	public Map getParameters() { return ActionContext.getContext().getParameters(); } //封装为Map的request parameters
	public Map getSession() { return ActionContext.getContext().getSession(); } //封装为Map的session attributes
	public HttpServletRequest getRequest() { return ServletActionContext.getRequest(); } //原始的request
	public HttpServletResponse getResponse() { return ServletActionContext.getResponse(); } //原始的response
	public ServletContext getServletContext() { return ServletActionContext.getServletContext(); } //原始的ServletContext

	/* 分页信息 */
	protected int pageNum = 1;
	protected int pageSize = Constants.DEFAULT_PAGE_SIZE;
	public int getPageNum() { return pageNum; }
	public void setPageNum(int pageNum) { this.pageNum = pageNum; }
	public int getPageSize() { return pageSize; }
	public void setPageSize(int pageSize) { this.pageSize = pageSize; }	
    public String getQueryStringWithoutPageNum() {
		Map m = getParameters();
		m.remove("pageNum");
		return QueryUtil.getQueryString(m);
	}
    public String getFullUrlWithoutPageNum() {
		return getRequest().getServletPath() + "?"
				+ getQueryStringWithoutPageNum();
	}

    /* 记录当前页面作为返回地址 */
	public void setReferUrl() {
		String currUrl = QueryUtil.getRequestURL(getRequest());
		getSession().put(Constants.REFER_URL, currUrl);
	}
	public String getReferUrl() {
		return (String) getSession().get(Constants.REFER_URL);
	}
	
	public String getFullReferUrl() {
		return getRequest().getContextPath() + getReferUrl();
	}
	
	/* 工具类方法 */
	public Date getNow() {
		return new Date();
	}
	
}