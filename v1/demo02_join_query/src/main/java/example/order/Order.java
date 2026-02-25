package example.order;

import com.simple.common.base.annotation.Id;
import com.simple.common.base.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Table("t_order")
public class Order {
    @Id
    private Long id;
    private String orderNo;
    private Long userId;
    private LocalDateTime createTime;
    private Long createBy;
    private LocalDateTime updateTime;    // 修改时间
    private Long updateBy;                // 修改人
    private Byte dr;                      // 逻辑删除标记（0-正常，1-已删除）
}