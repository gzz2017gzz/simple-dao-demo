package example;

import example.report.ReportCond;
import example.report.ReportDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

/**
 * SimpleDAO 第05集 报表场景演示 核心：单条件类按需传值、全下划线SQL、固定分组、无分页 推荐OpenJdk21+(LTS)
 */
@Slf4j
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public String run(ReportDao reportDao) {
        log.info("============================================================");
        log.info("【Java版】【案例-05】报表聚合（GROUP BY + 聚合函数）");
        log.info("============================================================");
        log.info("");

        LocalDateTime start = LocalDateTime.of(2026, 2, 1, 0, 0, 0);
        LocalDateTime end = LocalDateTime.of(2026, 2, 4, 23, 59, 59);

        log.info("1. 按商品分组统计（时间范围 2026-02-01 至 2026-02-04）");
        reportDao.reportGoods(ReportCond.builder().orderTimeStart(start).orderTimeEnd(end).build()).forEach(i -> log.info("   => 结果: {}", i));

        log.info("2. 按商品分组统计（时间范围 + 商品名含'手' + 价格 ≥ 1000）");
        reportDao.reportGoods(ReportCond.builder().orderTimeStart(start).orderTimeEnd(end).goodsName("手").priceMin(1000.0).build()).forEach(i -> log.info("   => 结果: {}", i));

        log.info("3. 按用户分组统计（时间范围 + 用户名含'张'）");
        reportDao.reportUser(ReportCond.builder().orderTimeStart(start).orderTimeEnd(end).userName("张").build()).forEach(i -> log.info("   => 结果: {}", i));

        log.info("4. 按用户分组统计（仅有效数据筛选）");
        reportDao.reportUser(ReportCond.builder().build()).forEach(i -> log.info("   => 结果: {}", i));
        return "";
    }
}