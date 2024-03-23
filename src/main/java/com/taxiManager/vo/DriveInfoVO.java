package com.taxiManager.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class DriveInfoVO {
	
	String no;
	String totalKm; // 총 주행거리
	String carNumber; // 차량번호
	String nowKm; // 현재 주행거리
	String todayIncome; // 오늘 수입
	String todayFuel; // 오늘 연료비
	String netProfit; // 순이익
	String todayMemo; // 오늘 메모
	String user_id; // 유저아이디
	String carInfoNo; // 자동차정보 넘버
	String registTime; // 등록시간
	
	int msg; // 수정, 성공 실패 메세지
	
	
	
	
	
	

	

}
