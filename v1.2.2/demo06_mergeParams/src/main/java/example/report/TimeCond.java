package example.report;

import com.simple.common.base.BaseCondition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TimeCond extends BaseCondition {
    private LocalDateTime orderTimeStart; // 订单创建开始时间
    private LocalDateTime orderTimeEnd;   // 订单创建结束时间

    @Override
    protected void addCondition() {
        add("AND create_time >= ?", orderTimeStart);
        add("AND create_time <= ?", orderTimeEnd);
    }
}