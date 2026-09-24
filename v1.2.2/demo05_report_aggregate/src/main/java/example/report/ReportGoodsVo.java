package example.report;

import java.math.BigDecimal;

import lombok.Data;

/**
 * 按商品分组报表VO
 */
@Data
public class ReportGoodsVo {
    // 商品表字段：t.goods_name
    private String goodsName;
    // 聚合字段：order_count/goods_count/total_amount/avg_price
    private Integer orderCount;
    private Integer goodsCount;
    private BigDecimal totalAmount;
    private BigDecimal avgPrice;
}