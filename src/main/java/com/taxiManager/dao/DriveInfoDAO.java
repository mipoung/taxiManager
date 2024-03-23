package com.taxiManager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fasterxml.jackson.databind.ser.std.NumberSerializers.IntegerSerializer;
import com.taxiManager.vo.CarInfoVO;
import com.taxiManager.vo.DriveInfoVO;
import com.taxiManager.vo.UserVO;

@Mapper
public interface DriveInfoDAO {
	int infoInsert(DriveInfoVO dvo);
	int driveInfoChk(DriveInfoVO dvo);
	List<UserVO> driveInfoList(DriveInfoVO dvo);
	int driveInfoDelete(DriveInfoVO dvo);
	int driveInfoUpdate(String no);
	int infoUpdate(DriveInfoVO dvo);
	DriveInfoVO getDriveInfoByNo(DriveInfoVO dvo);
	int carInsert(CarInfoVO cvo);
}
