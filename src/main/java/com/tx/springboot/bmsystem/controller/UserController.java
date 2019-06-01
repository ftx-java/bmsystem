package com.tx.springboot.bmsystem.controller;


import com.tx.springboot.bmsystem.config.ServerResponse;
import com.tx.springboot.bmsystem.pojo.User;
import com.tx.springboot.bmsystem.service.IUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 图书管理系统 用户
 *
 * @author tx
 * @date 2019/03/26
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private IUserService userService;

    /**
     * 验证用户是否存在
     * http://localhost:8082/user/isUserExist.do?userName=zhangfei&&password=123456
     *
     * @param userName
     * @return
     */
    @ApiOperation(value = "验证用户是否存在", notes = "根据用户名验证用户是否存在以及密码是否正确")
    @RequestMapping(value = "/isUserExist.do", method = RequestMethod.GET)
    public ServerResponse isUserExist(@RequestParam("userName") String userName,
                                      @RequestParam("password") String password) {
        User users = userService.findUserByUserName(userName);

        if (users == null) {
            return ServerResponse.createErrorServerResonpnseWithData("用户名不存在");
        } else if (users != null && !users.getUserPwd().equals(password)) {
            return ServerResponse.createErrorServerResonpnseWithData("密码错误");
        } else {
            return ServerResponse.createSuccessServerResonpnseWithData(users);
        }
    }

    /**
     * 管理员 查看目前现有的所有用户信息
     * http://localhost:8082/user/selectAllUsers.do
     *
     * @param
     * @return
     */
    @ApiOperation(value = "管理员 查看目前现有的所有用户信息", notes = "管理员 查看目前现有的所有用户信息")
    @RequestMapping(value = "/selectAllUsers.do", method = RequestMethod.GET)
    public ServerResponse selectAllUsers() {
        List<User> res = userService.selectAllUser();
        for (int i = 0; i < res.size(); i++) {
            res.get(i).setUserPwd("******");
        }
        return ServerResponse.createSuccessServerResonpnseWithData(res);
    }

    /**
     * 管理员添加用户
     * 主键自增 不需要写userId
     * http://localhost:8082/user/addUser.do?userName=小明&&userPwd=123456&&userEmail=abcd@.com
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "管理员添加用户", notes = "管理员录入用户信息 主键自增不需要写userId")
    @RequestMapping(value = "/addUser.do", method = RequestMethod.POST)
    public ServerResponse addUser(User user) {
        if (user.getUserName() == null) {
            return ServerResponse.createErrorServerResonpnseWithData("用户名不可以为空");
        }
        boolean res = userService.insertUser(user);
        if (res) {
            return ServerResponse.createSuccessServerResonpnseWithData("用户添加成功！");
        }
        return ServerResponse.createErrorServerResonpnseWithData("用户添加失败！");
    }

    /**
     * 用户修改个人信息
     * http://localhost:8082/user/updateUser.do?userId=1&&userName=天天&&userPwd=123&&userEmail=111
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "用户修改个人信息", notes = "通过返回的用户名修改个人信息")
    @RequestMapping(value = "/updateUser.do", method = RequestMethod.GET)
    public ServerResponse updateUser(User user) {
        boolean res = userService.updateUser(user);
        if (res == true) {
            return ServerResponse.createSuccessServerResonpnseWithData("修改成功");
        } else {
            return ServerResponse.createErrorServerResonpnseWithData("修改失败");
        }
    }
}
