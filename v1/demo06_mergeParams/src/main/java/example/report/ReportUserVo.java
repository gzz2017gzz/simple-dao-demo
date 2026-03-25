package example.report;

import java.math.BigDecimal;

import lombok.Data;

/**
 * 按用户分组报表VO
 */
@Data
public class ReportUserVo {
    // 用户表字段：u.id/u.name
    private Long id;
    private String name;
    // 聚合字段：order_count/goods_count/total_amount
    private Integer orderCount;
    private Integer goodsCount;
    private BigDecimal totalAmount;
}