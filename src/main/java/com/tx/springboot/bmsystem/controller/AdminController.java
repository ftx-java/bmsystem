package com.tx.springboot.bmsystem.controller;

import com.tx.springboot.bmsystem.config.ServerResponse;
import com.tx.springboot.bmsystem.pojo.Admin;
import com.tx.springboot.bmsystem.service.IAdminService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 图书管理系统 管理者
 *
 * @author tx
 * @date 2019/03/25
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private IAdminService adminService;

    /**
     * 管理员的授权登录
     * http://localhost:8082/admin/isAdminExist.do?adminName=admin&&password=root
     *
     * @param adminName
     * @return
     */
    @ApiOperation(value = "验证管理员是否存在", notes = "根据管理员名验证管理员是否存在以及密码是否正确")
    @RequestMapping(value = "/isAdminExist.do", method = RequestMethod.GET)
    public ServerResponse isUserExist(@RequestParam("adminName") String adminName,
                                      @RequestParam("password") String password) {
        Admin admin = adminService.adminIsExist(adminName);
        if (admin == null) {
            return ServerResponse.createErrorServerResonpnseWithData("管理员名不存在");
        } else if (admin != null && !admin.getAdminPwd().equals(password)) {
            return ServerResponse.createErrorServerResonpnseWithData("密码错误");
        } else {
            return ServerResponse.createSuccessServerResonpnseWithData(admin);
        }
    }
}
