package com.example.demo.notice;

import org.springframework.stereotype.Repository;

import com.example.demo.common.DataAuth;
import com.example.demo.notice.vo.NoticeVO;
import com.simple.common.base.BaseDao;
import com.simple.common.base.Page;

@Repository
public class NoticeDao extends BaseDao<Notice> {

	private static final String SQL = """
            SELECT t.id, t.title, t.content, t.receiver, u.name publisher_name
            FROM sys_notice t
            LEFT JOIN sys_user u ON t.receiver = u.id
            """;
	@DataAuth(userField = "t.receiver")
	public Page<NoticeVO> pageJoin(NoticeCond cond) {
		return page(SQL, cond, NoticeVO.class);
	}
}