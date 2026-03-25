package example;

import com.simple.common.base.Page;
import example.order.Order;
import example.order.OrderDao;
import example.user.User;
import example.user.UserCond;
import example.user.UserDao;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

/**
 * ★★推荐OpenJdk21+(LTS)★★
 * 
 * @第03集 SimpleDAO联表、条件进阶
 */
@Slf4j
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Resource
	private UserDao userDao;
	@Resource
	private OrderDao orderDao;

	@PostConstruct
	public void run() {
		log.info("============================================================");
		log.info("【Java版】【案例-03】条件进阶（IN + 子查询）");
		log.info("============================================================");
		log.info("");

		log.info("1. 条件查询（条件：name like '%张%', age in (20,25,30), 且有订单）");
		UserCond cond = UserCond.builder().name("张").ages(new Integer[] { 20, 25, 30 }).subQuery(true).build();
		Page<User> page = userDao.page(cond);
		List<User> list = userDao.list(cond);
		log.info("   => 总记录数: {}", page.getRowCount());
		log.info("   => 查询结果: {}", list);
	}
}