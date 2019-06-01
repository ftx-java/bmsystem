package com.tx.springboot.bmsystem.service;

import com.tx.springboot.bmsystem.pojo.Admin;

/**
 * 图书管理系统 管理者
 * service层
 *
 * @author tx
 * @date 2019/03/27
 */
public interface IAdminService {

    /**
     * 验证管理员是否存在
     *
     * @param name
     * @return
     */
    public Admin adminIsExist(String name);

}
