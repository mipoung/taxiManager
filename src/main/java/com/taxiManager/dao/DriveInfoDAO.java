package com.taxiManager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.taxiManager.vo.DriveInfoVO;
import com.taxiManager.vo.UserVO;

@Mapper
public interface DriveInfoDAO {
	int infoInsert(DriveInfoVO driveInfoVO);
	int driveInfoChk();
	List<UserVO> driveInfoList();
}
