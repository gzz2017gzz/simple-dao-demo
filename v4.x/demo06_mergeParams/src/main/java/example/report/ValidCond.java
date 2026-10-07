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
public class ValidCond extends BaseCondition {
    private String userName; // 用户名模糊查询

    @Override
    protected void addCondition() {
        add("AND name LIKE ?", userName, 3); // 3=前后模糊
        add("AND dr = 0"); // 固定有效数据筛选
    }
}