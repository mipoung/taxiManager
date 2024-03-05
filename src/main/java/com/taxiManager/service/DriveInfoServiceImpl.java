package com.taxiManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxiManager.dao.DriveInfoDAO;
import com.taxiManager.vo.DriveInfoVO;
import com.taxiManager.vo.UserVO;

@Service
public class DriveInfoServiceImpl implements DriveInfoService {
	
	@Autowired
	DriveInfoDAO driveInfoDAO;
	
	@Override
	public int infoInsert(DriveInfoVO driveInfoVO) {
		int result = driveInfoDAO.infoInsert(driveInfoVO);
		return result;
	}

	@Override
	public int driveInfoChk() {
		int result = driveInfoDAO.driveInfoChk();
		return result;
	}

	@Override
	public List<UserVO> driveInfoList() {
		List<UserVO> list = driveInfoDAO.driveInfoList();
		return list;
	}
}
