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

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
public class DataAuthDemoTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void test01() throws Exception {
		log.info("============================================================");
		log.info("【Java版】【案例-07】 数据权限·多租户");
		log.info("============================================================");
		log.info("UserId=1001 查询结果:" + doRequest("1001"));
	}

	@Test
	public void test02() throws Exception {
		log.info("UserId=1002 查询结果:" + doRequest("1002"));
	}

	@Test
	public void test03() throws Exception {
		log.info("未带Header 查询结果:" + doRequest(""));
	}

	private String doRequest(String userId) throws Exception {
		var requestBuilder = post("/notice/page").contentType(MediaType.APPLICATION_JSON);
		requestBuilder.header("X-User-Id", userId);
		return mvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString();
	}
}