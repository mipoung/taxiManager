package com.taxiManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taxiManager.service.MainService;
import com.taxiManager.vo.CarInfoVO;
import com.taxiManager.vo.DriveInfoVO;
import com.taxiManager.vo.UserVO;

@Controller
public class MainController {
	
	@Autowired
	MainService mainService;
	
	@GetMapping("/")
	public String mainPage(Model model) {
		System.out.println(" ===================== 메인페이지 실행 ===================== ");
//		List<UserVO> userInfUserVO = mainService.mainList(userId);
		List<CarInfoVO> userInfo = mainService.mainList();
		System.out.println(userInfo.toString());
		
		if(userInfo.isEmpty()) {
			System.out.println("리스트가 비어있어요");
		} else {
			System.out.println("값이 있어요");
		}
		
		model.addAttribute("userInfo", userInfo);
		
		return "views/main/index.html";
	}
	
	@GetMapping("/signIn")
	public String mainLogin(Model model) {
		
		System.out.println("로그인 페이지 실행");
		return "views/user/signIn.html";
	}
	
	@GetMapping("/signUp")
	public String mainSignUp(Model model) {
		
		System.out.println("회원가입 페이지 실행");
		return "views/user/signUp.html";
	}
	
	@GetMapping("/infoVw")
	public String infoVw(Model model) {
		
		return "views/common/infoVw.html";
	}
	
	@PostMapping("/check_duplicate_id")
	@ResponseBody
	public String checkId(@RequestParam("id") String id) {
		System.out.println(id +"가져오기");
		return mainService.checkDuplicateId(id);
		
	}
	
	

	
	
}
