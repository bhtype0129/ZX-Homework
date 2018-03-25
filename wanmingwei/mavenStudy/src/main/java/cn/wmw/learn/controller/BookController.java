package cn.wmw.learn.controller;

import cn.wmw.learn.domain.BookDO;
import cn.wmw.learn.service.BookService;
import cn.wmw.learn.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by mingwei on 18-1-26
 */
@RestController
@Slf4j
public class BookController {
    @Resource
    private BookService bookService;
    @RequestMapping(value = "/book/get/all",method = RequestMethod.POST)
//    @RequestBody 表示从前端Body读取数据进来
    public List<BookDO> getAllBooks(@RequestBody GetAllBookReq req) {
        log.info(req.toString());
        //此return即返回给前端，即把这个List<BookDO>交给前端
        return bookService.getAllBooks();
    }
//    按书籍编号查找
    @RequestMapping(value = "/get/book/wanted",method = RequestMethod.POST)
    public BookDO getWantedNumberBooks(GetWantedReq req) {
        return bookService.getWantedBooks(req.getNumber());
    }
//    按书籍名称查找
    @RequestMapping(value = "/get/book/wanted/name",method = RequestMethod.POST)
    public List<BookDO> getWantedNameBooks(GetWantedReq req) {
        return bookService.getWantedBooks(req.getName());
    }
//    插入一本书籍
    @RequestMapping(value = "/insect/book",method = RequestMethod.POST)
    public void insectBooks(@RequestBody GetInsectBookReq req) {
        log.info(req.toString());
        bookService.insectBooks(req);
    }
//    按书籍编号删除
    @RequestMapping(value = "/delete/book",method = RequestMethod.POST)
    public void delectBooks(@RequestBody GetDeleteBookReq req) {
        bookService.delectBooks(req.getNumber());
    }
//    按书籍名称删除
    @RequestMapping(value = "/delete/book/name",method = RequestMethod.POST)
    public void delectNameBooks(@RequestBody GetDeleteBookReq req) {
        bookService.deleteBooks(req.getName());
    }
//    按书籍编号更新
    @RequestMapping(value = "/update/book",method = RequestMethod.POST)
    public void updateBooks(@RequestBody GetUpdateBookReq req) {
        bookService.updateBooks(req);
    }
}
