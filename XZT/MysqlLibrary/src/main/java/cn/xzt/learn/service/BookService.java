package cn.xzt.learn.service;

import cn.xzt.learn.domain.BookDO;
import cn.xzt.learn.domain.condition.BookCondition;
import cn.xzt.learn.mapper.BookMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * --Create by xzt-- on 18-1-26
 */
@Service
public class BookService {
    @Resource
    private BookMapper bookMapper;
    //获取所有书籍信息
    public List<BookDO> getAllBooks(int PageSize,int maxPageCount) {
        return bookMapper.selectByExample(new BookCondition());
    }

    //按关键字查找书籍
    public BookDO selectByPrimaryKey(int i) {
        return bookMapper.selectByPrimaryKey(i);
    }

    //增加书籍
    public int insert(BookDO bookDO) {
        return bookMapper.insert(bookDO);
    }

    //删除书籍信息
    public void deleteByPrimaryKey(int i) {
        bookMapper.deleteByPrimaryKey(i);
    }

    //更新书籍信息
    public int updateByPrimaryKey(BookDO bookDO) {
        return bookMapper.updateByPrimaryKey(bookDO);
    }
}
