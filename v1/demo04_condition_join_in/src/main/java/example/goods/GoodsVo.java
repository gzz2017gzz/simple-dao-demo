package example.goods;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Setter
@Getter
public class GoodsVo {
    // 用户表字段
    private Long userId;
    private String userName;
    private Integer age;
    // 订单表字段
    private Long orderId;
    private String orderNo;
    // 商品表字段
    private Long goodsId;
    private String goodsName;
    private BigDecimal price;
}