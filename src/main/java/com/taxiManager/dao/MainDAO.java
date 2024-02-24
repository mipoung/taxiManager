package com.taxiManager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.taxiManager.vo.UserVO;

@Mapper
public interface MainDAO {
	List<UserVO> mainList();
}
