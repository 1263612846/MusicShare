package neo.core.common;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * Service 基类
 * 设置log及基本的数据库访问
 */
public class CommonBaseService {
	protected final Log log = LogFactory.getLog(getClass());

	/* JdbcTemplate */
	@Resource(name="jdbcTemplate")
	protected JdbcTemplate jt;

	/*public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jt = jdbcTemplate;
	}*/

	/* NamedParameterJdbcTemplate */
	@Resource(name="namedParameterJdbcTemplate")
	protected NamedParameterJdbcTemplate npjt;

	/*public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.npjt = namedParameterJdbcTemplate;
	}*/

	/* CallableStatementTemplate */
	@Resource(name="callableStatementTemplate")
	protected CallableStatementTemplate cst;

	/*public void setCallableStatementTemplate(CallableStatementTemplate callableStatementTemplate) {
		this.cst = callableStatementTemplate;
	}*/

	/* ValueStack */
	public ValueStack getValueStack() {
		return ActionContext.getContext().getValueStack();
	}

	/* PagingList */
	public PagingList getPagingList(String sql) {
		int pageNum = ((Integer) getValueStack().findValue("pageNum")).intValue();
		int pageSize = ((Integer) getValueStack().findValue("pageSize")).intValue();
		return new PagingList(sql, null, pageNum, pageSize, jt);
	}
	
	public PagingList getPagingList(String sql, Object[] params) {
		int pageNum = ((Integer) getValueStack().findValue("pageNum")).intValue();
		int pageSize = ((Integer) getValueStack().findValue("pageSize")).intValue();
		return new PagingList(sql, params, pageNum, pageSize, jt);
	}

	public PagingList getPagingList(String sql, Map namedParams) {
		int pageNum = ((Integer) getValueStack().findValue("pageNum")).intValue();
		int pageSize = ((Integer) getValueStack().findValue("pageSize")).intValue();
		return new PagingList(sql, namedParams, pageNum, pageSize, npjt);
	}
}