package example.demo;

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
public class UserCond extends BaseCondition {
	private String name; // 模糊查询
	private Integer ageMin;
	private Integer ageMax;

	@Override
	protected void addCondition() {
		and("name LIKE", name, 3); // 前后模糊匹配
		and("age >=", ageMin);
		and("age <=", ageMax);
	}
}