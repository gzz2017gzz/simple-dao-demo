package com.example.demo.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.simple.common.base.BaseCondition;

import jakarta.servlet.http.HttpServletRequest;

@Aspect
@Component
public class DataAuthAspect {

	@Autowired
	private HttpServletRequest request;

	@Before("@annotation(auth)")
	public void beforeQuery(JoinPoint point, DataAuth auth) {
		BaseCondition cond = (BaseCondition) point.getArgs()[0];
		String userId = request.getHeader(Const.USER_ID);
		String and = " AND " + auth.userField() + " IN (" + userId + ",0)";
		cond.setExtendCondition(and);
	}
}