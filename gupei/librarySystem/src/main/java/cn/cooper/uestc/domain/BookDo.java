package cn.cooper.uestc.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDo {
    /**
     *
     */

    private Long id;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private String author;

    /**
     *
     */
    private String catalogue;

    /**
     *
     */
    private String intro;
}