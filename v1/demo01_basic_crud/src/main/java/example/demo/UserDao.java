package example.demo;

import org.springframework.stereotype.Repository;

import com.simple.common.base.BaseDao;

@Repository
public class UserDao extends BaseDao<User> {
    // 空类，所有单表 CRUD 自动拥有
}