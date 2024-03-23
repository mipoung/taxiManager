package com.taxiManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxiManager.dao.DriveInfoDAO;
import com.taxiManager.vo.CarInfoVO;
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
	public int driveInfoChk(DriveInfoVO dvo) {
		int result = driveInfoDAO.driveInfoChk(dvo);
		return result;
	}

	@Override
	public List<UserVO> driveInfoList(DriveInfoVO dvo) {
		List<UserVO> list = driveInfoDAO.driveInfoList(dvo);
		return list;
	}

	@Override
	public int driveInfoDelete(DriveInfoVO dvo) {
		int result = driveInfoDAO.driveInfoDelete(dvo);
		return result;
	}

	@Override
	public int driveInfoUpdate(String no) {
		int result = driveInfoDAO.driveInfoUpdate(no);
		return result;
	}

	@Override
	public int infoUpdate(DriveInfoVO dvo) {
		int result = driveInfoDAO.infoUpdate(dvo);
		return result;
	}

	@Override
	public DriveInfoVO getDriveInfoByNo(DriveInfoVO dvo) {
		DriveInfoVO result = driveInfoDAO.getDriveInfoByNo(dvo);
		return result;
	}

	@Override
	public int carInsert(CarInfoVO cvo) {
		int result = driveInfoDAO.carInsert(cvo);
		return result;
	}

	
}
