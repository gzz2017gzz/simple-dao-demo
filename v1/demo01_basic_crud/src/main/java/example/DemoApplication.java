package example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.simple.common.base.Page;

import example.demo.User;
import example.demo.UserCond;
import example.demo.UserDao;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserDao userDao) {
        return args -> {
            log.info("=== SimpleDAO 演示（含审计字段） ===");

            // 1. 插入数据
            User user = new User();
            user.setName("张三");
            user.setAge(25);
            user.setEmail("zhangsan@example.com");
            userDao.save(user);  // ID 自动生成，审计字段自动填充
            log.info("插入成功，ID: {}, createTime: {}, createBy: {}", 
                     user.getId(), user.getCreateTime(), user.getCreateBy());

            // 2. 根据ID查询
            User u = userDao.findById(user.getId());
            log.info("查询结果: {}", u);

            // 3. 条件分页查询
            UserCond cond = new UserCond();
            cond.setName("张");
            cond.setAgeMin(20);
            cond.setAgeMax(30);
            cond.setPage(1);
            cond.setSize(10);
            Page<User> page = userDao.page(cond);
            log.info("分页结果总数: {}", page.getRowCount());
            page.getDataList().forEach(item -> log.info("{}", item));

            // 4. 更新
            u.setAge(26);
            userDao.update(u);  // 自动填充 updateTime、updateBy
            log.info("更新完成，updateTime: {}, updateBy: {}", u.getUpdateTime(), u.getUpdateBy());

            // 5. 逻辑删除（dr 字段自动设为 1）
            userDao.delete(u.getId());
            log.info("删除操作执行，记录被逻辑删除（dr=1）");

            // 6. 再次查询所有记录（包括逻辑删除的）
            log.info("删除后查询所有记录（不自动过滤 dr）：");
            userDao.list(new UserCond()).forEach(item -> log.info("{}", item));
        };
    }
}