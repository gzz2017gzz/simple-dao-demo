package example;

import com.simple.common.base.Page;
import example.order.OrderCond;
import example.order.OrderDao;
import example.order.OrderVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * 推荐OpenJdk21(LTS)+
 */
@Slf4j
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public String demo(OrderDao orderDao) {
        log.info("============================================================");
        log.info("【Java版】【案例-02】联表查询（订单 + 用户）");
        log.info("============================================================");
        log.info("1. 联表分页查询（条件：用户名含'张'，订单号=ORD2026001）");
        Page<OrderVO> page = orderDao.pageJoin(OrderCond.builder().userName("张").orderNos(new Object[]{"ORD2026001", "ORD2026003", "ORD2026004"}).build());
        log.info("   => 总记录数: {}", page.getRowCount());
        page.getDataList().forEach(vo -> log.info("   => 第{}页数据: {}", page.getPage(), vo));
        return "";
    }
}