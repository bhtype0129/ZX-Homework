package cn.hyy.learn;

import cn.hyy.learn.domain.BookDO;
import cn.hyy.learn.domain.condition.BookCondition;
import cn.hyy.learn.mapper.BookMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class SpringTest {
    @Resource
    BookMapper bookMapper;

    public void insert(BookDO bookDO) {
        bookMapper.insert(bookDO);
    }

    public void insertSelective(BookDO bookDO) {
        bookMapper.insertSelective(bookDO);
    }


    public BookDO selectByPrimaryKey(long id) {
        return bookMapper.selectByPrimaryKey(id);
    }
    public List<BookDO> selectByExample(BookCondition example) {
        return bookMapper.selectByExample(example);
    }

    public void deleteByPrimaryKey(long id) {
        bookMapper.deleteByPrimaryKey(id);
    }

    public void  updateByPrimaryKey(BookDO bookDO) {
        bookMapper.updateByPrimaryKey(bookDO);

    }









    /* private  SpringTest2 springTest2;
    public void show() {
        springTest2.show();
    }*/
}
