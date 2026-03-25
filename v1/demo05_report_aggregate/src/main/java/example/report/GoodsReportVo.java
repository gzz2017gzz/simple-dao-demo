package example.report;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class GoodsReportVo {
    private String goodsName;
    private String userName;
    private Long userId;
    private Integer orderCount;
    private Integer goodsCount;
    private BigDecimal totalAmount;
    private BigDecimal avgPrice;
}