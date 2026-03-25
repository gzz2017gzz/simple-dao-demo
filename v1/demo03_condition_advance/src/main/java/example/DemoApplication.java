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

		log.info("1. 插入用户数据");
		User user1 = User.builder().name("张三").age(25).email("zhangsan@example.com").build();
		userDao.save(user1);
		log.info("   => 插入成功，ID: {}, name: {}, age: {}", user1.getId(), user1.getName(), user1.getAge());
		User user2 = User.builder().name("张四").age(30).email("zhangsi@example.com").build();
		userDao.save(user2);
		log.info("   => 插入成功，ID: {}, name: {}, age: {}", user2.getId(), user2.getName(), user2.getAge());
		User user3 = User.builder().name("李四").age(20).email("lisi@example.com").build();
		userDao.save(user3);
		log.info("   => 插入成功，ID: {}, name: {}, age: {}", user3.getId(), user3.getName(), user3.getAge());

		log.info("2. 插入订单数据");
		Order order1 = Order.builder().orderNo("ORDER20260225_01").userId(user1.getId()).build();
		orderDao.save(order1);
		log.info("   => 插入成功，订单号: {}, 关联用户ID: {}", order1.getOrderNo(), order1.getUserId());
		Order order2 = Order.builder().orderNo("ORDER20260225_02").userId(user2.getId()).build();
		orderDao.save(order2);
		log.info("   => 插入成功，订单号: {}, 关联用户ID: {}", order2.getOrderNo(), order2.getUserId());

		log.info("3. 条件查询（条件：name like '%张%', age in (20,25,30), 且有订单）");
		UserCond cond = UserCond.builder().name("张").ages(new Integer[] { 20, 25, 30 }).subQuery(true).build();
		Page<User> page = userDao.page(cond);
		List<User> list = userDao.list(cond);
		log.info("   => 总记录数: {}", page.getRowCount());
		log.info("   => 查询结果: {}", list);
	}
}