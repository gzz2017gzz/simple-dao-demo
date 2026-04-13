package example;

import com.simple.common.base.Page;
import example.user.User;
import example.user.UserCond;
import example.user.UserDao;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

/**
 * 推荐OpenJdk21+(LTS)
 */
@Slf4j
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	private static final Byte BYTE_1 = Byte.valueOf("1");
	private static final Byte BYTE_0 = Byte.valueOf("0");

	@Autowired
	private UserDao userDao;

	@PostConstruct
	public void demo() {
		log.info("============================================================");
		log.info("【Java版】【案例-01】单表 CRUD + 审计字段 + 逻辑删除");
		log.info("============================================================");

		log.info("1. 单条插入");
		User user = User.builder().name("张三").age(25).email("zhangsan@QQ.com").phone("13800138000").password("123456").avatar("https://www.gzz.com").remark("牛逼-plus").address("北京").sex(BYTE_1).status(BYTE_1).birthday(LocalDate.now()).userType(BYTE_1).build();
		userDao.save(user);
		log.info("2. 批量插入");
		userDao.saveBatch(List.of(User.builder().name("李四").age(28).email("lisi@QQ.com").phone("13900139000").password("123456").avatar("https://www.ls.com").remark("技术大佬").address("上海").sex(BYTE_1).status((byte) 1).birthday(LocalDate.now()).userType((byte) 1).build(),
				User.builder().name("王五").age(30).email("wangwu@QQ.com").phone("13700137000").password("123456").avatar("https://www.ww.com").remark("业务骨干").address("广州").sex(BYTE_1).status((byte) 1).birthday(LocalDate.now()).userType((byte) 1).build()));

		log.info("3. 按 ID 查询");
		User u = userDao.findById(user.getId());
		log.info("   => 查询结果: {}", u);

		log.info("4. 条件分页查询（条件：name LIKE '%张%' AND age > 20 AND < 30）");
		Page<User> page = userDao.page(UserCond.builder().name("张").ageMax(30).ageMin(20).build());
		log.info("   => 总记录数: {}", page.getRowCount());
		page.getDataList().forEach(item -> log.info("   => 第{}页数据: {}", page.getPage(), item));

		log.info("5. 更新数据");
		u.setAge(26);
		userDao.update(u);
		log.info("   => 更新成功，user={}", userDao.findById(u.getId()));

		log.info("6. 逻辑删除");
		userDao.delete(u.getId());

		log.info("7. 查询所有记录");
		userDao.list(UserCond.builder().dr(BYTE_0).build()).forEach(item -> log.info("   => 结果: {}", item));
	}
}