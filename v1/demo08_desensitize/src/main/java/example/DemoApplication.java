package example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import example.sys.user.User;
import example.sys.user.UserCond;
import example.sys.user.UserService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

/**
 * 推荐OpenJdk21+(LTS)
 */
@Slf4j
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private UserService service;

	@PostConstruct
	public void demo() {
		log.info("============================================================");
		log.info("【Java版】【案例-08】 删除标记字段·脱敏·审计字段重写");
		log.info("============================================================");

		log.info("1. 单条插入");
		User user = User.builder().name("张三").age(25).idCard("110101199001011239").phone("13800138000").build();
		service.save(user);
		log.info("2. 按 ID 查询");
		User u = service.findById(user.getId());
		log.info("   => 查询结果: {}", u);
		log.info("3. 脱敏");
		service.list(new UserCond()).forEach(i -> log.info("user={}", i));
	}
}