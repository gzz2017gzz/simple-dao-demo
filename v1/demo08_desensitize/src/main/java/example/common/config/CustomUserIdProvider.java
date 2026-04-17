package example.common.config;

import org.springframework.stereotype.Component;

import com.simple.common.base.UserIdProvider;

/**
 * 自定义用户ID提供者，演示如何覆盖 SimpleDAO 默认的审计字段来源
 */
@Component
public class CustomUserIdProvider implements UserIdProvider {
	@Override
	public Long userId() {
		// 示例：实际项目中可以从 Session、Shiro、Redis、SpringSecurity 等获取
		// 示例：SessionUtils.getUserId()
		// 示例：ShiroUtils.getUserId()
		// 示例：RedisUtils.getUserId()
		// 示例：SpringSecurityUtils.getUserId()
		return 9999L; // 演示用固定值，观众可替换为自己的逻辑
	}
}
