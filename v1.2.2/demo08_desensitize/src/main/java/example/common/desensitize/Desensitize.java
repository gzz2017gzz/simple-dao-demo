package example.common.desensitize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 脱敏注解，打在 Service 方法上，用于对返回的 List 结果进行字段脱敏
 * types 和 fields 数组长度需一致，一一对应
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Desensitize {
    /** 脱敏类型数组，如 "phone"、"idCard" */
    String[] types();
    /** 对应的字段名数组，如 "phone"、"idCard" */
    String[] fields();
}