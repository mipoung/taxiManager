package com.taxiManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.taxiManager.service.DriveInfoService;
import com.taxiManager.vo.DriveInfoVO;
import com.taxiManager.vo.UserVO;

@Controller
public class DriveInfoController {
	
	@Autowired
	DriveInfoService driveInfoService;
	

	
	@GetMapping("/driveInfoInsert")
	public String driveInfoInsert(Model model) {
		int result = driveInfoService.driveInfoChk();
		// 운행정보 불러오기(이미 있는지 확인하기 위해서)
		System.out.println("운행정보 입력 페이지 실행 \n오늘 날짜로 입력된 값이 있는지 확인 : " + result);
		
		// 이미 해당 날짜에 입력된 값이 있으면 입력 안되고 해당하는 값 조회 페이지로 보내기
		if(result >= 1) {
			System.out.println("오늘 작성된 운행일지 있음");
			//return "redirect:/driveInfo";
			
		}
		
		
		return "views/common/driveInfoInsert.html";
	}
	
	@PostMapping("/infoInsert")
	public String infoInsert(@ModelAttribute DriveInfoVO driveInfoVO) {
		System.out.println("뷰에서 받아온 값 확인 : \n" + driveInfoVO.getNowKm() + "\n" +driveInfoVO.getTodayIncome() + "\n"+ driveInfoVO.getTodayFuel() + "\n"+ driveInfoVO.getTodayMemo());
		// 입력 받고 운행정보 보기 페이지로 이동
		int result = driveInfoService.infoInsert(driveInfoVO);
		System.out.println("입력된 값 개수 : " + result);
		
		return "redirect:/driveInfo";
	}
	
	
	@GetMapping("/driveInfo")
	public String driveInfo(Model model) {
		
		System.out.println("운행정보 보기 페이지 실행");
		
		List<UserVO> list = driveInfoService.driveInfoList();
		model.addAttribute("list", list);
		System.out.println(list.get(0));
		
		return "views/common/driveInfo.html";
	}
	
	
	@GetMapping("/driveStatistics")
	public String driveStatistics(Model model) {
		
		System.out.println("운행통계 보기 페이지 실행");
		return "views/common/driveStatistics.html";
	}

}
