package com.wk.mybatis.inter;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.wk.mybatis.model.User;

public interface IUserOperation {
//	@Select("select*from user where id=#{id}")
	public User selectUserByID(int id);
	public List<User>selectUserList(String userName);
	public void addUser(User user);
}
