package example.report;

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
public class BizCond extends BaseCondition {
    private String goodsName; // 商品名模糊查询
    private Double priceMin;  // 商品最低价格
    private Double priceMax;  // 商品最高价格

    @Override
    protected void addCondition() {
        add("AND t.price >= ?", priceMin);
        add("AND t.price <= ?", priceMax);
        add("AND t.goods_name LIKE ?", goodsName, 3); // 3=前后模糊
    }
}