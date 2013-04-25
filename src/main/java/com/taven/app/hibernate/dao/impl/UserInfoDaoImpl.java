package com.taven.app.hibernate.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taven.app.hibernate.dao.UserInfoDao;
import com.taven.app.hibernate.vo.UserInfoVO;

@Service
public class UserInfoDaoImpl extends BaseDaoImpl implements UserInfoDao {

	public List<UserInfoVO> getAllUserInfo() {
		String hql = "from UserInfoVO ";
		TypedQuery<UserInfoVO> query = this.getEntityManager().createQuery(hql, UserInfoVO.class);
		List<UserInfoVO> list = query.getResultList();

		return list;
	}

	public UserInfoVO getUserInfo(String id) {
		return (UserInfoVO) this.getById(UserInfoVO.class, id);
	}

	public UserInfoVO getUserInfoById(String id) {
		String hql = "from UserInfoVO u where u.id=?";
		EntityManager mag = this.getEntityManager();
		return (UserInfoVO) mag.createQuery(hql).setParameter(1, id).getSingleResult();
	}

	@Transactional
	public void saveJobLog(UserInfoVO vo) {
		this.save(vo);
	}

}
