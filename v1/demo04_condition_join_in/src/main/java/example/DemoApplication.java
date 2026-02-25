package example;

import example.goods.GoodsCond;
import example.goods.GoodsDao;
import example.goods.GoodsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

/**
 * SimpleDAO第四集 核心演示主类
 * Spring生态注入 + SLF4J日志 + 无硬编码getBean
 */
@Slf4j
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private GoodsDao goodsDao;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("===== SimpleDAO第四集 三表联查演示开始 =====");

        // 测试1：核心场景（时间范围+关联表IN+用户名模糊查询）
        log.info("【测试1】核心条件组合查询（用户名含张+时间范围+商品IN）");
        GoodsCond cond1 = GoodsCond.builder()
                .userName("张")
                .createTimeStart(LocalDateTime.of(2026, 2, 1, 0, 0, 0))
                .createTimeEnd(LocalDateTime.of(2026, 2, 3, 23, 59, 59))
                .goodsNames(new String[]{"手机", "耳机"})
                .build();
        List<GoodsVo> list1 = goodsDao.listJoin(cond1);
        list1.forEach(vo -> log.info("结果：{} - {} - {}", vo.getUserName(), vo.getGoodsName(), vo.getOrderNo()));

        // 测试2：SimpleDAO推荐灵活时间写法（仅传开始时间，自动处理null）
        log.info("【测试2】灵活时间条件查询（仅2026-02-03后创建的订单）");
        GoodsCond cond2 = GoodsCond.builder()
                .createBetweenStart(LocalDateTime.of(2026, 2, 3, 0, 0, 0))
                .build();
        List<GoodsVo> list2 = goodsDao.listJoin(cond2);
        list2.forEach(vo -> log.info("结果：{} - {}", vo.getUserName(), vo.getGoodsName()));

        // 测试3：关联表IN单独查询（仅查买过手机的用户）
        log.info("【测试3】关联表子查询IN查询（仅买过手机的用户）");
        GoodsCond cond3 = GoodsCond.builder()
                .goodsNames(new String[]{"手机"})
                .build();
        List<GoodsVo> list3 = goodsDao.listJoin(cond3);
        list3.forEach(vo -> log.info("结果：买过手机的用户 - {}", vo.getUserName()));

        log.info("===== SimpleDAO第四集 三表联查演示结束 =====");
    }
}