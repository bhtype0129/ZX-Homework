package cn.lgw.learn.controller;

import cn.lgw.learn.annotation.Auth;
import cn.lgw.learn.converter.UserConverter;
import cn.lgw.learn.enums.RoleEnum;
import cn.lgw.learn.exception.CommonException;
import cn.lgw.learn.service.UserService;
import cn.lgw.learn.to.req.UserRegisterReq;
import cn.lgw.learn.to.resp.RestResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public RestResponse register(UserRegisterReq req) throws CommonException {
        return RestResponse.ok(userService.register(UserConverter.registerReq2do(req)));
    }

    @Auth(roles = RoleEnum.USER)
    @RequestMapping(value = "/user/current", method = RequestMethod.GET)
    public RestResponse getCurrentUserInfo() {
        return RestResponse.ok(userService.getCurrentUserInfo());
    }

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public RestResponse listUsers(int pageNum, int pageSize) {
        return RestResponse.ok(userService.listUsers(pageNum, pageSize));
    }
}
