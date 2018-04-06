package cn.lgw.learn.vo;

import lombok.Data;

@Data
public class GetAllBookReq {
    int pageSize;

    int maxPageCount;

    int id;
}
