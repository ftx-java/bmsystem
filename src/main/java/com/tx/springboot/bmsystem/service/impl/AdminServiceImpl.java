package com.tx.springboot.bmsystem.service.impl;

import com.tx.springboot.bmsystem.dao.AdminMapper;
import com.tx.springboot.bmsystem.pojo.*;
import com.tx.springboot.bmsystem.service.IAdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 图书管理系统 管理者
 * service层
 *
 * @author tx
 * @date 2019/03/27
 */
@Service
public class AdminServiceImpl implements IAdminService {

    @Resource
    private AdminMapper adminMapper;

    @Override
    public Admin adminIsExist(String name) {
        return adminMapper.findAdminByAdminName(name);
    }

}
