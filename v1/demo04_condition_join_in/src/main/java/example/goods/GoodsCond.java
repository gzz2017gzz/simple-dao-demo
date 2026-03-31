package example.goods;


import com.simple.common.base.BaseCondition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.ArrayUtils;

import java.time.LocalDateTime;
import java.util.Objects;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GoodsCond extends BaseCondition {
    private String userName;
    private String orderNo;
    private LocalDateTime createTimeStart; // 订单创建开始时间
    private LocalDateTime createTimeEnd;   // 订单创建结束时间
    private Object[] goodsNames;    // 商品名数组

    private LocalDateTime createBetweenStart;
    private LocalDateTime createBetweenEnd;

    @Override
    protected void addCondition() {
        add("AND t.dr = 0");
        add("AND o.create_time >= ?", createTimeStart);
        add("AND o.create_time <= ?", createTimeEnd);

        add("AND u.name LIKE ?", userName, 3); // 3=前后加%，SimpleDAO内置规则
        add("AND o.order_no LIKE ?", orderNo, 3);

        // 场景3：关联表子查询带IN条件
        if (ArrayUtils.isNotEmpty(goodsNames)) {
            add("AND o.id IN (SELECT order_id FROM bus_goods WHERE goods_name IN", goodsNames);
            add("AND dr=0)");
        }
        // 场景4：BETWEEN关键字通常不用,不灵活必须两边都有值(不推荐)
        if (Objects.nonNull(createBetweenStart) && Objects.nonNull(createBetweenEnd)) {
            add("AND o.create_time BETWEEN ?", createBetweenStart);
            add("AND ?", createBetweenEnd);
        }

        // 场景5：BETWEEN替代写法(不推荐)
        if (Objects.nonNull(createBetweenStart) && Objects.nonNull(createBetweenEnd)) {
            add("AND o.create_time >= ?", createBetweenStart);
            add("AND o.create_time <= ?", createBetweenEnd);
        }
        // 场景6：常规业务俩侧值随意空值(推荐SimpleDAO核心用法)
        add("AND o.create_time >= ?", createBetweenStart);
        add("AND o.create_time <= ?", createBetweenEnd);
    }
}