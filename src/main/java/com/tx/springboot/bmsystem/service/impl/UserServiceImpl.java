package com.tx.springboot.bmsystem.service.impl;

import com.tx.springboot.bmsystem.dao.BookMapper;
import com.tx.springboot.bmsystem.dao.UserMapper;
import com.tx.springboot.bmsystem.pojo.*;
import com.tx.springboot.bmsystem.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 图书管理系统 用户
 * service层
 *
 * @author tx
 * @date 2019/03/26
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private BookMapper bookMapper;

    @Override
    public User findUserByUserName(String userName) {
        return userMapper.findUserByUserName(userName);
    }

    @Override
    public List<User> selectAllUser() {
        return userMapper.selectAll();
    }

    @Override
    public boolean insertUser(User user) {
        int n = userMapper.insert(user);
        if (n > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateUser(User user) {
        //获取session对象中user对象
        user.setUserId(user.getUserId());
        int n = userMapper.updateByPrimaryKey(user);
        if (n > 0) {
            return true;
        }
        return false;
    }
}
