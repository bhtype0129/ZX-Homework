package cn.lgw.learn.controller;

import cn.lgw.learn.to.resp.RestResponse;
import cn.lgw.learn.util.WebContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by leiguowei on 2018/1/26
 */
@RestController
public class IndexController {
    @RequestMapping(value = "/")
    public RestResponse showIndex(HttpSession session) {
        return RestResponse.ok("this is index!");
    }
}