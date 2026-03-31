package example.user;

import java.time.LocalDate;

import com.simple.common.base.BaseCondition;
import lombok.Builder;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 【用户表】查询条件
 **/
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "【用户表】查询条件")
public class UserCond extends BaseCondition {

    /**
     * 拼加条件
     **/
    @Override
    protected void addCondition() {
        and("name LIKE", name, 3);
        and("age =", age);
        and("email LIKE", email, 3);
        and("phone LIKE", phone, 3);
        and("password LIKE", password, 3);
        and("sex =", sex);
        and("avatar LIKE", avatar, 3);
        and("status =", status);
        and("birthday =", birthday);
        and("address LIKE", address, 3);
        and("user_type =", userType);
        and("remark LIKE", remark, 3);
        and("dr =", dr);
        in("id", ids);
        /* 新境条件↓ */
        and("age >=", ageMin);
        and("age <=", ageMax);

    }

    /* 新境条件↓ */
    @Schema(description = "年龄上限")
    private Integer ageMax;

    @Schema(description = "年龄下限")
    private Integer ageMin;
    /* 默认条件↓ */
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
    private Byte sex;

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

    @Schema(description = "逻辑删除 0正常 1删除")
    private Byte dr;

    @Schema(description = "包含主键(集)")
    private Object[] ids;

}