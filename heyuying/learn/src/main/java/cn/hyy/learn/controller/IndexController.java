package cn.hyy.learn.controller;

import cn.hyy.learn.domain.BookDO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by heyuying on 18-1-26
 */

//网页请求相关的注解 说明是处理用户请求的类
//说明这个类是用来处理HTTP的  Rest相当于HTTP
@RestController
public class IndexController {
//    请求映射 网址到达服务器网址会去掉，只会留下 / 及后面的东西 , 其组成请求参数
//    请求参数为“/”的会执行 showIndex方法
//    例如访问www.baidu.com                     其请求参数是 /
//    例如访问www.baidu.com/s?ie=UTF-8&wd=post  其请求是 /s?ie=UTF-8&wd=post
//    method 指明请求方式（请求方式一般有get post（新增）put（跟新）delete）

    @RequestMapping(value = "/",method = RequestMethod.GET)    //默认GET查找 POST新增 PUT更新 DELETE 删除
    public BookDO showIndex() {
        BookDO book = new BookDO();
        book.setName("name");
        book.setAuthor("author");
        book.setCatalogue("catalogue");
        book.setBrief("简介");
        return book;
    }

   /* public Map<String, String> showIndex() {
        Map<String,String> map = new HashMap<String, String>();
        map.put("name", "name");
        return map;
    }
*/

     /* public String showIndex() {

        return "Hello World1111111111111";
    }*/
}
