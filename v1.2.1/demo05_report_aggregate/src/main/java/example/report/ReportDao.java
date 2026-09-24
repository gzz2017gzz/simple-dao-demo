package example.report;

import com.simple.common.base.BaseDao;
import example.goods.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 报表DAO
 */
@Repository
public class ReportDao extends BaseDao<Goods> {

	/**
	 * 按商品分组统计
	 */
	public List<ReportGoodsVo> reportGoods(ReportCond cond) {
		String sql = """
				SELECT t.goods_name, COUNT(o.id) order_count, COUNT(t.id) goods_count, SUM(t.price) total_amount, AVG(t.price) avg_price
				FROM t_goods t
				JOIN t_order o ON t.order_id = o.id
				JOIN t_user u ON o.user_id = u.id""" + cond.where() + " GROUP BY t.goods_name";
		return list(true, sql, ReportGoodsVo.class, cond.array());
	}

	/**
	 * 按用户分组统计
	 */
	public List<ReportUserVo> reportUser(ReportCond cond) {
		String sql = """
				SELECT u.id,u.name,COUNT(o.id) order_count,COUNT(t.id) goods_count,SUM(t.price) total_amount
				FROM t_goods t
				JOIN t_order o ON t.order_id = o.id
				JOIN t_user u ON o.user_id = u.id WHERE t.dr IN (0,1)""" + cond.and() + " GROUP BY u.id, u.name";
		return list(true, sql, ReportUserVo.class, cond.array());
	}
}