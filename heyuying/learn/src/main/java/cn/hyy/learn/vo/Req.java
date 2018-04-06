package cn.hyy.learn.vo;


import lombok.Data;

/**
 * Created by heyuying on 18-1-26
 */
@Data
public class Req {
    int pageSize;
    int maxPageCount;
    long id;
    String name;
    String author;
    String catalogue;
    String brief;
}
