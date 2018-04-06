package cn.wmw.learn.vo;

import cn.wmw.learn.domain.BookDO;
import lombok.Data;

import javax.annotation.Resource;

/**
 * Created by mingwei on 18-3-2
 */
@Data
public class GetInsectBookReq {
    String name;
    String author;
    String catalogue;
    String intro;
}
