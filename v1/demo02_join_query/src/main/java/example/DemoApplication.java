package example;

import example.order.Order;
import example.order.OrderCond;
import example.order.OrderDao;
import example.order.OrderVO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.simple.common.base.Page;

import example.user.User;
import example.user.UserDao;
import lombok.extern.slf4j.Slf4j;

/**
 * ★★推荐OpenJdk21+(LTS)★★
 * 
 * @第02集 SimpleDAO联表、条件应用
 */
@Slf4j
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserDao userDao, OrderDao orderDao) {
		return args -> {
			log.info("============================================================");
			log.info("【Java版】【案例-02】联表查询（订单 + 用户）");
			log.info("============================================================");
			log.info("");

			log.info("1. 插入用户数据");
			User user = new User();
			user.setName("张三");
			user.setAge(25);
			user.setEmail("zhangsan@example.com");
			userDao.save(user);
			log.info("   => 插入成功，ID: {}, create_time: {}, create_by: {}", user.getId(), user.getCreateTime(), user.getCreateBy());

			log.info("2. 插入订单数据");
			Order order1 = new Order();
			order1.setOrderNo("ORDER20260225");
			order1.setUserId(user.getId());
			orderDao.save(order1);
			log.info("   => 插入成功，订单号: {}, 关联用户ID: {}", order1.getOrderNo(), order1.getUserId());

			log.info("3. 联表分页查询（条件：用户名含'张'，订单号=ORDER20260225）");
			OrderCond cond = OrderCond.builder().name("张").orderNo("ORDER20260225").build();
			Page<OrderVO> page = orderDao.pageJoin(cond);
			log.info("   => 总记录数: {}", page.getRowCount());
			page.getDataList().forEach(vo -> log.info("   => 第{}页数据: {}", page.getPage(), vo));
		};
	}
}