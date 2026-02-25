package example.user;

import java.time.LocalDateTime;

import com.simple.common.base.annotation.Id;
import com.simple.common.base.annotation.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Table("t_user")
public class User {
    @Id  // 默认雪花算法，自动生成 ID
    private Long id;
    private String name;
    private Integer age;
    private String email;

    // 审计字段（BaseDao 会自动填充）
    private LocalDateTime createTime;   // 创建时间
    private Long createBy;               // 创建人（示例中用固定值）
    private LocalDateTime updateTime;    // 修改时间
    private Long updateBy;                // 修改人
    private Byte dr;                      // 逻辑删除标记（0-正常，1-已删除）
}