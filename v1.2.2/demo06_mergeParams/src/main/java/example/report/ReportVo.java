package example.report;

import java.math.BigDecimal;

import lombok.Data;

/**
 * 按商品分组报表VO
 */
@Data
public class ReportVo {
    private String goodsName;
    private Integer orderCount;
    private Integer goodsCount;
    private BigDecimal totalAmount;
    private BigDecimal avgPrice;
}