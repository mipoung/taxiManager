package com.taxiManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxiManager.dao.MainDAO;
import com.taxiManager.vo.DriveInfoVO;
import com.taxiManager.vo.UserVO;

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	MainDAO mainDAO;
		
	@Override
	public List<UserVO> mainList() {
		List<UserVO> list = mainDAO.mainList();
		return list;
	}

	

}
