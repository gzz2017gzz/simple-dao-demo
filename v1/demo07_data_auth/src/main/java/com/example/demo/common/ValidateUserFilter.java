package com.example.demo.common;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.Nonnull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ValidateUserFilter extends OncePerRequestFilter {

	@Autowired
	public ObjectMapper mapper;
	private static final String MESSAGE = "header中没有传入用户主键";

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, @Nonnull FilterChain filterChain) throws ServletException, IOException {
		String userId = request.getHeader(Const.USER_ID);
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-Type", "application/json");
		if (!StringUtils.hasLength(userId)) {
			log.error("{} ", MESSAGE);
			response.getWriter().write(mapper.writeValueAsString(Map.of("msg", MESSAGE, "code", 500)));
			return;
		}
		filterChain.doFilter(request, response);
	}

}
