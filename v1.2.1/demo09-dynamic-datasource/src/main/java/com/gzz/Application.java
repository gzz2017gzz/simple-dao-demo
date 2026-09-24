package com.gzz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.gzz.user.User;
import com.gzz.user.UserService;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
    @Autowired
    private UserService service;
	
	@PostConstruct
	public void init() {
		service.initDb1();
		service.initDb2();
		service.saveToDb1(User.builder().name("张三").password("12345").build());
		service.saveToDb1(User.builder().name("李四").password("12346").build());
		service.saveToDb2(User.builder().name("王五").password("12347").build());
		service.listFromDb1().forEach(i->log.info("user={}",i));
		service.listFromDb2().forEach(i->log.info("user={}",i));
	}
}