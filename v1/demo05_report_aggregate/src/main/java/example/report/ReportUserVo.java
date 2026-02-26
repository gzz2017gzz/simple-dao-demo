package example.report;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

/**
 * 按用户分组报表VO
 */
@Getter
@Setter
public class ReportUserVo {
    // 用户表字段：u.id/u.name
    private Long id;
    private String name;
    // 聚合字段：order_count/goods_count/total_amount
    private Integer orderCount;
    private Integer goodsCount;
    private BigDecimal totalAmount;
}