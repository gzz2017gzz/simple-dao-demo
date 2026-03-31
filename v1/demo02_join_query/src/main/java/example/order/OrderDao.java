package example.order;

import com.simple.common.base.BaseDao;

import com.simple.common.base.Page;
import org.springframework.stereotype.Repository;


/**
 * 【订单表】数据访问层
 **/
@Repository
public class OrderDao extends BaseDao<Order> {
    private final static String SQL = """
            SELECT t.id,t.order_no,t.user_id,t.order_name,t.total_amount,t.pay_amount,t.pay_type,t.order_status,t.pay_time,t.delivery_type,
                t.receiver_name,t.receiver_phone,t.receiver_address,t.remark,t.create_time,t.create_by,t.update_time,t.update_by,t.dr,
                u.name user_name,u.phone user_phone,u.email user_email
            FROM bus_order t
            LEFT JOIN sys_user u ON t.user_id = u.id""";

    /**
     * 【订单表】JOIN分页列表
     */
    public Page<OrderVO> pageJoin(OrderCond cond) {
        return page(SQL, cond, OrderVO.class);
    }
}