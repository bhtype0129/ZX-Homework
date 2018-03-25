package cn.wmw.learn;

import cn.wmw.learn.domain.BookDO;
import cn.wmw.learn.domain.condition.BookCondition;
import cn.wmw.learn.mapper.BookMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

//Component注解，作用是创建实例放到容器里面，注解类,默认这个实例的名字是springTest
@Component
public class SpringTest {
//    Resource注解，注解类中的属性  所以要在BookMapper前加注解Resource
    @Resource
    BookMapper bookMapper;
    public void insert(BookDO bookDO) {
        bookMapper.insert(bookDO);
    }
    public BookDO get(Integer number) {
        return bookMapper.selectByPrimaryKey(number);
    }
    public void  delete(Integer number) {
        bookMapper.deleteByPrimaryKey(number);
    }
    public int update(BookDO bookDO) {
        return bookMapper.updateByPrimaryKey(bookDO);
    }
    public List<BookDO> getByCondition(BookCondition bookCondition) {
        return bookMapper.selectByExample(bookCondition);
    }
}
