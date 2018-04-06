package cn.cooper.uestc.controller;


import cn.cooper.uestc.domain.BookDo;
import cn.cooper.uestc.domain.condition.BookCondition;
import cn.cooper.uestc.service.BookService;
import cn.cooper.uestc.vo.GetAllBookReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * By GuPei 18-1-26
 */
@RestController
@Slf4j
//applicationContext.xml文件里面配置了让spring框架扫描整个uestc包下的文件，此处对类进行@RestController注解
//servlet会把前端过来的访问交给这个类来处理，所以输入相应的网址后如/book/get/all，便会相应的启动这个类里面相应的方法。
public class BookController {
    //有一点需要注意，框架代码是与我们一个已经在数据中建立好的表进行连接匹配，所以谁自增(即自动生成，在上一条记录后+1)
    //谁是primarykey在终端窗口创建数据库表的时候已经指定好了的，这里我们在终端窗口创建数据库表时以id为primarykey
    //并让其自增，那么通过id我们就能找到相应的对象的所有属性(这里数据库里面存的是书这个对象)。

    @Resource//Resource注解表示从框架仓库里面已经存在的实例拿出来直接调用方法。
    private BookService bookService;


    //此处的RequestMapping括号中的value表示url除开主页地址后剩余的地址值，如地址http://localhost:8081/book/get/all中除开8081前面
    //的部分，表示输入这个地址就和当前这个注解标记的方法即getAllbooks产生映射。后面的get方法表示是获取还可以有其他的方法。

    @RequestMapping(value = "/book/get/all", method = RequestMethod.POST)
    //RequestBody为http请求部分的数据部分
    public List<BookDo> getAllbooks() {//此方法是获取到所有的书籍
        //log.info("req size={} pageCount={} ", req.getPageSize(), req.getMaxPageCount());
        return bookService.getAllBooks();
    }

    @RequestMapping(value = "/book/add", method = RequestMethod.POST)
    //标注@requestBody，tomacat会将传送来的Body的数据部分整合为相应的类及这个类的对象此处为BookDo类
    //注解@DATA会对传来的对象调用set方法，使得属性具有相应的值，并且为这个对象重写好了toString方法，
    //重写好toString方法以后，直接返回对象就能以json的形式直接展现在网页上，还有list集合这里指list<BookDo>直接以json格式
    //显示在网页上，这样我们就能返回这个对象直接显示了，而无需先创建BookDo的类的对象

    public BookDo addBook(@RequestBody BookDo bookDo) {//此方法是像书籍列表中添加一本书
        bookService.insert(bookDo);
        return bookDo;
    }
    //这里解释一下注解的作用RequestMethod.POST方法表示即将会从前端传来一个带有@DATA注解的一个类的对象，而这个对象可能是
    //我们要放入数据库的对象(如上面的BookDo对象)，也可能是我们后台要操纵的对象(如GetAllBooksReq对象)。
    // @RequestBody 注解表示前端传来的body部分的对象，所以我们的后台代码
    // 需要有@RequestBody 这个类并且声明相应的属性，保持和前端的一致，最后打上@DATA注解，这样对象传来的时候就可以对对象直接使用
    //set 方法和get方法以及toString方法，最后我们就能直接返回这个对象进行显示(显示的形式是这个对象调用tostring()方法的形式)
    //或者对这个对象以及这个对象的属性进行操作。上面这个addBook方法便是这种形式

    //现在解释一下RequestMethod.GET方法，POST 方法多用于我们向数据库里面加入东西推东西。Get方法多用于我们获取到一个东西，或者说
    //获取到一个页面，所以在Get方法中前端是不能对body部分进行操作的(因为body部分是我们要推送的东西)自然也不能用@RequestBody在后台注解了
    // 而只有head头部参数(这里装的是公共参数,如cookies，application等),所以我们这种情况下如果要传一个不是公共参数的参数如id，那就
    //使用@RequestParam这个注解，然后在前端使用参数选项将参数加到url里面，
    // 如这种形式:  http://localhost:8081/deletebooks?id=3(问号表示匹配)，下面这个方法便是这种思路

    @RequestMapping(value = "/deletebooks",method = RequestMethod.GET)
    public BookDo deleteBooks( @RequestParam long id ) {//此方法是删除一本书的方法,通过ID删除
       return bookService.deleteBooks(id);




    }
    //最后注意一点postman的参数的 key value形式，字符串类型不需要打双引号，而body中需要采用json形式，即按照json格式
    @RequestMapping(value = "/deletebooks/",method = RequestMethod.POST)
    public List<BookDo> deleteBooks(@RequestParam String name ) {//此方法是通过书名来删除一本书
         BookCondition bookCondition = new BookCondition();
         bookCondition.createCriteria().andNameEqualTo(name);    //使得bookCondintion对象中具有
        // where name=实参(来自post)这条sql语句。where语句后面整体一块是BookCondintion对象,然后where后面由一个个and 和or组成(or为分割，
        // or前面的and是一个整体Criteria对象,or后面是另外的Criteria对象，即BookCondintion对象由Criteria对象组成)
        //Criteria对象调用andIdEqualTo(id)方法便使得BookCondintion对象具有了 where name =实参这句话，
        // 多调用一个andIdEqualTo(name)方法便是这后面添加条件。
        return bookService.deleteBooks(bookCondition);
    }
    @RequestMapping(value = "/updatebook",method = RequestMethod.POST)
    public BookDo updateBook(@RequestBody GetAllBookReq req) {//更新一本书，通过body部分注明要更新书的具体属性，
        //GetAllBookReq类和BookDo类属性相同，更新那个属性就在Body部分写明，不更新的属性不写为null即可
       return bookService.updateBook(req);
       //json格式的body部分不写该属性表示该属性为null

    }
    @RequestMapping(value = "/selectBook",method = RequestMethod.GET)
    public BookDo selectBook(@RequestParam Long id) {//通过id选择一本书的方法
       return bookService.selectBook(id);
    }
    //value值和method方法都一样的话，tomcat服务器程序会报错
    @RequestMapping(value = "/selectBook/",method = RequestMethod.GET)
    public List<BookDo> selectBook(@RequestParam String name) {//通过name来选中一本书
        return bookService.selectBook(name);
    }
}




