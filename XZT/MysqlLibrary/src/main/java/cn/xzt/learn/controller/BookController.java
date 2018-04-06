package cn.xzt.learn.controller;

import cn.xzt.learn.domain.BookDO;
import cn.xzt.learn.mapper.BookMapper;
import cn.xzt.learn.service.BookService;
import cn.xzt.learn.vo.GetAllBookReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import sun.rmi.log.LogInputStream;

import javax.annotation.Resource;
import java.util.List;

/**
 * --Create by xzt-- on 18-1-26
 */
@Slf4j
@RestController
public class BookController {

    @Resource
    private BookService bookService;

    @Resource
    private BookMapper bookMapper;


   @RequestMapping(value = "/book/get/all",method = RequestMethod.GET)
    public List<BookDO> getAllBooks(@RequestBody GetAllBookReq req) {
        log.info("req pageSize={},maxPageCount={}",req.getPageSize(),req.getMaxPageCount());
    return bookService.getAllBooks(req.getPageSize(),req.getMaxPageCount());
    }


    @RequestMapping(value = "/book/get/selectByPrimaryKey",method = RequestMethod.GET)
    public BookDO selectByPrimaryKey(@RequestParam int Id) {
        log.info("bookDO =Id{}",Id);
        return bookService.selectByPrimaryKey(Id);
    }


    @RequestMapping(value = "/book/post/insert",method = RequestMethod.POST)
    public int insert(@RequestBody BookDO bookDO) {
        log.info("bookDO Id={},name={},author={},classify={},intro={}",bookDO.getId(),bookDO.getName(),bookDO.getAuthor(),bookDO.getClassify(),bookDO.getIntro());
        return bookService.insert(bookDO);
    }

    @RequestMapping(value = "/book/get/delete",method = RequestMethod.GET)
    public void delete(@RequestParam int Id) {
       log.info("bookDO =Id{}",Id);
       bookService.deleteByPrimaryKey(Id);
    }

    @RequestMapping(value = "/book/post/update",method = RequestMethod.POST)
    public int updateByPrimaryKeySelective(@RequestBody BookDO bookDO) {
       log.info("bookDO Id={},name={},author={},classify={},intro={}",bookDO.getId(),bookDO.getName(),bookDO.getAuthor(),bookDO.getClassify(),bookDO.getIntro());
        return bookService.updateByPrimaryKey(bookDO);

   }

}
