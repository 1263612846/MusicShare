package neo.common.service;

import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import neo.core.util.MapUtil;
@Service(value="userService")
public class UserService extends BaseService {

	// 通过登录名获取用户
	private static final String SQL_GET_USER_BY_NAME = "select * from users where username = ?";

	/**
	 * 通过登录名获取用户
	 */
	public Map getUserByName(String username) {
		try {
			return jt.queryForMap(SQL_GET_USER_BY_NAME,
					new Object[] { username });
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	/**
	 * 将用户注册信息添加到task_users表
	 */
	public void insertUser(Map parameters) {
		// TODO Auto-generated method stub
		
		String sql="insert into users values(users.nextval,?,?)";
		jt.update(sql, MapUtil.getObjectArrayFromMap(parameters, "username,password"));
		
		//jt.update(sql,new Object[]{new HashMap(),"a"});
		
	}

	public boolean changePassword(Long userid, String newPass) {
		// TODO Auto-generated method stub
		String sql="update users set password=? where userid=?";
		int i=jt.update(sql,new Object[]{newPass,userid});
		if(i==1)
			return true;
		else
			return false;
	}

}
