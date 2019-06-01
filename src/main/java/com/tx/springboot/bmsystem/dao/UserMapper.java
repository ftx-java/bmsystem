package com.tx.springboot.bmsystem.dao;

import com.tx.springboot.bmsystem.pojo.User;
import com.tx.springboot.bmsystem.pojo.UserExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 图书管理系统 用户
 * dao层
 *
 * @author tx
 * @date 2019/03/26
 */
@Mapper
public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //分页查询
    List<User> selectByPageNum(@Param("currIndex") int currIndex, @Param("pageSize") int pageSize);

    //查询总数
    int selectUserCount();

    /**
     * 根据名字查找用户
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
    List<User> selectAll();
}