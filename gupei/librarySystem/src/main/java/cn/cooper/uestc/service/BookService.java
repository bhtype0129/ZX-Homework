package cn.cooper.uestc.service;


import cn.cooper.uestc.domain.BookDo;
import cn.cooper.uestc.domain.condition.BookCondition;
import cn.cooper.uestc.mapper.BookMapper;
import cn.cooper.uestc.vo.GetAllBookReq;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.awt.print.Book;
import java.util.List;

/**
 * By GuPei 18-1-26
 */
@Service//spring框架扫描到service和component注解表示创建这个类的实例放到spring框架仓库中。
//和component起的效果差不多，建议使用service。，
public class BookService {
    @Resource//表示从仓库中取出已经存在的bookMapper对象，然后进行调用方法。
    private BookMapper bookMapper;

    public List<BookDo> getAllBooks() {
        //selectByExample是查询方法,查询方法里面的参数是满足条件的BookCondition对象
        //一般都对BookConditiond对象进行了条件设置用BookCondition（）.createCriteria()对象拥有的方法进行，此处没有设置对象条件。
        //那么BookMapper中定义的方法是对数据库进行操作，如查询。Book Condition作为参数传入方法，那么整体达到的效果
        //就实现了一个正常的sql语句实现了操作，如select * from students where sex="女" select是bookMapper中的方法，
        // where后面的语句由 BookConition对象代替。那么通过BookCondintion对象剖析出where后面的name="cooper"
        //是框架帮我们做好的事情，对于我们是透明的。
        return bookMapper.selectByExample(new BookCondition());
        //此处的new BookCondition（)表示不设立条件，即所有书都会被选中显示出来
        //selectByExample是BookMapper接口下的方法，具体方法内容是在mapper包下的BookMapper.xml文件里面，这文件里面用的是
        //mysql语句写入的各种方法体和BookMapper接口方法一一对应，
        // 然后mybatis框架(这是maven仓库拉下来的框架位于External Libraries)里面写入的类文件帮助在运行时候(动态生成)BookMapper的实现类
        //放入spring仓库提供给我们使用。我们只需要打上Resource注解从仓库里面拿出这个对象然后调用BookMapper.xml里面的方法即可。

    }

    public void insert(BookDo bookDo) {
        bookMapper.insert(bookDo);
    }//此方法是插入一本书

    public BookDo deleteBooks(Long id) {//此方法是删除一本书的方法,通过ID删除
        BookDo bookDo = bookMapper.selectByPrimaryKey(id);
        bookMapper.deleteByPrimaryKey(id);
        return bookDo;
    }

    public List<BookDo> deleteBooks(BookCondition bookCondition) {//此方法是删除一本书，通过name进行删除
        List<BookDo> bookDoList = bookMapper.selectByExample(bookCondition);
        bookMapper.deleteByExample(bookCondition);
        return bookDoList;//返回集合的原因是因为条件选出来的数据库中的书对象可能有很多
        //如条件 具有500页以上的书 那么返回的就是一个书对象的集合
    }

    public BookDo updateBook(GetAllBookReq req) {//更新一本书信息的方法
        BookDo bookDo = bookMapper.selectByPrimaryKey(req.getId());
        if (req.getAuthor() != null) {
            bookDo.setAuthor(req.getAuthor());
        }
        //json中没写的属性，表示该属性传入null。set方法和get方法中是可以传入null的，传入以后则其名字就是null
        //可以认为null是特殊的。null可以作为任何引用类型的参数传入，传入后则表示对象引用没有对象和其关联。
        if (req.getName() != null) {
            bookDo.setName(req.getName());
        }

        if (req.getCatalogue() != null) {
            bookDo.setCatalogue(req.getCatalogue());

        }
        if (req.getIntro() != null) {
            bookDo.setIntro(req.getIntro());
        }
        bookMapper.updateByPrimaryKey(bookDo);
        return bookDo;
    }
    public BookDo selectBook(Long id) {//此方法是选书的方法，用id来进行选择
         return bookMapper.selectByPrimaryKey(id);

    }
    public List<BookDo> selectBook(String name) {//此方法是通过name来查看书信息的方法
        BookCondition bookCondition = new BookCondition();
        bookCondition.createCriteria().andNameEqualTo(name);
        return bookMapper.selectByExample(bookCondition);
    }

}