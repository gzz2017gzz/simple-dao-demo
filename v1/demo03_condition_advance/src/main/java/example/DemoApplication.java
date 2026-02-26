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
		// 1. 先插入测试数据（多条用户+关联订单）
		// 插入3个用户
		User user1 = User.builder().name("张三").age(25).email("zhangsan@example.com").build();
		userDao.save(user1);
		User user2 = User.builder().name("张四").age(30).email("zhangsi@example.com").build();
		userDao.save(user2);
		User user3 = User.builder().name("李四").age(20).email("lisi@example.com").build();
		userDao.save(user3);

		// 插入订单（关联张三/张四，用于子查询）
		Order order1 = Order.builder().orderNo("ORDER20260225_01").userId(user1.getId()).build();
		orderDao.save(order1);
		Order order2 = Order.builder().orderNo("ORDER20260225_02").userId(user2.getId()).build();
		orderDao.save(order2);

		log.info("=== SimpleDAO 条件类进阶演示 ===");
		// 2. 构建进阶条件：模糊查询（张）+IN条件（20,25,30）+子查询
		UserCond cond = UserCond.builder().name("张").ages(new Integer[] { 20, 25, 30 }).subQuery(true).build();
		// 3. 条件查询（分页+列表）
		Page<User> page = userDao.page(cond);
		List<User> list = userDao.list(cond);
		// 4. 打印结果
		log.info("条件查询总数: {}", page.getRowCount());
		log.info("条件查询结果: {}", list);
	}
}