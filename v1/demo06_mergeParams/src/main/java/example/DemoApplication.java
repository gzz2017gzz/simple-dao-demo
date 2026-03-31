package example;

import example.report.BizCond;
import example.report.ReportDao;
import example.report.TimeCond;
import example.report.ValidCond;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

/**
 * SimpleDAO 第06集 「mergeParams参数合并」测试类 3大场景覆盖：全条件组合、缺时间条件、缺业务条件、单条件对比
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
        log.info("【Java版】【案例-06】mergeParams 多组条件合并");
        log.info("============================================================");
        log.info("");

        // 基础测试数据：时间范围（覆盖所有测试数据）
        LocalDateTime start = LocalDateTime.of(2026, 2, 1, 0, 0, 0);
        LocalDateTime end = LocalDateTime.of(2026, 2, 4, 23, 59, 59);

        // 初始化3个独立条件类（可灵活组合，无耦合）
        TimeCond timeCond = TimeCond.builder().orderTimeStart(start).orderTimeEnd(end).build();
        BizCond bizCond = BizCond.builder().goodsName("手").priceMin(1000.0).build();
        ValidCond validCond = ValidCond.builder().userName("张").build();

        // 场景1：3个条件全组合
        log.info("1. 全条件组合（时间范围 + 商品名含'手' + 价格 ≥ 1000 + 用户名含'张'）");
        reportDao.reportGoodsByMerge(timeCond, bizCond, validCond).forEach(vo -> log.info("   => 结果: {}", vo));

        // 场景2：缺时间条件（仅业务+用户筛选）
        log.info("2. 缺时间条件（商品名含'手' + 价格 ≥ 1000 + 用户名含'张'）");
        reportDao.reportGoodsByMerge(new TimeCond(), bizCond, validCond).forEach(vo -> log.info("   => 结果: {}", vo));

        // 场景3：单条件（仅商品筛选）
        log.info("3. 单条件查询（商品名含'手' + 价格 ≥ 1000）");
        reportDao.reportGoods(bizCond).forEach(vo -> log.info("   => 结果: {}", vo));

        return "";
    }
}