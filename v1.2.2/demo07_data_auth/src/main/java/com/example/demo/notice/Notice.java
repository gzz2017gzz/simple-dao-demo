package com.example.demo.notice;

import com.simple.common.base.annotation.Id;
import com.simple.common.base.annotation.Table;

import lombok.Data;

@Data
@Table("t_notice")
public class Notice {
	@Id
	private Long id;
	private String title;
	private String content;
	private Long receiver; // 接收人ID
}