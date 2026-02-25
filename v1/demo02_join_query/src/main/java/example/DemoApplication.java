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

@Slf4j
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserDao userDao, OrderDao orderDao) {
        return args -> {
            log.info("=== SimpleDAO 联表演示 ===");
            User user = new User();
            user.setName("张三");
            user.setAge(25);
            user.setEmail("zhangsan@example.com");
            userDao.save(user); // ID 自动生成，审计字段自动填充

            // 1. 插入数据
            Order order1 = new Order();
            order1.setOrderNo("ORDER20260225");
            order1.setUserId(user.getId()); // 关联第一集插入的用户
            orderDao.save(order1);

            log.info("=== 开始联表演示 ===");
            // 2. 联表分页查询
            OrderCond cond = OrderCond.builder().name("张").orderNo("ORDER20260225").build();
            Page<OrderVO> page = orderDao.pageJoin(cond);
            log.info("联表分页总数: {}", page.getRowCount());
            page.getDataList().forEach(vo -> log.info("联表结果: {}", vo));

        };
    }
}