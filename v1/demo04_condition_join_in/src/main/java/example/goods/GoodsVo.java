package example.goods;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class GoodsVo extends Goods {
    // 用户表字段
    private Long userId;
    private String userName;
    private Integer age;
    // 订单表字段
    private Long orderId;
    private String orderNo;
}