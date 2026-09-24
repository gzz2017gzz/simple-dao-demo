package com.example.demo.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.notice.vo.NoticeVO;
import com.simple.common.base.Page;

@Service
public class NoticeService {
	@Autowired
	private NoticeDao noticeDao;

	public Page<NoticeVO> page(NoticeCond cond) {
		return noticeDao.pageJoin(cond);
	}
}