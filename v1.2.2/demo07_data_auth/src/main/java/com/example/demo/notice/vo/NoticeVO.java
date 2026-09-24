package com.example.demo.notice.vo;

import com.example.demo.notice.Notice;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class NoticeVO extends Notice {
	private String publisherName; // 发布人姓名
}