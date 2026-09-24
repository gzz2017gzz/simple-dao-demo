package example.order;

import org.springframework.stereotype.Repository;

import com.simple.common.base.BaseDao;
import com.simple.common.base.Page;

/**
 * 【订单表】数据访问层
 **/
@Repository
public class OrderDao extends BaseDao<Order> {
	// 生产环境不推荐写*,纯为演示清晰
	private final static String SQL = """
		SELECT t.*,u.name user_name,u.phone user_phone,u.email user_email
		FROM bus_order t
		LEFT JOIN sys_user u ON t.user_id = u.id""";

	public Page<OrderVO> pageJoin(OrderCond cond) {
		return page(SQL, cond, OrderVO.class);
	}
}