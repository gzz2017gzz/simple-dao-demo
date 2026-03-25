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

/**
 * ★★推荐OpenJdk21+(LTS)★★
 */
@Slf4j
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserDao userDao) {
        return args -> {
            log.info("============================================================");
            log.info("【Java版】【案例-01】单表 CRUD + 审计字段 + 逻辑删除");
            log.info("============================================================");

            log.info("1. 插入数据");
            User user = new User();
            user.setName("张三");
            user.setAge(25);
            user.setEmail("zhangsan@example.com");
            userDao.save(user);
            log.info("   => 插入成功，ID: {}, create_time: {}, create_by: {}", user.getId(), user.getCreateTime(), user.getCreateBy());

            log.info("2. 按 ID 查询");
            User u = userDao.findById(user.getId());
            log.info("   => 查询结果: {}", u);

            log.info("3. 条件分页查询（条件：name like '%张%', age between 20 and 30）");
            UserCond cond = UserCond.builder().name("张").ageMax(30).ageMin(20).build();
            Page<User> page = userDao.page(cond);
            log.info("   => 总记录数: {}", page.getRowCount());
            page.getDataList().forEach(item -> log.info("   => 第{}页数据: {}", page.getPage(), item));

            log.info("4. 更新数据");
            u.setAge(26);
            userDao.update(u);
            User updated = userDao.findById(u.getId());
            log.info("   => 更新完成，update_time: {}, update_by: {}", updated.getUpdateTime(), updated.getUpdateBy());

            log.info("5. 逻辑删除");
            userDao.delete(u.getId());
            log.info("   => 删除操作执行（逻辑删除 dr=1）");

            log.info("6. 查询所有记录（包括已删除的）");
            userDao.list(new UserCond()).forEach(item -> log.info("   => 结果: {}", item));
        };
    }
}