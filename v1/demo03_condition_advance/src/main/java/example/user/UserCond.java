package example.user;

import com.simple.common.base.BaseCondition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 条件类进阶玩法：模糊查询+IN条件+子查询
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCond extends BaseCondition {
    // 模糊查询参数
    private String name;
    // IN条件参数
    private Integer[] ages;
    // 是否开启子查询（演示用）
    private boolean subQuery;

    @Override
    protected void addCondition() {
        // 1. 模糊查询：3=前后模糊（1=左模糊，2=右模糊），自动非空判断
        and("name LIKE", name, 3);

        // 2. IN条件：自动生成 (?, ?, ?)，支持数组，自动非空判断
        in("age", ages);

        // 3. 子查询：原生SQL直接写，兼容所有复杂场景
        add("AND id IN (SELECT user_id FROM t_order WHERE dr=0)", subQuery);
    }
}