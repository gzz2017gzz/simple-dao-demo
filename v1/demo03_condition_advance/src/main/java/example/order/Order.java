package example.order;

import com.simple.common.base.annotation.Id;
import com.simple.common.base.annotation.Table;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 【订单表】实体
 **/
@Data
@Schema(description = "【订单表】实体")
@Table("bus_order")
public class Order {
    // 字段↓
    @Id
    @Schema(description = "主键ID")
    private Integer id;

    @Schema(description = "订单编号")
    private String orderNo;

    @Schema(description = "用户ID")
    private Integer userId;

    @Schema(description = "订单名称")
    private String orderName;

    @Schema(description = "订单总金额")
    private BigDecimal totalAmount;

    @Schema(description = "实付金额")
    private BigDecimal payAmount;

    @Schema(description = "支付方式 1微信 2支付宝")
    private Integer payType;

    @Schema(description = "订单状态 0待支付 1已支付 2已完成")
    private Integer orderStatus;

    @Schema(description = "支付时间")
    private LocalDateTime payTime;

    @Schema(description = "配送方式")
    private Integer deliveryType;

    @Schema(description = "收货人姓名")
    private String receiverName;

    @Schema(description = "收货人电话")
    private String receiverPhone;

    @Schema(description = "收货地址")
    private String receiverAddress;

    @Schema(description = "订单备注")
    private String remark;

    @Schema(hidden = true)
    private LocalDateTime createTime;

    @Schema(hidden = true)
    private Integer createBy;

    @Schema(hidden = true)
    private LocalDateTime updateTime;

    @Schema(hidden = true)
    private Integer updateBy;

    @Schema(hidden = true)
    private Integer dr;

    /* 扩展(显示)属性↓@Exclude */
}