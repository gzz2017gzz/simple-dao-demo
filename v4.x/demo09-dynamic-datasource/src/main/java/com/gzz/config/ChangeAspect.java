package com.gzz.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * 数据源切换切面：方法执行前切数据源，执行后清理
 */
@Aspect
@Component
@Order(1)
@Slf4j
public class ChangeAspect {

	@Around("@annotation(change)")
	@SneakyThrows
	public Object around(ProceedingJoinPoint point, Change change) throws Throwable {
		log.info("switch datasource to [{}]", change.value());
		DataSourceHolder.set(change.value());
		try {
			return point.proceed();
		} finally {
			DataSourceHolder.clear();
		}
	}
}