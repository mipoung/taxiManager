package com.taxiManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxiManager.dao.MainDAO;
import com.taxiManager.vo.DriveInfoVO;
import com.taxiManager.vo.UserVO;

import groovy.util.logging.Log4j;
import groovy.util.logging.Log4j2;
import groovy.util.logging.Slf4j;

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	MainDAO mainDAO;
		
	@Override
	public List<UserVO> mainList() {
		List<UserVO> list = mainDAO.mainList();
		return list;
	}
	@Override
	public String checkDuplicateId(String id) {
		String result=mainDAO.checkDuplicateId(id);
		System.out.println(id);
		return result != null ? "duplicate" : "available";
	}

	

}
