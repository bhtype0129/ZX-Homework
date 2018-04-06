package cn.cooper.uestc;


import cn.cooper.uestc.domain.BookDo;
import cn.cooper.uestc.domain.condition.BookCondition;
import cn.cooper.uestc.mapper.BookMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class SpringTest {
    @Resource
    BookMapper bookMapper;
 //mybatis框架中会有实现BookMapper接口的类，并且创建这个类的实例放进spring的仓库中，当出现resource这个标记的时候
 //会将上文出现的bookMapper对象引用指向这个实例，所以bookMapper就可以随意调用实现类里实现了接口的方法了。
    public void insert(BookDo bookDo) {
        bookMapper.insert(bookDo);
    }

    public void delete(BookCondition example) {
        bookMapper.deleteByExample(example);

    }



}
