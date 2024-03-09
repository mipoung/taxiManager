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
import com.taxiManager.vo.DriveInfoVO;
import com.taxiManager.vo.UserVO;

@Controller
public class MainController {
	
	@Autowired
	MainService mainService;
	
	@GetMapping("/")
	public String mainPage(Model model) {
		
		System.out.println("메인페이지 실행");
		return "views/main/index.html";
	}
	
	@GetMapping("/signIn")
	public String mainLogin(Model model) {
		
		System.out.println("로그인 페이지 실행");
		return "views/common/signIn.html";
	}
	
	
	@GetMapping("/driveInfoInsert")
	public String driveInfoInsert(Model model) {
		
		System.out.println("운행정보 입력 페이지 실행");
		
		return "views/common/driveInfoInsert.html";
	}
	
	@PostMapping("/infoInsert")
	public String infoInsert(@ModelAttribute DriveInfoVO driveInfoVO) {
		System.out.println("뷰에서 받아온 값 확인 : \n" + driveInfoVO.getNowKm() + "\n" +driveInfoVO.getTodayIncome() + "\n"+ driveInfoVO.getTodayFuel() + "\n"+ driveInfoVO.getTodayMemo());
		// 입력 받고 운행정보 보기 페이지로 이동
		return "views/common/driveInfo.html";
	}
	
	
	@GetMapping("/driveInfo")
	public String driveInfo(Model model) {
		
		System.out.println("운행정보 보기 페이지 실행");
		
		List<UserVO> list = mainService.mainList();
		model.addAttribute("list", list);
		System.out.println(list.toString());
		
		return "views/common/driveInfo.html";
	}
	
	
	@GetMapping("/driveStatistics")
	public String driveStatistics(Model model) {
		
		System.out.println("운행통계 보기 페이지 실행");
		return "views/common/driveStatistics.html";
	}
	
	@PostMapping("/check_duplicate_id")
	@ResponseBody
	public String checkId(@RequestParam("id") String id) {
		System.out.println(id +"가져오기");
		return mainService.checkDuplicateId(id);
		
	}

}
