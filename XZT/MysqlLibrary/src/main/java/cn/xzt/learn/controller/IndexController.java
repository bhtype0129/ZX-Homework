package cn.xzt.learn.controller;

import cn.xzt.learn.domain.BookDO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * --Create by xzt-- on 18-1-26
 */
//@RequestMapping(value = "/",method = RequestMethod.GET)//Rest约等于http
//public String showIndex() {
//return "Hello World11111111111";
/*
@RestController
public class IndexController {

    @RequestMapping(value = "/")
    public Map<String,String> showIndex() {
        System.out.println("fsgseg");
        Map<String,String> map = new HashMap<String, String>();
        map.put("name","name");
        return map;
    }

}
*/

@RestController
public class IndexController {

    @RequestMapping(value = "/")
    public BookDO showIndex() {
        BookDO bookDO = new BookDO();
        bookDO.setName("名字");
        bookDO.setClassify("classify");
        return bookDO;
    }

}