package com.taven.app.hibernate.dao;

import java.util.List;

import com.taven.app.hibernate.vo.UserInfoVO;

public interface UserInfoDao {

	public List<UserInfoVO> getAllUserInfo();

	public UserInfoVO getUserInfo(String id);

	public UserInfoVO getUserInfoById(String id);

	public void saveJobLog(UserInfoVO vo);

}
