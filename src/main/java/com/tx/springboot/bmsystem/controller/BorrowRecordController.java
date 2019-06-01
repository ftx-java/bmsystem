package com.tx.springboot.bmsystem.controller;

import com.tx.springboot.bmsystem.config.ServerResponse;
import com.tx.springboot.bmsystem.pojo.BorrowRecord;
import com.tx.springboot.bmsystem.service.IBorrowRecordService;
import com.tx.springboot.bmsystem.utils.page.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 图书管理系统  借书记录
 * controller层
 *
 * @author tx
 * @date 2019/03/31
 */
@RestController
@RequestMapping("/borrowRecord")
public class BorrowRecordController {

    @Resource
    private IBorrowRecordService borrowingBooksRecordService;

    /**
     * 用户查自己借书记录
     * http://localhost:8082/borrowRecord/selectRecord.do?userName=天天
     *
     * @param userName
     * @return
     */
    @ApiOperation(value = "用户查自己借书记录", notes = "返回用户自己借书记录")
    @RequestMapping(value = "/selectRecord.do", method = RequestMethod.GET)
    public ServerResponse selectRecord(@RequestParam("userName") String userName) {
        List<BorrowRecord> res = borrowingBooksRecordService.selectRecord(userName);
        return ServerResponse.createSuccessServerResonpnseWithData(res);
    }

    /**
     * 管理员 分页查询目前所有借书记录
     * http://localhost:8082/borrowRecord/selectAllUsers.do?pageNum=1
     *
     * @param
     * @return
     */
    @ApiOperation(value = "管理员 查看目前现有的所有借书记录", notes = "管理员 查看目前现有的所有借书记录")
    @RequestMapping(value = "/selectAllUsers.do", method = RequestMethod.GET)
    public ServerResponse selectAllUsers(@RequestParam("pageNum") int pageNum) {
        Page<BorrowRecord> res = borrowingBooksRecordService.selectAllByPage(pageNum);
        return ServerResponse.createSuccessServerResonpnseWithData(res);
    }
}
