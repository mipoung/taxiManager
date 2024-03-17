package com.taxiManager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.taxiManager.vo.CarInfoVO;
import com.taxiManager.vo.DriveInfoVO;
import com.taxiManager.vo.UserVO;

@Mapper
public interface MainDAO {
	List<CarInfoVO> mainList();
	String checkDuplicateId(String id);
	
	
}
