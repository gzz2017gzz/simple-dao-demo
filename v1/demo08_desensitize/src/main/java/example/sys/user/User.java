package example.sys.user;

import com.simple.common.base.annotation.Id;
import com.simple.common.base.annotation.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Table("sys_user")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	private Long id;
	private String name;
	private Integer age;
	private String idCard;
	private String phone;
	private LocalDateTime createTime;
	private Long createBy;
	private LocalDateTime updateTime;
	private Long updateBy;
	private Integer isDeleted;
}