package example.order;

import com.simple.common.base.BaseDao;
import com.simple.common.base.Page;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDao extends BaseDao<Order> {
    // 联表查询订单+用户信息
    public Page<OrderVO> pageJoin(OrderCond cond) {
    	String sql = """
			SELECT t.id,t.order_no,t.user_id,t.create_time,t.create_by,t.update_time,t.update_by,t.dr,u.name user_name  
			FROM t_order t  
			JOIN t_user u ON t.user_id = u.id""";
        return page(sql, cond, OrderVO.class);
    }
}