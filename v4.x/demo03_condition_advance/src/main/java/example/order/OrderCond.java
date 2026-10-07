package example.order;

import java.util.Objects;

import com.simple.common.base.BaseCondition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 【订单表】查询条件
 **/
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderCond extends BaseCondition {
	private String name;
	private Integer age;
	private Integer[] inAges;
	private Boolean subQuery;
	private String orderNo;
	private String[] orderNos;
	private Byte orderStatus;

	@Override
	protected void addCondition() {
		// 关联表：无语法糖，自己写别名
		add("AND t.order_status = ?", orderStatus);
		add("AND t.order_no LIKE ?", orderNo, 3);
		add("AND t.order_no IN ", orderNos);
		// IN 条件（主表同样适用）
		add("AND u.age IN ", inAges);
		// 静态子查询
		// add("AND u.id IN (SELECT user_id FROM bus_order WHERE dr=0)");
//		// 动态子查询
		add("AND u.id IN (SELECT user_id FROM bus_order WHERE dr=0)", Objects.equals(Boolean.TRUE, subQuery));
	}
}