package neo.common.action;
 
import java.util.Map;

import neo.core.Constants;

public class UserAction extends BaseAction {
	String oldPass,newPass;
	
	public String getOldPass() {
		return oldPass;
	}

	public void setOldPass(String oldPass) {
		this.oldPass = oldPass;
	}

	public String getNewPass() {
		return newPass;
	}

	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}

	Map user;

	private String username;

	private String password;

	private String indexUrl;

	public String getIndexUrl() {
		return indexUrl;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 用户登录
	 */
	public String login() throws Exception {
		Map dbUser = getServMgr().getUserService().getUserByName(username);
		//System.out.println("------------------"+dbUser);
		if (dbUser != null && password.equals((String) dbUser.get("password"))) {
			indexUrl = (String) getSession().remove(Constants.ORIGINAL_URL);
			getSession().clear();// 清空原始Session信息
			getSession().put(Constants.LOGIN_USER, dbUser);
			if (indexUrl == null) {
				return "homepage";
			}
			return SUCCESS;
		}
		setResult(ERROR);
		addMessage("用户不存在或密码错误");
		addRedirURL("重新登录", "@back");
		return EXECUTE_RESULT;
	}
	
	/**
	 * 用户登出
	 */
	public String logout() throws Exception {
		getSession().clear();
		return SUCCESS;
	}
	
	/**
	 * 用户注册
	 */
	
	public String reg() throws Exception {
		getServMgr().getUserService().insertUser(this.getParameters());

		
		return EXECUTE_RESULT;
	}
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setIndexUrl(String indexUrl) {
		this.indexUrl = indexUrl;
	}

	public Map getUser() {
		return user;
	}

	public void setUser(Map user) {
		this.user = user;
	}

	public String password(){
		return "change";
	}
	
	public String editPassword(){
		user=this.getLoginUser();
		try{
		if (user != null && oldPass.equals((String) user.get("password"))) {
			this.getServMgr().getUserService().changePassword(this.getLoginUserId(),newPass);
			user.put("password", newPass);
			this.getSession().put(Constants.LOGIN_USER, user);
			this.addMessage("密码修改成功");
			this.addRedirURL("返回首页", this.getFullReferUrl());
			}
		else{
			this.addMessage("原密码不正确，请重新输入");
			this.addRedirURL("返回", "@back");
		}
		}
		catch(Exception e){
			e.printStackTrace();
			this.setResult(ERROR);
			this.addMessage("密码修改失败");
			this.addRedirURL("返回", "@back");
		}
		return EXECUTE_RESULT;
	}
	
}
