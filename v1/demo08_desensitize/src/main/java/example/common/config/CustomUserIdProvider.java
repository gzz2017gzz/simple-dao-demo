package example.common.config;

import com.simple.common.base.UserIdProvider;
import org.springframework.stereotype.Component;

@Component
public class CustomUserIdProvider implements UserIdProvider {
	@Override
	public Long userId() {
		// 示例：SessionUtils.getUserId()
		// 示例：ShiroUtils.getUserId()
		// 示例：RedisUtils.getUserId()
		// 示例：SpringSecurityUtils.getUserId()
		return 9999L;
	}
}