package example.demo;

import com.simple.common.base.BaseCondition;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCond extends BaseCondition {
    private String name;      // 模糊查询
    private Integer ageMin;
    private Integer ageMax;

    @Override
    protected void addCondition() {
        and("name LIKE", name, 3);      // 前后模糊匹配
        and("age >=", ageMin);
        and("age <=", ageMax);
    }
}