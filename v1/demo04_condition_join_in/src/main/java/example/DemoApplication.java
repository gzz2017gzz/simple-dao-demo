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
 * ★★推荐OpenJdk21+(LTS)★★
 * 
 * @第04集 SimpleDAO联表、条件高阶
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
		log.info("============================================================");
		log.info("【Java版】【案例-04】多表联查 + 复杂条件");
		log.info("============================================================");
		log.info("");

		log.info("1. 查询商品（条件：用户名含'张'，订单创建时间 2026-02-01 至 2026-02-03，商品名在手机、耳机中）");
		GoodsCond cond1 = GoodsCond.builder().userName("张").createTimeStart(LocalDateTime.of(2026, 2, 1, 0, 0, 0)).createTimeEnd(LocalDateTime.of(2026, 2, 3, 23, 59, 59)).goodsNames(new String[] { "手机", "耳机" }).build();
		List<GoodsVo> list1 = goodsDao.listJoin(cond1);
		for (GoodsVo vo : list1) {
			log.info("   => 结果: {}", vo);
		}

		log.info("2. 查询商品（条件：订单创建时间 >= 2026-02-03）");
		GoodsCond cond2 = GoodsCond.builder().createBetweenStart(LocalDateTime.of(2026, 2, 3, 0, 0, 0)).build();
		List<GoodsVo> list2 = goodsDao.listJoin(cond2);
		for (GoodsVo vo : list2) {
			log.info("   => 结果: {}", vo);
		}

		log.info("3. 查询商品（条件：商品名 = '手机'）");
		GoodsCond cond3 = GoodsCond.builder().goodsNames(new String[] { "手机" }).build();
		List<GoodsVo> list3 = goodsDao.listJoin(cond3);
		for (GoodsVo vo : list3) {
			log.info("   => 结果: {}", vo);
		}
	}
}