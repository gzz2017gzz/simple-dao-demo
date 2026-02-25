package example.goods;


import com.simple.common.base.BaseDao;
import com.simple.common.base.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GoodsDao extends BaseDao<Goods> {
    // 三表联查核心方法 - 全局唯一查询方法，承接所有条件
    private final static String SQL = """
            SELECT t.id goods_id,t.goods_name,t.price,o.id order_id,o.order_no,u.id user_id,u.name user_name,u.age
            FROM t_goods t
            JOIN t_order o ON t.order_id=o.id AND o.dr=0
            JOIN t_user u ON o.user_id=u.id AND u.dr=0""";

    // 三表联查列表 - 入参为自定义条件类，返回自定义VO
    public List<GoodsVo> listJoin(GoodsCond cond) {
        return list(SQL, cond, GoodsVo.class);
    }

    public Page<GoodsVo> pageJoin(GoodsCond cond) {
        return page(SQL, cond, GoodsVo.class);
    }
}