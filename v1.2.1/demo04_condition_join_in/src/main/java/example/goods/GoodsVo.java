package example.goods;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class GoodsVo extends Goods {
    // 用户表字段
    private Long userId;
    private String userName;
    private Integer age;
    // 订单表字段
    private Long orderId;
    private String orderNo;
}