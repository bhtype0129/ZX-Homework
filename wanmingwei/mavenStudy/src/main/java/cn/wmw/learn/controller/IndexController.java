package cn.wmw.learn.controller;

import cn.wmw.learn.domain.BookDO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * Created by mingwei on 18-1-26
 */
//网页请求相关的注解 说明这是接受用户请求的类
//说明这个类是用来处理HTTP的  Rest相当于HTTP
@RestController
public class IndexController {
//    请求映射 网址到达服务器网址会去掉，只会留下 / 及后面的东西 , 其组成请求参数
//    请求参数为“/”的会执行 showIndex方法
//    例如访问www.baidu.com                     其请求参数是 /
//    例如访问www.baidu.com/s?ie=UTF-8&wd=post  其请求是 /s?ie=UTF-8&wd=post
//    method 指明请求方式（请求方式一般有get post（新增）put（跟新）delete）
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public BookDO showIndex() {
        BookDO bookDO = new BookDO();
        bookDO.setName("明威");
        bookDO.setAuthor("author");
        return bookDO;
    }
}
