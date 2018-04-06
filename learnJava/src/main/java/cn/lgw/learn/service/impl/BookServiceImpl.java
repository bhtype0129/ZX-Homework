package cn.lgw.learn.service.impl;

import cn.lgw.learn.domain.BookDO;
import cn.lgw.learn.domain.condition.BookCondition;
import cn.lgw.learn.mapper.BookMapper;
import cn.lgw.learn.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Override
    public List<BookDO> getAllBooks(int pageSize, int maxPageCount) {
        return null;
    }
    public BookDO getBooksBySelective(long id) {
        return BookMapper.selectByPrimaryKey(id);
    }//按id查询（显示）

    public List<BookDO> getBookBySelective1(String name) {
        BookCondition bookCondition = new BookCondition();
        bookCondition.createCriteria().andNameEqualTo(name);
        return BookMapper.selectByExample(bookCondition);
    }//按书名查询（查）

    public String removeBookBySelective(long id) {
        BookMapper.deleteByPrimaryKey(id);
        return "done";
    }//按id删除（删）

    public List<BookDO> insertBook(BookDO bookDO) {
        BookMapper.insert(bookDO);
        return BookMapper.selectByExample(new BookCondition());
    }//插入（增）

    public BookDO updateById (BookDO bookDO) {
        BookMapper.updateByPrimaryKey(bookDO);
        return BookMapper.selectByPrimaryKey(bookDO.getId());
    }//按id更新（改）

    public BookDO updateByCondition(BookDO bookDO) {
        BookMapper.updateByPrimaryKeySelective(bookDO);
        return BookMapper.selectByPrimaryKey(bookDO.getId());
    }//按id更新，且为部分更新（改）


}
