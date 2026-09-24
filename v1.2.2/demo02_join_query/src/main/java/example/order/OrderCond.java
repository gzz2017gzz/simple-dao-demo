package example.order;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.simple.common.base.BaseCondition;
import lombok.Builder;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 【订单表】查询条件
 **/
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "【订单表】查询条件")
public class OrderCond extends BaseCondition {

	/**
	 * 拼加条件
	 **/
	@Override
	protected void addCondition() {
		// 原有条件
		and("order_no LIKE", orderNo, 3);
		and("user_id =", userId);
		and("order_name LIKE", orderName, 3);
		and("total_amount =", totalAmount);
		and("pay_amount =", payAmount);
		and("pay_type =", payType);
		and("order_status =", orderStatus);
		and("pay_time =", payTime);
		and("delivery_type =", deliveryType);
		and("receiver_name LIKE", receiverName, 3);
		and("receiver_phone LIKE", receiverPhone, 3);
		and("receiver_address LIKE", receiverAddress, 3);
		and("remark LIKE", remark, 3);
		and("dr =", dr);
		in("order_no", ids);


		// 新增条件
		in("order_no", orderNos);
		add("AND u.name LIKE ?", userName, 3);
		add("AND u.email LIKE ?", userEmail, 3);
		add("AND u.phone = ?", userPhone);
	}
	/* 新增查询条件 ↓ */
	@Schema(description = "订单编号")
	private Object [] orderNos;

	@Schema(description = "用户姓名")
	private String userName;

	@Schema(description = "用户手机号")
	private String userPhone;

	@Schema(description = "用户邮箱")
	private String userEmail;

	/* 默认条件↓ */
	@Schema(description = "订单编号集合")
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

	@Schema(description = "逻辑删除 0正常 1删除")
	private Integer dr;

	@Schema(description = "包含主键(集)")
	private Object[] ids;
}