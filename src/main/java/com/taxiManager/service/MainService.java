package com.taxiManager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.taxiManager.vo.UserVO;

@Service
public interface MainService {
	
	List<UserVO> mainList();
	
}
