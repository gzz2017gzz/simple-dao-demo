package com.gzz.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gzz.config.Change;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	@Change("db1")
	public void initDb1() { userDao.init(); }

	@Change("db2")
	public void initDb2() { userDao.init(); }

	@Change("db1")
	public void saveToDb1(User user) { userDao.save(user); }

	@Change("db2")
	public void saveToDb2(User user) { userDao.save(user); }

	@Change("db1")
	public List<User> listFromDb1() { return userDao.list(UserCond.builder().idGe(1000L).build()); }

	@Change("db2")
	public List<User> listFromDb2() { return userDao.list(UserCond.builder().idGe(2000L).build()); }

}