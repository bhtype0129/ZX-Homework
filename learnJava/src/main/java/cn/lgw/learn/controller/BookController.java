package cn.lgw.learn.controller;

import cn.lgw.learn.domain.BookDO;
import cn.lgw.learn.service.BookService;
import cn.lgw.learn.service.impl.BookServiceImpl;
import cn.lgw.learn.to.resp.RestResponse;
import cn.lgw.learn.vo.GetAllBookReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by leiguowei on 2018/1/26
 */
@RestController
@Slf4j
public class BookController {
    public static int a = 0;
@RequestMapping
    public RestResponse showIndex() {
        a++;
        return RestResponse.ok(a + "");
    }

    @Resource
    private BookServiceImpl bookservice;

    @RequestMapping(value = "/book/get/all", method = RequestMethod.POST)
    public List<BookDO> getAllBooks(@RequestBody GetAllBookReq req) {
        log.info("req size={} pageCount={},", req.getPageSize(), req.getMaxPageCount());
        return bookservice.getAllBooks(req.getPageSize(), req.getMaxPageCount());
    }//显示所有书

    @RequestMapping(value = "/book/get/id", method = RequestMethod.POST)
    public BookDO getBooksBySelective(@RequestParam int id) {
        return bookservice.getBooksBySelective(id);
    }//按id查找

    @RequestMapping(value = "/book/get/name", method = RequestMethod.POST)
    public List<BookDO> getBookBySelective1(@RequestParam String name) {
        return bookservice.getBookBySelective1(name);
    }//按书名查询


    @RequestMapping(value = "/book/remove/id", method = RequestMethod.POST)
    public String removeBookBySelective(@RequestParam int id) {
        bookservice.removeBookBySelective(id);
        return "done";
    }//按id删除

    @RequestMapping(value = "/book/insert/all", method = RequestMethod.POST)
    public List<BookDO> insertBook(@RequestParam BookDO bookDO) {
        return bookservice.insertBook(bookDO);
    }//插入整本书

    @RequestMapping(value = "/book/update/id", method = RequestMethod.POST)
    public BookDO updateBookById(@RequestParam BookDO bookDO) {
        return bookservice.updateById(bookDO);
    }//按id更新,且全部更新

    @RequestMapping(value = "/book/update/id1", method = RequestMethod.POST)
    public BookDO updateByCondition(@RequestParam BookDO bookDO) {
        return bookservice.updateByCondition(bookDO);
    }//按id更新，且为部分更新


}