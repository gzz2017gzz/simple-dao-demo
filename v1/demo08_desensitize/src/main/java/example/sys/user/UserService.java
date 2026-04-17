package example.sys.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.common.desensitize.Desensitize;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	@Desensitize(types = { "phone", "idCard" }, fields = { "phone", "idCard" })
	public List<User> list(UserCond cond) {
		return userDao.list(cond);
	}

	public User save(User user) {
		return userDao.save(user);
	}

	public User findById(Long id) {
		return userDao.findById(id);
	}
}