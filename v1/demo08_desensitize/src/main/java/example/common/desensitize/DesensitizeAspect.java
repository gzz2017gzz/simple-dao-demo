package example.common.desensitize;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.List;

@Aspect
@Component
public class DesensitizeAspect {

    @Around("execution(public * example.sys..*.*Service.*(..)) && @annotation(anno)")
    public Object around(ProceedingJoinPoint joinPoint, Desensitize anno) throws Throwable {
        Object result = joinPoint.proceed();
        if (result instanceof List<?> list) {
            for (Object item : list) {
                for (int i = 0; i < anno.fields().length; i++) {
                    String fieldName = anno.fields()[i];
                    String type = anno.types()[i];
                    Field field = FieldUtils.getField(item.getClass(), fieldName, true);
                    if (field != null) {
                        maskField(item, field, type);
                    }
                }
            }
        }
        return result;
    }

    private void maskField(Object item, Field field, String type) throws IllegalAccessException {
        String original = (String) FieldUtils.readField(field, item, true);
        if (original == null) return;

        String masked = switch (type) {
            case "phone" -> maskPhone(original);
            case "idCard" -> maskIdCard(original);
            default -> original;
        };
        FieldUtils.writeField(field, item, masked, true);
    }

    private String maskPhone(String phone) {
        return phone.substring(0, 3) + "****" + phone.substring(7);
    }

    private String maskIdCard(String idCard) {
        return idCard.substring(0, 6) + "********" + idCard.substring(14);
    }
}