package example.report;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class GoodsReportVo {
    private String goodsName;
    private String userName;
    private Long userId;
    private Integer orderCount;
    private Integer goodsCount;
    private BigDecimal totalAmount;
    private BigDecimal avgPrice;
}