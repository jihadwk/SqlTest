package com.wk.mybatis.inter;

import com.wk.entity.Account;

public interface IAccountOperation {
	public Account queryAccountByUsername(String username);
}
