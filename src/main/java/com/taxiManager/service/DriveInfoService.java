package com.taxiManager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.taxiManager.vo.DriveInfoVO;
import com.taxiManager.vo.UserVO;

@Service
public interface DriveInfoService {
	
	int infoInsert(DriveInfoVO driveInfoVO);
	int driveInfoChk();
	List<UserVO> driveInfoList();
	int driveInfoDelete(String no);
	int driveInfoUpdate(String no);
	int infoUpdate(DriveInfoVO dvo);
	DriveInfoVO getDriveInfoByNo(String no);

}
