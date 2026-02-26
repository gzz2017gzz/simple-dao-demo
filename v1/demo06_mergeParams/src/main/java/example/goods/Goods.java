package example.goods;


import com.simple.common.base.annotation.Id;
import com.simple.common.base.annotation.Table;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Setter
@Getter
@Table("t_goods")
public class Goods {
    @Id
    private Long id;
    private Long orderId;
    private String goodsName;
    private BigDecimal price;
    private Byte dr;
}