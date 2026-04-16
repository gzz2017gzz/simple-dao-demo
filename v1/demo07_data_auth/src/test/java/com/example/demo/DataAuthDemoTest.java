package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.notice.NoticeCond;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
public class DataAuthDemoTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	public void test01() throws Exception {
		// 1. 模拟登录 userId=1001，查询公告
		log.info("UserId=1001 查询结果:\n" + doRequest("/notice/page", new NoticeCond(), "1001"));
	}

	@Test
	public void test02() throws Exception {
		// 2. 模拟登录 userId=1002，查询公告
		log.info("UserId=1002 查询结果:\n" + doRequest("/notice/page", new NoticeCond(), "1002"));
	}

	@Test
	public void test03() throws Exception {
		// 3. 模拟未登录（不带Header），查询公告
		log.info("未带Header 查询结果:\n" + doRequest("/notice/page", new NoticeCond(), null));
	}

	private String doRequest(String url, Object requestBody, String userId) throws Exception {
		var requestBuilder = post(url).contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(requestBody));

		if (userId != null) {
			requestBuilder.header("X-User-Id", userId);
		}

		return mvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString();
	}
}