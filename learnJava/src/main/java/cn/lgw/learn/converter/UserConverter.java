package cn.lgw.learn.converter;

import cn.lgw.learn.domain.UserDO;
import cn.lgw.learn.to.req.UserRegisterReq;
import cn.lgw.learn.to.resp.GeneralUserTO;

public class UserConverter {
    public static UserDO registerReq2do(UserRegisterReq from) {
        UserDO to = new UserDO();

        to.setName(from.getName());
        to.setUsername(from.getUsername());
        to.setPassword(from.getPassword());
        to.setStuId(from.getStuId());
        to.setSchool(from.getSchool());
        to.setGrade(from.getGrade());
        to.setPhone(from.getPhone());
        if (from.getSex() != null) {
            to.setSex(from.getSex().byteValue());
        }

        return to;
    }

    public static GeneralUserTO do2generalTo(UserDO from) {
        GeneralUserTO to = new GeneralUserTO();

        to.setUserId(from.getUserId());
        to.setName(from.getName());
        to.setGrade(from.getGrade());
        to.setSchool(from.getSchool());
        to.setSex(from.getSex());

        return to;
    }
}
