package com.taxiManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.taxiManager.service.MainService;
import com.taxiManager.vo.UserVO;

@Controller
public class MainController {
	
	@Autowired
	MainService mainService;
	
	@GetMapping("/")
	public String mainPage(Model model) {
		
		List<UserVO> list = mainService.mainList();
		model.addAttribute("list", list);
		
		return "index";
	}
	
	
}
