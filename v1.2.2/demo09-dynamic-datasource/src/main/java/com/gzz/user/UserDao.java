package com.gzz.user;

import org.springframework.stereotype.Repository;

import com.simple.common.base.BaseDao;

@Repository
public class UserDao extends BaseDao<User> {

	public void init() {
		String sql = "CREATE TABLE sys_user (id BIGINT PRIMARY KEY, name VARCHAR(50), password VARCHAR(50))";
		jdbc.execute(sql);
	}
}