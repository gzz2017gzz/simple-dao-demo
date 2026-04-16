package example.user;

import com.simple.common.base.annotation.Id;
import com.simple.common.base.annotation.Table;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 【用户表】实体
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "【用户表】实体")
@Table("sys_user")
public class User {
	// 字段↓
	@Id
	@Schema(description = "主键ID")
	private Long id;
	
	@Schema(description = "用户名")
	private String name;
	
	@Schema(description = "年龄")
	private Integer age;
	
	@Schema(description = "邮箱")
	private String email;
	
	@Schema(description = "手机号")
	private String phone;
	
	@Schema(description = "密码")
	private String password;
	
	@Schema(description = "性别 1男 2女")
	private Byte  sex;
	
	@Schema(description = "头像地址")
	private String avatar;
	
	@Schema(description = "状态 1正常 0禁用")
	private Byte status;
	
	@Schema(description = "生日")
	private LocalDate birthday;
	
	@Schema(description = "地址")
	private String address;
	
	@Schema(description = "用户类型 1普通 2管理员")
	private Byte userType;
	
	@Schema(description = "备注")
	private String remark;
	
	@Schema(hidden = true)
	private LocalDateTime createTime;
	
	@Schema(hidden = true)
	private Long createBy;
	
	@Schema(hidden = true)
	private LocalDateTime updateTime;
	
	@Schema(hidden = true)
	private Long updateBy;
	
	@Schema(hidden = true)
	private Byte isDeleted;
	
	/* 扩展(显示)属性↓@Exclude */
}