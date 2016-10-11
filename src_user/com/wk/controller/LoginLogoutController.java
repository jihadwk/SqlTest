package com.wk.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wk.entity.Account;
import com.wk.mybatis.inter.IAccountOperation;

@Controller
@RequestMapping("/auth")
public class LoginLogoutController {
	@Autowired
	private IAccountOperation acc;
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String getLoginPage(@RequestParam(value="error",required=false)boolean error,ModelMap model){//@RequestParam绑定请求参数error到变量error，required=false参数不存在也不会报错
		System.out.println("receive request to show login page");
		if (error==true) {
			model.put("error", "you have entered an invalid username or password!");
		}else {
			model.put("error", "");
		}
		return "loginpage";
	}
	@RequestMapping(value="/denied",method=RequestMethod.GET)
	public String getDeniedPage(){
		System.out.println("receive request to show denied page");
		return "deniedpage";
	}
//	@RequestMapping(value="/check",method=RequestMethod.POST)
//	public String check(@RequestParam(value="j_username",required=false)String username,@RequestParam(value="j_password",required=false)String password){
//		System.out.println(username+":"+password);
//				return "deniedpage";
//		
//	}
//	@RequestMapping(value="/check",method=RequestMethod.POST)
//	public String check(String j_username,String j_password,ModelMap map){ //字段名必须保持一致，可以接收对应参数
//		System.out.println(j_username+":"+j_password);
//		Account account = acc.queryAccountByUsername(j_username);
//		System.out.println(account);
//		if (account!=null && account.getPassword().equals(j_password)) {
//			return "commonpage";
//		}
//		map.put("error", "you have entered an invalid username or password!");
//		return "loginpage";
//		
//	}
}
