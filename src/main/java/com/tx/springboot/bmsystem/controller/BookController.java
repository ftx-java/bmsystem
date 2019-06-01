package com.tx.springboot.bmsystem.controller;

import com.tx.springboot.bmsystem.config.ServerResponse;
import com.tx.springboot.bmsystem.pojo.Book;
import com.tx.springboot.bmsystem.service.IBookService;
import com.tx.springboot.bmsystem.utils.page.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 图书管理系统  图书操作
 * controller层
 *
 * @author tx
 * @date 2019/03/31
 */
@RestController
@RequestMapping("/book")
public class BookController {
    @Resource
    private IBookService bookService;

    /**
     * 管理员录入新书
     * http://localhost:8082/book/addBook.do?bookName=天才&&bookAuthor=弟弟&&bookPublish=哈工大&&bookCategory=1&&bookNumber=2&&bookIntroduction=弟弟成长
     * 主键自增 不需要写bookId
     *
     * @param book
     * @return
     */
    @ApiOperation(value = "管理员添加书籍", notes = "管理员录入新书信息 主键自增不需要写bookId")
    @RequestMapping(value = "/addBook.do", method = RequestMethod.POST)
    public ServerResponse addBook(Book book) {
        if (book.getBookName() == null) {
            return ServerResponse.createErrorServerResonpnseWithData("书籍名称不可以为空");
        }
        boolean res = bookService.addBook(book);
        if (res) {
            return ServerResponse.createSuccessServerResonpnseWithData("书籍添加成功！");
        }
        return ServerResponse.createErrorServerResonpnseWithData("书籍添加失败！");
    }

    /**
     * 管理员/用户  返回目前现有的所有图书信息 分页查询
     * http://localhost:8082/book/selectAllBooks.do?pageNum=2
     *
     * @param
     * @return
     */
    @ApiOperation(value = "管理员/用户 分页查询所有书籍信息", notes = "输入pageNum查询对应页的书籍信息")
    @RequestMapping(value = "/selectAllBooks.do", method = RequestMethod.GET)
    public ServerResponse selectAllBooks(@RequestParam("pageNum") int pageNum) {
        Page<Book> res = bookService.selectAllByPage(pageNum);
        return ServerResponse.createSuccessServerResonpnseWithData(res);
    }

    /**
     * 管理员 通过bookId查书籍信息
     * http://localhost:8082/book/selectByBookId.do?bookId=2
     *
     * @param
     * @return
     */
    @ApiOperation(value = "管理员/用户 通过bookId查书籍信息", notes = "输入bookId查询对应的书籍信息")
    @RequestMapping(value = "/selectByBookId.do", method = RequestMethod.GET)
    public ServerResponse selectByBookId(@RequestParam("bookId") int bookId) {
        Book book = bookService.selectByBookId(bookId);
        if (book == null) {
            return ServerResponse.createErrorServerResonpnseWithData("书籍不存在！");
        } else {
            return ServerResponse.createSuccessServerResonpnseWithData(book);
        }
    }

    /**
     * 管理员通过bookId删除书籍信息
     * http://localhost:8082/book/deleteByBookId.do?bookId=43
     *
     * @param
     * @return
     */
    @ApiOperation(value = "管理员删除书籍信息", notes = "通过bookId删除书籍")
    @RequestMapping(value = "/deleteByBookId.do", method = RequestMethod.GET)
    public ServerResponse deleteByBookId(@RequestParam("bookId") int bookId) {
        boolean res = bookService.deleteByBookId(bookId);
        if (res) {
            return ServerResponse.createSuccessServerResonpnseWithData("删除书籍成功！");
        } else {
            return ServerResponse.createErrorServerResonpnseWithData("删除书籍失败！");
        }
    }

    /**
     * 管理员更改书籍信息
     *
     * @param
     * @return
     */

    @ApiOperation(value = "管理员更改书籍信息", notes = "管理员更改现有的书籍信息")
    @RequestMapping(value = "/updateBook.do", method = RequestMethod.GET)
    public ServerResponse updateBook(Book book) {
        boolean res = bookService.updateBook(book);
        if (res) {
            return ServerResponse.createSuccessServerResonpnseWithData("书籍更改成功！");
        }
        return ServerResponse.createErrorServerResonpnseWithData("书籍更改失败！");
    }

    /**
     * 用户按照书名关键字模糊查找符合条件的书籍信息
     * http://localhost:8082/book/findBookByKey.do?bookKey=人生
     *
     * @param bookKey
     * @return
     */
    @ApiOperation(value = "用户根据关键字模糊搜索书籍信息", notes = "返回所有书名包括该关键字的所有书籍信息")
    @RequestMapping(value = "/findBookByKey.do", method = RequestMethod.GET)
    public ServerResponse findBookByKey(@RequestParam("bookKey") String bookKey) {
        List<Book> books = bookService.findBookByKey(bookKey);
        if (books.size() == 0) {
            return ServerResponse.createErrorServerResonpnseWithData("无符合条件的书籍");
        } else {
            return ServerResponse.createSuccessServerResonpnseWithData(books);
        }
    }

    /**
     * 用户根据书籍类别返回该类别所有书籍信息
     * http://localhost:8082/book/findBookByCategoryId.do?bookCategoryId=3
     *
     * @param bookCategoryId
     * @return
     */
    @ApiOperation(value = "用户根据书籍类别返回该类别所有书籍信息", notes = "返回所有符合该书籍类别的书籍信息")
    @RequestMapping(value = "/findBookByCategoryId.do", method = RequestMethod.GET)
    public ServerResponse findBookByCategoryId(@RequestParam("bookCategoryId") int bookCategoryId) {
        List<Book> books = bookService.findBookByCategoryId(bookCategoryId);
        if (books.size() == 0) {
            return ServerResponse.createErrorServerResonpnseWithData("无符合条件的书籍");
        } else {
            return ServerResponse.createSuccessServerResonpnseWithData(books);
        }
    }

    /**
     * 用户借书
     * http://localhost:8082/book/borrowBooks.do?userName=天天&&bookId=1
     *
     * @param userName
     * @return
     */
    @ApiOperation(value = "用户借书", notes = "用户借书")
    @RequestMapping(value = "/borrowBooks.do", method = RequestMethod.GET)
    public ServerResponse borrowBooks(@RequestParam("userName") String userName, @RequestParam("bookId") int bookId) {
        boolean res = bookService.borrowBooks(userName, bookId);
        if (res == true) {
            return ServerResponse.createSuccessServerResonpnseWithData("借书成功！");
        } else {
            return ServerResponse.createErrorServerResonpnseWithData("借书失败！");
        }
    }

    /**
     * 用户还书
     * http://localhost:8082/book/returnBooks.do?borrowId=2
     *
     * @param borrowId
     * @return
     */
    @ApiOperation(value = "用户还书", notes = "用户还书")
    @RequestMapping(value = "/returnBooks.do", method = RequestMethod.GET)
    public ServerResponse returnBooks(@RequestParam("borrowId") int borrowId) {
        bookService.returnBooks(borrowId);
        return ServerResponse.createSuccessServerResonpnseWithData("还书成功！");
    }
}
