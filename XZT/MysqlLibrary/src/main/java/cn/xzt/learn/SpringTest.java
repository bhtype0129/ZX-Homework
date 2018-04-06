package cn.xzt.learn;

import cn.xzt.learn.domain.BookDO;
import cn.xzt.learn.mapper.BookMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * --Create by xzt-- on 18-1-25
 */
@Component
public class SpringTest {
    @Resource
    BookMapper bookMapper;

    public void insert(BookDO bookDO) {
        bookMapper.insert(bookDO);
    }
}
