package com.example.demo.notice;

import com.simple.common.base.BaseCondition;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NoticeCond extends BaseCondition {
	@Override
	protected void addCondition() {
		and("id >", idGe);
	}
	private Long idGe;
}