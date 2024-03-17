package com.taxiManager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fasterxml.jackson.databind.ser.std.NumberSerializers.IntegerSerializer;
import com.taxiManager.vo.DriveInfoVO;
import com.taxiManager.vo.UserVO;

@Mapper
public interface DriveInfoDAO {
	int infoInsert(DriveInfoVO driveInfoVO);
	int driveInfoChk();
	List<UserVO> driveInfoList();
	int driveInfoDelete(String no);
	int driveInfoUpdate(String no);
	int infoUpdate(DriveInfoVO dvo);
	DriveInfoVO getDriveInfoByNo(String no);
}
