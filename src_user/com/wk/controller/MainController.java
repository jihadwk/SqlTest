package com.wk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main")
public class MainController {
	/**
	 * 跳转到common页面
	 */
	@RequestMapping(value="/common",method=RequestMethod.GET)
	public String getCommonPage(){
		System.out.println("receive request to show common page");
		return "commonpage";
	}
	/**
	 * 跳转到adminpage页面
	 */
	@RequestMapping(value="/admin",method=RequestMethod.GET)
	public String getAdminPage(){
		System.out.println("receive request to show admin page");
		return "adminpage";
	}
}
