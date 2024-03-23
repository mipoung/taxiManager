package com.taxiManager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.taxiManager.vo.CarInfoVO;
import com.taxiManager.vo.DriveInfoVO;
import com.taxiManager.vo.UserVO;

@Service
public interface DriveInfoService {
	
	int infoInsert(DriveInfoVO dvo);
	int driveInfoChk(DriveInfoVO dvo);
	List<UserVO> driveInfoList(DriveInfoVO dvo);
	int driveInfoDelete(DriveInfoVO dvo);
	int driveInfoUpdate(String no);
	int infoUpdate(DriveInfoVO dvo);
	DriveInfoVO getDriveInfoByNo(DriveInfoVO dvo);
	int carInsert(CarInfoVO cvo);

}
