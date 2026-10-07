package example;

import example.goods.GoodsCond;
import example.goods.GoodsDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

/**
 * 推荐OpenJdk21+(LTS)
 */
@Slf4j
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public String run(GoodsDao goodsDao) {
        log.info("============================================================");
        log.info("【Java版】【案例-04】多表联查 + 复杂条件");
        log.info("============================================================");
        log.info("");
        LocalDateTime start = LocalDateTime.of(2026, 2, 1, 0, 0, 0);
        LocalDateTime end = LocalDateTime.of(2026, 2, 3, 23, 59, 59);
        log.info("1. 查询商品（条件：用户名含'张'，订单创建时间 2026-02-01 至 2026-02-03，商品名在手机、耳机中）");
        goodsDao.listJoin(GoodsCond.builder().userName("张").createTimeStart(start).createTimeEnd(end).goodsNames(new String[]{"手机", "耳机"}).build())
                .forEach(i -> log.info("   => 结果: {}", i));

        log.info("2. 查询商品（条件：订单创建时间 >= 2026-02-03）");
        start = LocalDateTime.of(2026, 2, 3, 0, 0, 0);
        goodsDao.listJoin(GoodsCond.builder().createBetweenStart(start).build()).forEach(vo -> log.info("   => 结果: {}", vo));

        log.info("3. 查询商品（条件：商品名 = '手机'）");
        goodsDao.listJoin(GoodsCond.builder().goodsNames(new String[]{"手机"}).build()).forEach(vo -> log.info("   => 结果: {}", vo));
        return "";
    }
}