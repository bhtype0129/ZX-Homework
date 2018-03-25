package cn.hyy.learn.controller;

import cn.hyy.learn.domain.BookDO;
import cn.hyy.learn.service.BookService;
import cn.hyy.learn.vo.Req;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by heyuying on 18-1-26
 */

@RestController
@Slf4j
public class BookController {
    @Resource
    private BookService bookService;

    //查询所有书籍
    @RequestMapping(value = "/book/get/all", method = RequestMethod.POST)
    public List<BookDO> getAllBooks(@RequestBody Req req) {
        log.info(req.toString());
        //return到书的列表，传给spring,经过json处理交给tomcat，tomcat再交给前端
        return bookService.getAllBooks(req.getPageSize(), req.getMaxPageCount());

    }
    //按书名查询
    @RequestMapping(value = "/book/get/selectWantedByName", method = RequestMethod.POST)
    public List<BookDO> getSelectBooks(@RequestBody Req req) {
        log.info("查找成功");
        return bookService.getSelectBooks(req.getName());

    }
    //根据ID查询
    @RequestMapping(value = "/book/get/selectByPrimaryKey", method = RequestMethod.POST)
    public BookDO getSelectByPrimaryKey(@RequestBody Req req) {
        log.info("查找成功");
        return bookService.selectByPrimaryKey(req.getId());
    }

    //根据ID条件查询
    @RequestMapping(value = "/book/get/selectWantedById", method = RequestMethod.POST)
    public List<BookDO> getSelectBooksById(@RequestBody Req req) {
        log.info("查找成功");
        return bookService.getSelectBooksById(req.getId());
    }

    //插入一本书
    @RequestMapping(value = "/book/insert", method = RequestMethod.POST)
    public BookDO insert(@RequestBody Req req) {
        log.info("插入成功");
        return bookService.selectByPrimaryKey(bookService.insert(req));

    }

    //更新
    @RequestMapping(value = "/book/update",method = RequestMethod.POST)
    public BookDO update(@RequestBody Req req) {
        log.info("更新成功");
        return bookService.selectByPrimaryKey(bookService.update(req));
    }

    //根据id删除整本书籍
    @RequestMapping(value = "/book/delete",method = RequestMethod.POST)
    public int deleteByPrimaryKey(@RequestBody Req req) {
        return bookService.deleteByPrimaryKey(req.getId());
    }
}
