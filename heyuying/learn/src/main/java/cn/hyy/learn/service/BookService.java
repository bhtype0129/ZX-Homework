package cn.hyy.learn.service;

import cn.hyy.learn.domain.BookDO;
import cn.hyy.learn.domain.condition.BookCondition;
import cn.hyy.learn.mapper.BookMapper;
import cn.hyy.learn.vo.Req;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.locks.Condition;

/**
 * Created by heyuying on 18-1-26
 */

@Service
public class BookService {
    @Resource
    private BookMapper bookMapper;



    //查询全部书籍
    public List<BookDO> getAllBooks(int pageSize, int maxPageCount) {
        return bookMapper.selectByExample(new BookCondition());
    }

    //按书名查询书籍
    public List<BookDO> getSelectBooks(String name) {
        BookCondition example = new BookCondition();
        example.createCriteria().andNameEqualTo(name);
        return bookMapper.selectByExample(example);
    }

    //根据id查询书籍
    public BookDO selectByPrimaryKey(long id) {
        return bookMapper.selectByPrimaryKey(id);

    }

    //按id查询多本书籍
    public List<BookDO> getSelectBooksById(long id) {
        BookCondition example = new BookCondition();
        example.createCriteria().andIdGreaterThan(id);
        return bookMapper.selectByExample(example);
    }

    //整本书插入
    public int insert(Req req) {
        BookDO bookDO = new BookDO();
        bookDO.setName(req.getName());
        bookDO.setAuthor(req.getAuthor());
        bookDO.setCatalogue(req.getCatalogue());
        bookDO.setBrief(req.getBrief());
        return bookMapper.insert(bookDO);
    }

    //更新
    public int update(Req req) {
        BookDO bookDO = selectByPrimaryKey(req.getId());//先找到要更新的书籍
        if (req.getName() != null) {
            bookDO.setName(req.getName());
        }
        if (req.getAuthor() != null) {
            bookDO.setAuthor(req.getAuthor());
        }
        if (req.getCatalogue() != null) {
            bookDO.setCatalogue(req.getCatalogue());
        }
        if (req.getBrief()!=null) {
            bookDO.setBrief(req.getBrief());
        }
        return bookMapper.updateByPrimaryKey(bookDO);
    }




    //根据ID删除一本书
    public int deleteByPrimaryKey(long id) {
        return bookMapper.deleteByPrimaryKey(id);
    }



}
