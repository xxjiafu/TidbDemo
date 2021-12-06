package com.org.Demo.mp.po;

/**
 * @author xujiafu
 * @date 2021/11/27 20:50
 */
 import com.baomidou.mybatisplus.annotation.SqlCondition;
 import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import java.time.LocalDateTime;
 import java.util.Date;

@Data
public class User {
    private Long id;
//    @TableField(condition = "%s &gt; #{%s}") // 这里相当于大于, 其中 &gt; 是字符实体
//    @TableField(condition = SqlCondition.LIKE)

    private String name;
//    @TableField(condition = "%s &gt; #{%s}") // 这里相当于大于, 其中 &gt; 是字符实体
    private Integer age;
    private String email;
    private Long managerId;
    private Date createTime;
}

