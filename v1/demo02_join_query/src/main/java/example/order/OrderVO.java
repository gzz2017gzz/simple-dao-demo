package example.order;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class OrderVO extends Order {
    private String userName; // 对应u.name AS userName
}