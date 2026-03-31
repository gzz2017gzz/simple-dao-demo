package example;

import example.user.UserCond;
import example.user.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
    public String run(UserDao userDao) {
        log.info("============================================================");
        log.info("【Java版】【案例-03】条件进阶（IN + 子查询）");
        log.info("============================================================");

        log.info("1. 条件查询（条件： age in (20,25,30)）");
        log.info("   => 查询结果: ");
        userDao.page(UserCond.builder().ages(new Integer[]{25, 30, 28}).build()).getDataList().forEach(vo -> log.info("{}", vo));

        log.info("2. 条件查询（条件：age in (20,25,30), 且有订单）");
        log.info("   => 查询结果: ");
        userDao.page(UserCond.builder().ages(new Integer[]{25, 30, 28}).orderQuery(true).build()).getDataList().forEach(vo -> log.info("{}", vo));
        return "";
    }
}