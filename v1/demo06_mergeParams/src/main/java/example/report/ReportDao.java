package example.report;

import com.simple.common.base.BaseDao;
import example.goods.Goods;
import org.springframework.stereotype.Repository;
import java.util.List;
import static com.simple.common.base.BaseCondition.mergeParams;

/**
 * 核心DAO：多位置条件嵌入+ mergeParams参数聚合
 */
@Repository
public class ReportDao extends BaseDao<Goods> {

    /**
     * 核心方法1：按商品分组统计（子查询+多位置条件+mergeParams）
     */
    public List<ReportGoodsVo> reportGoodsByMerge(TimeCond timeCond, BizCond bizCond, ValidCond validCond) {
        // SQL加号拼接：3个条件片段分别嵌入 订单子查询、主查询、用户子查询
        String sql =
                "SELECT t.goods_name, COUNT(o.id) order_count, COUNT(t.id) goods_count,SUM(t.price) total_amount,AVG(t.price) avg_price FROM t_goods t " +
                "JOIN (SELECT id, user_id FROM t_order WHERE dr=0 " + timeCond.and() + ") o ON t.order_id = o.id " +
                "WHERE t.dr = 0 " + bizCond.and() +
                "AND o.user_id IN (SELECT id FROM t_user " + validCond.where() + ") GROUP BY t.goods_name";
        return list(sql, ReportGoodsVo.class, mergeParams(timeCond, bizCond, validCond));
    }


    // ========== 兼容第5集单条件查询方法==========
    public List<ReportGoodsVo> reportGoods(BizCond bizCond) {
        String sql =
                "SELECT t.goods_name,COUNT(o.id) order_count,COUNT(t.id) goods_count,SUM(t.price) total_amount,AVG(t.price) avg_price FROM t_goods t " +
                        "JOIN t_order o ON t.order_id = o.id " +
                        "JOIN t_user u ON o.user_id = u.id " +
                        "WHERE t.dr=0 AND o.dr=0 AND u.dr=0 " + bizCond.and() +
                        "GROUP BY t.goods_name";
        return list(sql, ReportGoodsVo.class, bizCond.array());
    }
}