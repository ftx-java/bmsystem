package com.tx.springboot.bmsystem.dao;

import com.tx.springboot.bmsystem.pojo.Admin;
import com.tx.springboot.bmsystem.pojo.AdminExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 图书管理系统 管理者
 * dao层
 *
 * @author tx
 * @date 2019/03/27
 */
@Mapper
public interface AdminMapper {
    long countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(Integer adminId);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(Integer adminId);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    /**
     * 根据名字查找用户
     *
     * @param name
     * @return
     */
    Admin findAdminByAdminName(String name);
}