package cn.wmw.learn.service;

import cn.wmw.learn.domain.BookDO;
import cn.wmw.learn.domain.condition.BookCondition;
import cn.wmw.learn.mapper.BookMapper;
import cn.wmw.learn.vo.GetInsectBookReq;
import cn.wmw.learn.vo.GetUpdateBookReq;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by mingwei on 18-1-26
 */
@Service
public class BookService {
    @Resource
    private BookMapper bookMapper;

    public List<BookDO> getAllBooks() {
        BookCondition bookCondition = new BookCondition();
        return bookMapper.selectByExample(bookCondition);
    }
    //按书籍编号查询
    public BookDO getWantedBooks(int number) {
        return bookMapper.selectByPrimaryKey(number);
    }
    //按书名查询
    public List<BookDO> getWantedBooks(String name) {
        BookCondition bookCondition = new BookCondition();
        BookCondition.Criteria criteria = bookCondition.createCriteria();
        criteria.andNameEqualTo(name);
        return  bookMapper.selectByExample(bookCondition);
    }
    //插入
    public void insectBooks(GetInsectBookReq req) {
        BookDO bookDO = new BookDO();
        bookDO.setName(req.getName());
        bookDO.setAuthor(req.getAuthor());
        bookDO.setIntro(req.getIntro());
        bookDO.setCatalogue(req.getCatalogue());
        bookMapper.insert(bookDO);
    }
    //按照书籍编号删除
    public void  delectBooks(int number) {
        bookMapper.deleteByPrimaryKey(number);
    }
    //按照书籍名称删除
    public void  deleteBooks(String name) {
        BookCondition bookCondition = new BookCondition();
        BookCondition.Criteria criteria = bookCondition.createCriteria();
        criteria.andNameEqualTo(name);
        bookMapper.deleteByExample(bookCondition);
    }
    //按书籍编号更新
    public void  updateBooks(GetUpdateBookReq req) {
        BookDO bookDO = bookMapper.selectByPrimaryKey(req.getNumber());
        if(req.getName() != null) {
            bookDO.setName(req.getName());
        }
        if(req.getAuthor() != null) {
            bookDO.setAuthor(req.getAuthor());
        }
        if(req.getCatalogue() != null) {
            bookDO.setCatalogue(req.getCatalogue());
        }
        if(req.getIntro() != null) {
            bookDO.setIntro(req.getIntro());
        }
        bookMapper.updateByPrimaryKey(bookDO);
    }
}
