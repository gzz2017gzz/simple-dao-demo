package example.sys.user;

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

	private String name;
	private Integer age;
	private String phone;
	private String idCard;
	private Integer isDeleted;

	@Override
	protected void addCondition() {
		add("AND name LIKE ?", name, 3);
		add("AND age = ?", age);
		add("AND phone LIKE ?", phone, 3);
		add("AND id_card LIKE ?", idCard, 3);
		add("AND is_deleted = ?", isDeleted);
	}
}