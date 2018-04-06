package cn.xf.learn.srevice;

import cn.xf.learn.domin.BookDO;
import cn.xf.learn.domin.condition.BookCondition;
import cn.xf.learn.mapper.BookMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xufei on 18-1-26
 */
@Service
public class BookService {
    @Resource
    private BookMapper bookMapper;

    public List<BookDO> getAllBooks(int pageSize, int maxPageCount) {
        return bookMapper.selectByExample(new BookCondition());
    }
}
