package com.wk.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wk.mybatis.inter.IUserOperation;
import com.wk.mybatis.model.User;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	IUserOperation userMapper;
	
	@RequestMapping("/list")
	public ModelAndView listall(HttpServletRequest request,HttpServletResponse response){
		List<User> users = userMapper.selectUserList("jacky");
		ModelAndView modelAndView = new ModelAndView("list");
		modelAndView.addObject("users", users);

		return modelAndView;
	}
}
