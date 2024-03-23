package com.taxiManager.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.taxiManager.service.DriveInfoService;
import com.taxiManager.vo.CarInfoVO;
import com.taxiManager.vo.DriveInfoVO;
import com.taxiManager.vo.UserVO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class DriveInfoController {
	
	@Autowired
	DriveInfoService driveInfoService;
	

	
	@PostMapping("/driveInfoInsert")
	public String driveInfoInsert(DriveInfoVO dvo, Model model) {
		// 자동자 넘버와 유저아이디로 검사
		int result = driveInfoService.driveInfoChk(dvo);
		// 운행정보 불러오기(이미 있는지 확인하기 위해서)
		System.out.println("운행정보 입력 페이지 실행 \n오늘 날짜로 입력된 값이 있는지 확인 : " + result);
		
		// 이미 해당 날짜에 입력된 값이 있으면 입력 안되고 해당하는 값 조회 페이지로 보내기
		//if(result >= 1) {
			System.out.println("오늘 작성된 운행일지 있음");
			model.addAttribute("carNumber", dvo.getCarNumber());
			model.addAttribute("result", result);
			//return "redirect:/driveInfo";
			
		//}
		return "views/common/driveInfoInsert.html";
	}
	
	// 기록저장 버튼 누르면 기록 저장
	@PostMapping("/infoInsert")
	public String infoInsert(@ModelAttribute DriveInfoVO dvo, RedirectAttributes redirectAttributes) {
		// 입력 받고 운행정보 보기 페이지로 이동
		int result = driveInfoService.infoInsert(dvo);
		
	
		System.out.println("입력된 값 개수 : " + result);
		//리다이렉트로 값 보내는 거 써서 보내기
		
		redirectAttributes.addFlashAttribute("afterInsertInfo", dvo);
		System.out.println(dvo.getCarNumber());
		
		return "redirect:/driveInfo";

	}
	
	// 삭제버튼을 누르면 삭제 실행
	@PostMapping("/driveInfoDelete")
	public String driveInfoDelete(DriveInfoVO dvo, RedirectAttributes redirectAttributes) {
		System.out.println("============================ 운행정보 삭제하기 ==========================");
	    int result = driveInfoService.driveInfoDelete(dvo);
	    redirectAttributes.addFlashAttribute("afterInsertInfo", dvo);
	    redirectAttributes.addFlashAttribute("deleteMsg", result);
		return "redirect:/driveInfo";
	}

	
	
	// 수정 페이지로 이동
	@PostMapping("/driveInfoUpdate")
	public String driveInfoUpdate(DriveInfoVO dvo, Model model) {
		
			System.out.println(" ======================= 수정 페이지로 이동 ===========================");
			DriveInfoVO result = driveInfoService.getDriveInfoByNo(dvo);
			model.addAttribute("updateInfo", result);
			
			
		return "views/common/driveInfoUpdate";
	}
	
	
	

	// 기록 수정하기
	@PostMapping("/infoUpdate")
	//@ResponseBody
	public String infoUpdate(DriveInfoVO dvo, Model model, RedirectAttributes redirectAttributes) {
		System.out.println("수정 실행");
		System.out.println(dvo.getNo());
		
		int result = driveInfoService.infoUpdate(dvo);
		System.out.println("수정된 결과 수" + result);
		
		redirectAttributes.addFlashAttribute("afterInsertInfo", dvo);
		redirectAttributes.addFlashAttribute("updateMsg", result);
		
		// 실패하면?
		if(result < 1) {
			model.addAttribute("updateInfo", dvo); // 입력한 값 그대로 보존해서 전송
			model.addAttribute("updateMsg", "수정에 실패하였습니다.");
			return "views/common/driveInfoUpdate";
		}
		
		
		
		return "redirect:/driveInfo";
		
	}
	
	

	// 운행일지를 조회한다.
	@GetMapping("/driveInfo")
	public String driveInfo(DriveInfoVO dvo, Model model, @ModelAttribute("afterInsertInfo") Optional<DriveInfoVO> dvoOptional) {

			System.out.println("운행정보 보기 페이지 실행");
		 if (dvoOptional.isPresent()) {
            DriveInfoVO dvoInsert = dvoOptional.get();
            List<UserVO> list = driveInfoService.driveInfoList(dvoInsert);
            if(list != null) {
            	 model.addAttribute("list", list);
                 model.addAttribute("insertCarNumber", dvoInsert.getCarNumber());
                 model.addAttribute("insertMsg", "성공적으로 입력되었습니다.");
            } else {
            	model.addAttribute("insertMsg", "입력에 실패하였습니");
            }
           
        } else {
	        List<UserVO> list = driveInfoService.driveInfoList(dvo);
	        model.addAttribute("list", list);
	        model.addAttribute("insertCarNumber", dvo.getCarNumber());
        }
		
	 	return "views/common/driveInfo.html"; // 기본 페이지로 이동
	}

	
	
	@GetMapping("/driveStatistics")
	public String driveStatistics(Model model) {
		
		System.out.println("운행통계 보기 페이지 실행");
		return "views/common/driveStatistics.html";
	}
	
	
	
	
	@GetMapping("/carInsertVw")
	public String carInsertVw(Model model, DriveInfoVO dvo) {
		
		return "views/common/carInsertVw.html";
	}
	
	@PostMapping("/carInsert")
	public String carInsert(Model model, CarInfoVO cvo) {
		
		System.out.println("차량등록페이지 실행");
		System.out.println(cvo.toString());
		int result = driveInfoService.carInsert(cvo);
		
		if(result > 0) {
			model.addAttribute("msg","차량등록에 성공하였습니다.");
		} else {
			model.addAttribute("msg","차량등록에 실패하였습니다.");
		}
		
		return "views/common/infoVw.html";
	}
	
	

}
