package cn.smbms.dao.user;

import cn.smbms.pojo.User;

import java.util.List;

public interface UserDao {
	/**
	 * 增加用户信息
	 * @param connection
	 * @param user
	 * @return
	 * @
	 */
	public int add(User user);

	/**
	 * 通过userCode获取User
	 * @param connection
	 * @param userCode
	 * @return
	 * @
	 */
	public User getLoginUser(String userCode);

	/**
	 * 通过条件查询-userList
	 * @param connection
	 * @param userName
	 * @param userRole
	 * @return
	 * @
	 */
	public List<User> getUserList(String userName, int userRole, int currentPageNo, int pageSize);
	/**
	 * 通过条件查询-用户表记录数
	 * @param connection
	 * @param userName
	 * @param userRole
	 * @return
	 * @
	 */
	public long getUserCount(String userName, int userRole);

	/**
	 * 通过userId删除user
	 * @param delId
	 * @return
	 * @
	 */
	public int deleteUserById(Integer delId);


	/**
	 * 通过userId获取user
	 * @param connection
	 * @param id
	 * @return
	 * @
	 */
	public User getUserById(String id);

	/**
	 * 修改用户信息
	 * @param connection
	 * @param user
	 * @return
	 * @
	 */
	public int modify(User user);


	/**
	 * 修改当前用户密码
	 * @param connection
	 * @param id
	 * @param pwd
	 * @return
	 * @
	 */
	public int updatePwd(User user);
	
	
}
