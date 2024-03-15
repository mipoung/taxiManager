package com.taxiManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.taxiManager.service.DriveInfoService;
import com.taxiManager.vo.DriveInfoVO;
import com.taxiManager.vo.UserVO;

import jakarta.servlet.http.HttpServletRequest;

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
			model.addAttribute("result", result);
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
	
	
	@DeleteMapping("/driveInfoDelete/{no}")
	public ResponseEntity<String> driveInfoDelete(@PathVariable("no") String no) {
		
	    int result = driveInfoService.driveInfoDelete(no);
	    System.out.println("============================ 운행정보 삭제하기 ==========================");
	    
	    if (result > 0) {
	        return ResponseEntity.ok().body(result + "개의 운행일지가 삭제 되었습니다.");
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("삭제 실패하였습니다.");
	    }
	}

	
	
	
	@PostMapping("/driveInfoUpdate")
	public String driveInfoUpdate(@PathVariable(required = false) String no, DriveInfoVO dvo, Model model) {
		// if (no != null) {
		//int result = driveInfoService.driveInfoUpdate(no);
		
		// 파라미터로 no 값이 넘어 올 경우(수정 실패해서 리다이렉트될 경우)
		// DriveInfoVO driveInfo = driveInfoService.getDriveInfoByNo(no);
		// model.addAttribute("updateInfo", driveInfo);
		 
		// } else {
			 // 평소와 같이 no값 없이 수정시도할경우
			System.out.println("수정 컨트롤러 실행");
			//model.addAttribute("updateInfo", dvo);
			DriveInfoVO driveInfo = driveInfoService.getDriveInfoByNo(dvo.getNo());
			model.addAttribute("updateInfo", driveInfo);
		// }
		
		return "views/common/driveInfoUpdate";
	}
	
	
	
	
	// ajax를 이용
	@PostMapping("/infoUpdate")
	@ResponseBody
	public ResponseEntity<String> infoUpdate(DriveInfoVO dvo, Model model, HttpServletRequest request) {
		System.out.println("수정 실행");
		System.out.println(dvo.getNetProfit());
		System.out.println(dvo.getNo());
		
		int result = driveInfoService.infoUpdate(dvo);
		System.out.println("수정된 결과 수" + result);
		if(result > 0) {
			System.out.println("성공");
			return ResponseEntity.ok("S");
		} else {
			System.out.println("실패");
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("F");
		}
		
	}
	
	
	/*
	@GetMapping("/driveInfo")
	public String driveInfo(Model model) {
		
		System.out.println("운행정보 보기 페이지 실행");
		
		List<UserVO> list = driveInfoService.driveInfoList();
		model.addAttribute("list", list);
		
		System.out.println("list 값 : " + list.toString());
		
		//System.out.println(list.get(0));
		
		return "views/common/driveInfo.html";
	}
	*/
	
	@GetMapping("/driveInfo")
	public String driveInfo(@PathVariable(required = false) String no, Model model) {
	    if (no != null) {
	        // 주소에 {no} 값이 있을 경우의 처리
	        System.out.println("운행 정보 세부 페이지 보기: " + no);
	        // 해당 no를 이용하여 운행 정보를 검색하고 모델에 추가
	        DriveInfoVO driveInfo = driveInfoService.getDriveInfoByNo(no);
	        model.addAttribute("driveInfo", driveInfo);
	        return "views/common/driveInfo.html";
	        
	    } else {
	        // 주소에 {no} 값이 없을 경우의 기본 처리
	        System.out.println("운행정보 보기 페이지 실행");
	        List<UserVO> list = driveInfoService.driveInfoList();
	        model.addAttribute("list", list);
	        System.out.println("list 값 : " + list.toString());
	        return "views/common/driveInfo.html"; // 기본 페이지로 이동
	    }
	}

	
	
	@GetMapping("/driveStatistics")
	public String driveStatistics(Model model) {
		
		System.out.println("운행통계 보기 페이지 실행");
		return "views/common/driveStatistics.html";
	}

}
