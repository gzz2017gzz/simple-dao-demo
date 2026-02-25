package example.order;

import com.simple.common.base.BaseCondition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderCond extends BaseCondition {
    private String name; // 用户名模糊查询
    private String orderNo; // 订单号精准查询

    @Override
    protected void addCondition() {
        and("order_no =", orderNo);
        add("AND u.name LIKE ?", name, 3); //u 是 user 表的别名,3=前后模糊匹配
    }
}