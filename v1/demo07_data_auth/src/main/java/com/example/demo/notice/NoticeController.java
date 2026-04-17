package com.example.demo.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.notice.vo.NoticeVO;
import com.simple.common.base.Page;

@RestController
@RequestMapping("notice")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	@PostMapping("page")
	public Page<NoticeVO> page(NoticeCond cond) {
		return noticeService.page(cond);
	}
	
}