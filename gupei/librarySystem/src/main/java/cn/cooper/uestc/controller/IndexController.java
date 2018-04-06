package cn.cooper.uestc.controller;


import cn.cooper.uestc.domain.BookDo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * By GuPei 18-1-26
 */
@RestController
//刚才只是在配置文件里面配置好处理请求的配置，下面是具体处理用户请求的java class方法，被包含在IndexController类里面.
public class IndexController {
    //首页到达我们后台的时候只剩下/,会去掉前面的网址，只剩下/。这些在后端都视为请求，下面这个注解是对showIndex方法进行注解。
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public BookDo showIndex() {
        //返回一个bookDo对象，通过阿里的json里的配置框架将一个对象写为json格式显示出来(即修改过的tostring形式)，
        // 如果没有写入阿里json的框架则spring-mvc框架会对对象调用toString方法并显示出来。
        //此处缺少了一个id属性，没有设置的原因是当初建立数据库的时候设置了id为primarykey，每当插入一条新的记录的时候会自增1，
        // 所以无需设置
        BookDo bookDo = new BookDo();
        bookDo.setName("红楼梦");
        bookDo.setIntro("无介绍");
        bookDo.setCatalogue("无目录");
        bookDo.setAuthor("曹雪芹");
        return bookDo;
    }


}
