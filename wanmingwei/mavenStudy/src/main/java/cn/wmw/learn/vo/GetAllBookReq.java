package cn.wmw.learn.vo;

import cn.wmw.learn.domain.BookDO;
import lombok.Data;

import javax.annotation.Resource;

/**
 * Created by mingwei on 18-1-26
 */
@Data
public class GetAllBookReq {
    int pageSize;
    int maxPageCount;
}
