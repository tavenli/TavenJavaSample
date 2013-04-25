package com.taven.app.hibernate.vo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_USERINFO")
public class UserInfoVO extends IdEntity {

	@Column(name = "user_name")
	private String userName;
	@Column(name = "user_age")
	private int userAge;
	@OneToOne(mappedBy = "userInfo")
	private UserOtherInfoVO userOtherInfoVO;
	//方式1
	//@OneToMany
	//@JoinColumn(name = "user_id")
	//private Set<OrderVO> orderVOs;
	//方式2
	@OneToMany(mappedBy = "userInfo")
	private Set<OrderVO> orderVOs;

	@OneToMany
	@JoinTable(name = "tb_friend_rel", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "friend_id") })
	private Set<FriendVO> friendVOs;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public UserOtherInfoVO getUserOtherInfoVO() {
		return userOtherInfoVO;
	}

	public void setUserOtherInfoVO(UserOtherInfoVO userOtherInfoVO) {
		this.userOtherInfoVO = userOtherInfoVO;
	}

	public Set<FriendVO> getFriendVOs() {
		return friendVOs;
	}

	public void setFriendVOs(Set<FriendVO> friendVOs) {
		this.friendVOs = friendVOs;
	}

	public Set<OrderVO> getOrderVOs() {
		return orderVOs;
	}

	public void setOrderVOs(Set<OrderVO> orderVOs) {
		this.orderVOs = orderVOs;
	}

}
