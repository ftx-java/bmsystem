package com.tx.springboot.bmsystem.service;

import com.tx.springboot.bmsystem.pojo.User;
import com.tx.springboot.bmsystem.utils.page.Page;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 图书管理系统 用户  service层
 *
 * @author tx
 * @date 2019/03/26
 */
public interface IUserService {

    /**
     * 验证用户是否存在
     *
     * @param userName
     * @return
     */
    User findUserByUserName(String userName);

    /**
     * 查找所有用户
     *
     * @return
     */
    List<User> selectAllUser();

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    boolean insertUser(User user);

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    boolean updateUser(User user);
}
