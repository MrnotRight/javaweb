package blog.dao;

import blog.model.User;

public interface UserDao {


	/**
	 * 登录验证
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	User login(String username, String password);

}