package cn.wmw.learn.vo;

import lombok.Data;

/**
 * Created by mingwei on 18-3-4
 */
@Data
public class GetUpdateBookReq {
    int number;
    String author;
    String name;
    String intro;
    String catalogue;
}
