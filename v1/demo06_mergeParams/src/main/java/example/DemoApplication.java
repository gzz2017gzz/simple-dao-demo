package example;

import example.report.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.LocalDateTime;

/**
 * SimpleDAO 第06集 「mergeParams参数合并」测试类
 * 3大场景覆盖：全条件组合、缺时间条件、缺业务条件、单条件对比
 */
@Slf4j
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    @Autowired
    private ReportDao reportDao;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("===== SimpleDAO 第06集 mergeParams参数合并 演示开始 =====");
        // 基础测试数据：时间范围（覆盖所有测试数据）
        LocalDateTime start = LocalDateTime.of(2026, 2, 1, 0, 0, 0);
        LocalDateTime end = LocalDateTime.of(2026, 2, 4, 23, 59, 59);

        // 初始化3个独立条件类（可灵活组合，无耦合）
        TimeCond timeCond = TimeCond.builder().orderTimeStart(start).orderTimeEnd(end).build();
        BizCond bizCond = BizCond.builder().goodsName("手").priceMin(1000.0).build();
        ValidCond validCond = ValidCond.builder().userName("张").build();

        // ================= 场景1：3个条件全组合（最典型场景） =================
        log.info("\n【场景1】3条件全组合：时间范围+商品筛选+用户筛选");
        reportDao.reportGoodsByMerge(timeCond, bizCond, validCond).forEach(vo ->
                log.info("商品：{} | 订单数：{} | 销售额：{} | 平均价格：{}", vo.getGoodsName(), vo.getOrderCount(), vo.getTotalAmount(), vo.getAvgPrice()));

        // ================= 场景2：缺时间条件（仅业务+用户筛选） =================
        log.info("\n【场景2】缺时间条件：商品筛选+用户筛选");
        reportDao.reportGoodsByMerge(new TimeCond(), bizCond, validCond).forEach(vo ->
                log.info("商品：{} | 销售额：{}", vo.getGoodsName(), vo.getTotalAmount()));

        // ================= 场景3：单条件对比（兼容第5集用法） =================
        log.info("\n【场景3】单条件查询（兼容第5集）：仅商品筛选");
        reportDao.reportGoods(bizCond).forEach(vo ->
                log.info("商品：{} | 销售额：{}", vo.getGoodsName(), vo.getTotalAmount()));

        log.info("===== SimpleDAO 第06集 mergeParams参数合并 演示结束 =====");
    }
}