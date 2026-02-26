package example;

import example.report.ReportGoodsVo;
import example.report.ReportUserVo;
import example.report.ReportCond;
import example.report.ReportDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.LocalDateTime;
import java.util.List;

/**
 * SimpleDAO 第05集 报表场景演示
 * 核心：单条件类按需传值、无AS全下划线SQL、固定分组、无分页
 * 推荐OpenJdk21+(LTS)
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
        log.info("===== SimpleDAO 第05集 报表场景演示开始 =====");
        // 基础时间条件：覆盖所有测试数据
        LocalDateTime start = LocalDateTime.of(2026, 2, 1, 0, 0, 0);
        LocalDateTime end = LocalDateTime.of(2026, 2, 4, 23, 59, 59);

        // 场景1：按商品分组 - 仅传时间条件（基础筛选）
        log.info("【场景1】按商品分组 - 仅时间筛选");
        ReportCond cond1 = ReportCond.builder()
                .orderTimeStart(start)
                .orderTimeEnd(end)
                .build();
        List<ReportGoodsVo> list1 = reportDao.reportGoods(cond1);
        list1.forEach(vo -> log.info("商品：{} | 订单数：{} | 销售额：{}",
                vo.getGoodsName(), vo.getOrderCount(), vo.getTotalAmount()));

        // 场景2：按商品分组 - 时间+商品名模糊+价格区间（多条件传值）
        log.info("【场景2】按商品分组 - 时间+商品名含手+价格≥1000");
        ReportCond cond2 = ReportCond.builder()
                .orderTimeStart(start)
                .orderTimeEnd(end)
                .goodsName("手")
                .priceMin(1000.0)
                .build();
        List<ReportGoodsVo> list2 = reportDao.reportGoods(cond2);
        list2.forEach(vo -> log.info("商品：{} | 销售额：{} | 平均价格：{}",
                vo.getGoodsName(), vo.getTotalAmount(), vo.getAvgPrice()));

        // 场景3：按用户分组 - 时间+用户名模糊（精准筛选）
        log.info("【场景3】按用户分组 - 时间+用户名含张");
        ReportCond cond3 = ReportCond.builder()
                .orderTimeStart(start)
                .orderTimeEnd(end)
                .userName("张")
                .build();
        List<ReportUserVo> list3 = reportDao.reportUser(cond3);
        list3.forEach(vo -> log.info("用户ID：{} | 用户名：{} | 订单数：{} | 总消费：{}",
                vo.getId(), vo.getName(), vo.getOrderCount(), vo.getTotalAmount()));

        // 场景4：按用户分组 - 无额外筛选（仅固定dr=0）
        log.info("【场景4】按用户分组 - 仅有效数据筛选");
        ReportCond cond4 = ReportCond.builder().build();
        List<ReportUserVo> list4 = reportDao.reportUser(cond4);
        list4.forEach(vo -> log.info("用户名：{} | 商品数：{} | 总消费：{}",
                vo.getName(), vo.getGoodsCount(), vo.getTotalAmount()));

        log.info("===== SimpleDAO 第05集 报表场景演示结束 =====");
    }
}