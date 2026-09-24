package com.gzz.user;

import com.simple.common.base.BaseCondition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 【用户表】查询条件
 **/
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCond extends BaseCondition {

	/**
	 * 拼加条件
	 **/
	@Override
	protected void addCondition() {
		and("name LIKE", name, 3);
		and("id >=", idGe);
		in("id", ids);
	}

	private String name;
	private Long[] ids;
	private Long idGe;
}