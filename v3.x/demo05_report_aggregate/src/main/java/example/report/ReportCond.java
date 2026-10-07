package example.report;

import com.simple.common.base.BaseCondition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 所有筛选条件一站式，按需传值，传则生效、不传忽略
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReportCond extends BaseCondition {
    // 时间范围：订单创建开始/结束时间
    private LocalDateTime orderTimeStart;
    private LocalDateTime orderTimeEnd;
    // 模糊查询：用户名/商品名（前后模糊，内置3标识）
    private String userName;
    private String goodsName;
    // 区间查询：商品价格最小/最大值
    private Double priceMin;
    private Double priceMax;

    @Override
    protected void addCondition() {
        // 固定条件：有效数据过滤（dr=0），必生效
        add("AND t.dr = 0");
        add("AND o.dr = 0");
        add("AND u.dr = 0");
        // 时间范围：传值则拼接，不传忽略
        add("AND o.create_time >= ?", orderTimeStart);
        add("AND o.create_time <= ?", orderTimeEnd);
        // 模糊查询：前后模糊（3），传值则拼接，不传忽略
        add("AND u.name LIKE ?", userName, 3);
        add("AND t.goods_name LIKE ?", goodsName, 3);
        // 价格区间：传值则拼接，不传忽略
        add("AND t.price >= ?", priceMin);
        add("AND t.price <= ?", priceMax);
    }
}